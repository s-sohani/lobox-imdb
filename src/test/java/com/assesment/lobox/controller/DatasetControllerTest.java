package com.assesment.lobox.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@SpringBootTest
class DatasetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_import_dataset() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "titlebasic.txt",
                MediaType.TEXT_PLAIN_VALUE,
                """
                                        tconst	titleType	primaryTitle	originalTitle	isAdult	startYear	endYear	runtimeMinutes	genres
                                        tt0000001	short	Carmencita	Carmencita	0	1894	\\N	1	Documentary,Short
                                        tt0000002	short	Le clown et ses chiens	Le clown et ses chiens	0	1892	\\N	5	Animation,Short
                                        tt0000003	short	Poor Pierrot	Pauvre Pierrot	0	1892	\\N	5	Animation,Comedy,Romance
                                        tt0000004	short	Un bon bock	Un bon bock	0	1892	\\N	12	Animation,Short
                        """.getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/dataset/import")
                        .file(mockFile).param("type", "TITLE_BASICS"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":\"Data Import Successfully\",\"errors\":null}"));
    }

}