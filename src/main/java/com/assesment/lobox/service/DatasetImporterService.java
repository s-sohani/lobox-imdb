package com.assesment.lobox.service;

import com.assesment.lobox.Entity.*;
import com.assesment.lobox.dto.FileTypeImporting;
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

    public void importDataset(MultipartFile file, FileTypeImporting fileTypeImporting) throws IOException {
        var sc = new Scanner(file.getInputStream(), "UTF-8");
        var headerSkipped = false;
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!headerSkipped) {
                headerSkipped = true;
                continue;
            }
            var sp = line.split("\t");
            switch (fileTypeImporting) {
                case TITLE_CREW -> titleCrewRepository.save(new TitleCrew(sp[0], sp[1], sp[2]));
                case NAME_BASICS -> nameBasicsRepository.save(new NameBasics(sp[0], sp[1], convertToInteger(sp[2]), convertToInteger(sp[3]), sp[4], sp[5]));
                case TITLE_BASICS -> titleBasicsRepository.save(new TitleBasics(sp[0], sp[1], sp[2], sp[3], convertToBoolean(sp[4]), convertToInteger(sp[5]), convertToInteger(sp[6]), convertToInteger(sp[7]), sp[8]));
                case TITLE_PRINCIPALS -> titlePrincipalsRepository.save(new TitlePrincipals(sp[0], convertToInteger(sp[1]), sp[2], sp[3], sp[4], sp[5]));
                case TITLE_RATINGS -> titleRatingsRepository.save(new TitleRatings(sp[0], convertToDouble(sp[1]), convertToInteger(sp[2])));
            }
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
        try {
            return Boolean.parseBoolean(str);
        } catch (Exception e) {
            return null;
        }
    }

    private Double convertToDouble(String str){
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return null;
        }
    }
}
