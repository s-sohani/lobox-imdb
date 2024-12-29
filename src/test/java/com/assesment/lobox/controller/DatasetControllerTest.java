package com.assesment.lobox.controller;

import com.assesment.lobox.repository.*;
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
        assertEquals(4, titleBasicsRepository.findAll().size());
    }

    @Test
    public void test_importDataset_nameBasic_ok() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "namebasic.txt",
                MediaType.TEXT_PLAIN_VALUE,
                """
                                        nconst	primaryName	birthYear	deathYear	primaryProfession	knownForTitles
                                        nm0000001	Fred Astaire	1899	1987	actor,miscellaneous,producer	tt0050419,tt0072308,tt0053137,tt0027125
                                        nm0000002	Lauren Bacall	1924	2014	actress,soundtrack,archive_footage	tt0037382,tt0075213,tt0117057,tt0038355
                                        nm0000003	Brigitte Bardot	1934	\\N	actress,music_department,producer	tt0057345,tt0049189,tt0056404,tt0054452
                        """.getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/dataset/import")
                        .file(mockFile).param("type", "NAME_BASICS"))
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
                """
                                        tconst	directors	writers
                                        tt0000001	nm0005690	\\N
                                        tt0000002	nm0721526	\\N
                                        tt0000003	nm0721526	\\N
                                        tt0000004	nm0721526	\\N
                                        tt0000005	nm0005690	\\N
                                        tt0000006	nm0005690	\\N
                                        tt0000007	nm0005690,nm0374658	\\N
                                        tt0000008	nm0005690	\\N
                        """.getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/dataset/import")
                        .file(mockFile).param("type", "TITLE_CREW"))
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
                """
                                        tconst	ordering	nconst	category	job	characters
                                        tt0000001	1	nm1588970	self	\\N	["Self"]
                                        tt0000001	2	nm0005690	director	\\N	\\N
                                        tt0000001	3	nm0005690	producer	producer	\\N
                                        tt0000001	4	nm0374658	cinematographer	director of photography	\\N
                                        tt0000002	1	nm0721526	director	\\N	\\N
                                        tt0000002	2	nm1335271	composer	\\N	\\N
                                        tt0000003	1	nm0721526	director	\\N	\\N
                                        tt0000003	2	nm1770680	producer	producer	\\N
                                        tt0000003	3	nm0721526	producer	producer	\\N
                                        tt0000003	4	nm1335271	composer	\\N	\\N
                                        tt0000003	5	nm5442200	editor	editor	\\N
                        """.getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/dataset/import")
                        .file(mockFile).param("type", "TITLE_PRINCIPALS"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":\"Data Import Successfully\",\"errors\":null}"));
        assertEquals(3, titlePrincipalsRepository.findAll().size());
    }

    @Test
    public void test_importDataset_titleRatings_ok() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "titleRatings.txt",
                MediaType.TEXT_PLAIN_VALUE,
                """
                                        tconst	averageRating	numVotes
                                        tt0000001	5.7	2111
                                        tt0000002	5.6	284
                                        tt0000003	6.4	2139
                                        tt0000004	5.3	182
                                        tt0000005	6.2	2866
                                        tt0000006	5.0	203
                                        tt0000007	5.3	896
                                        tt0000008	5.4	2259
                                        tt0000009	5.4	215
                                        tt0000010	6.8	7801
                                        tt0000011	5.2	407
                                        tt0000012	7.4	13243
                        """.getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/dataset/import")
                        .file(mockFile).param("type", "TITLE_RATINGS"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":\"Data Import Successfully\",\"errors\":null}"));
        assertEquals(12, titleRatingsRepository.findAll().size());
    }

}