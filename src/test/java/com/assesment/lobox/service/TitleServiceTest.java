package com.assesment.lobox.service;

import com.assesment.lobox.dto.FileTypeToImport;
import com.assesment.lobox.utils.SampleData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TitleServiceTest {
    @Autowired
    private TitleService titleService;
    
    @Autowired
    private DatasetImporterService datasetImporterService;
    boolean headerSkipped = false;

    @BeforeEach
    public void initData() throws NoSuchMethodException {
        Method privateMethod = DatasetImporterService.class.getDeclaredMethod("saveDBRecord", String.class, FileTypeToImport.class);
        privateMethod.setAccessible(true);

        headerSkipped = false;
        Arrays.stream(SampleData.TITLE_RATING.trim().split("\n")).forEach(line -> {
            try {
                if (!headerSkipped) {
                    headerSkipped = true;
                } else {
                privateMethod.invoke(datasetImporterService, line, FileTypeToImport.TITLE_RATINGS);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        headerSkipped = false;
        Arrays.stream(SampleData.TITLE_CREW.trim().split("\n")).forEach(line -> {
            try {
                if (!headerSkipped) {
                    headerSkipped = true;
                } else {
                    privateMethod.invoke(datasetImporterService, line, FileTypeToImport.TITLE_CREW);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        headerSkipped = false;
        Arrays.stream(SampleData.TITLE_PRINCIPALS.trim().split("\n")).forEach(line -> {
            try {
                if (!headerSkipped) {
                    headerSkipped = true;
                } else {
                    privateMethod.invoke(datasetImporterService, line, FileTypeToImport.TITLE_PRINCIPALS);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        headerSkipped = false;
        Arrays.stream(SampleData.TITLE_BASIC.trim().split("\n")).forEach(line -> {
            try {
                if (!headerSkipped) {
                    headerSkipped = true;
                } else {
                    privateMethod.invoke(datasetImporterService, line, FileTypeToImport.TITLE_BASICS);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        headerSkipped = false;
        Arrays.stream(SampleData.NAME_BASIC.trim().split("\n")).forEach(line -> {
            try {
                if (!headerSkipped) {
                    headerSkipped = true;
                } else {
                    privateMethod.invoke(datasetImporterService, line, FileTypeToImport.NAME_BASICS);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        

    }

    @Test
    public void test_getTitlesWithSameDirectorAndWriter_withoutInput_returnOk() {
        var res = titleService.getTitlesWithSameDirectorAndWriter();
        assertEquals(2, res.size());
        assertFalse(res.stream().filter(f->f.getTconst().equals("tt0000005")).collect(Collectors.toList()).isEmpty());
    }

    @Test
    public void test_getTitles_validInput_ok() {
        var res = titleService.getTitles("Lauren Bacall", "Brigitte Bardot");
        assertEquals(1, res.size());
        assertFalse(res.stream().filter(f->f.getTconst().equals("tt0000001")).collect(Collectors.toList()).isEmpty());
    }

    //Short
    @Test
    public void test_getBestTitles_validInput_ok() {
        var res = titleService.getBestTitles("Short");
        assertEquals(2, res.size());
        assertFalse(res.stream().filter(f->f.getPrimaryTitle().equals("Carmencita")).collect(Collectors.toList()).isEmpty());
        assertFalse(res.stream().filter(f->f.getPrimaryTitle().equals("Poor Pierrot")).collect(Collectors.toList()).isEmpty());
    }
}