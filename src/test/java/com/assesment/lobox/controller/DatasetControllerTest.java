package com.assesment.lobox.controller;

import com.assesment.lobox.repository.*;
import com.assesment.lobox.utils.SampleData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@SpringBootTest
class DatasetControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TitleBasicsRepository titleBasicsRepository;
    @Autowired
    private NameBasicsRepository nameBasicsRepository;
    @Autowired
    private TitleCrewRepository titleCrewRepository;
    @Autowired
    private TitlePrincipalsRepository titlePrincipalsRepository;
    @Autowired
    private TitleRatingsRepository titleRatingsRepository;

    @Test
    public void test_importDataset_titleBasic_ok() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "titlebasic.txt",
                MediaType.TEXT_PLAIN_VALUE,
                SampleData.TITLE_BASIC.getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/dataset/import")
                        .file(mockFile).param("fileTypeToImport", "TITLE_BASICS"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":\"Data Import Successfully\",\"errors\":null}"));
        assertEquals(4, titleBasicsRepository.findAll().size());
    }

    @Test
    public void test_importDataset_nameBasic_ok() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "namebasic.txt",
                MediaType.TEXT_PLAIN_VALUE,
                SampleData.NAME_BASIC.getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/dataset/import")
                        .file(mockFile).param("fileTypeToImport", "NAME_BASICS"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":\"Data Import Successfully\",\"errors\":null}"));
        assertEquals(3, nameBasicsRepository.findAll().size());
    }

    @Test
    public void test_importDataset_titleCrew_ok() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "titleCrew.txt",
                MediaType.TEXT_PLAIN_VALUE,
                SampleData.TITLE_CREW.getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/dataset/import")
                        .file(mockFile).param("fileTypeToImport", "TITLE_CREW"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":\"Data Import Successfully\",\"errors\":null}"));
        assertEquals(8, titleCrewRepository.findAll().size());
    }

    @Test
    public void test_importDataset_titlePrincipals_ok() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "titlePrincipal.txt",
                MediaType.TEXT_PLAIN_VALUE,
                SampleData.TITLE_PRINCIPALS.getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/dataset/import")
                        .file(mockFile).param("fileTypeToImport", "TITLE_PRINCIPALS"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":\"Data Import Successfully\",\"errors\":null}"));
        assertEquals(11, titlePrincipalsRepository.findAll().size());
    }

    @Test
    public void test_importDataset_titleRatings_ok() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "titleRatings.txt",
                MediaType.TEXT_PLAIN_VALUE,
                SampleData.TITLE_RATING.getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/dataset/import")
                        .file(mockFile).param("fileTypeToImport", "TITLE_RATINGS"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":\"Data Import Successfully\",\"errors\":null}"));
        assertEquals(12, titleRatingsRepository.findAll().size());
    }

}