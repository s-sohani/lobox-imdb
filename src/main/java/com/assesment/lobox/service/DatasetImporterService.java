package com.assesment.lobox.service;

import com.assesment.lobox.Entity.*;
import com.assesment.lobox.dto.FileTypeToImport;
import com.assesment.lobox.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Scanner;

@Service
public class DatasetImporterService {

    @Autowired
    private TitleBasicsRepository titleBasicsRepository;
    @Autowired
    private TitleCrewRepository titleCrewRepository;
    @Autowired
    private NameBasicsRepository nameBasicsRepository;
    @Autowired
    private TitlePrincipalsRepository titlePrincipalsRepository;
    @Autowired
    private TitleRatingsRepository titleRatingsRepository;

    public void importDataset(MultipartFile file, FileTypeToImport fileTypeToImport) throws IOException {
        var sc = new Scanner(file.getInputStream(), "UTF-8");
        var headerSkipped = false;
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!headerSkipped) {
                headerSkipped = true;
                continue;
            }
            saveDBRecord(line, fileTypeToImport);
        }
    }

    private void saveDBRecord(String line, FileTypeToImport fileTypeToImport) {
        var sp = line.split("\t");
        switch (fileTypeToImport) {
            case TITLE_CREW -> titleCrewRepository.save(new TitleCrew(sp[0].trim(), sp[1].trim(), sp[2].trim()));
            case NAME_BASICS -> nameBasicsRepository.save(new NameBasics(sp[0].trim(), sp[1].trim(),
                    convertToInteger(sp[2].trim()), convertToInteger(sp[3].trim()), sp[4].trim(), sp[5].trim()));
            case TITLE_BASICS -> titleBasicsRepository.save(new TitleBasics(sp[0].trim(), sp[1].trim(), sp[2].trim(),
                    sp[3].trim(), convertToBoolean(sp[4].trim()), convertToInteger(sp[5].trim()),
                    convertToInteger(sp[6].trim()), convertToInteger(sp[7].trim()), sp[8].trim()));
            case TITLE_PRINCIPALS -> titlePrincipalsRepository.save(new TitlePrincipals(sp[0].trim(),
                    convertToInteger(sp[1].trim()), sp[2].trim(), sp[3].trim(), sp[4].trim(), sp[5].trim()));
            case TITLE_RATINGS -> titleRatingsRepository.save(new TitleRatings(sp[0].trim(),
                    convertToDouble(sp[1].trim()), convertToInteger(sp[2].trim())));
        }
    }

    private Integer convertToInteger(String str){
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return null;
        }
    }

    private Boolean convertToBoolean(String str){
        return Boolean.parseBoolean(str);
    }

    private Double convertToDouble(String str){
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return null;
        }
    }
}
