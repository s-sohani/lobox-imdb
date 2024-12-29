package com.assesment.lobox.utils;

public class SampleData {
    public static String TITLE_BASIC = """
                                        tconst	titleType	primaryTitle	originalTitle	isAdult	startYear	endYear	runtimeMinutes	genres
                                        tt0000001	short	Carmencita	Carmencita	0	1894	\\N	1	Documentary,Short
                                        tt0000002	short	Le clown et ses chiens	Le clown et ses chiens	0	1892	\\N	5	Animation,Short
                                        tt0000005	short	Poor Pierrot	Pauvre Pierrot	0	1892	\\N	5	Animation,Comedy,Romance,Short
                                        tt0000008	short	Un bon bock	Un bon bock	0	1892	\\N	12	Animation,Short
                        """;
    public static String NAME_BASIC = """
                                        nconst	primaryName	birthYear	deathYear	primaryProfession	knownForTitles
                                        nm0000001	Fred Astaire	1899	1987	actor,miscellaneous,producer	tt0050419,tt0072308,tt0053137,tt0027125
                                        nm0721526	Lauren Bacall	1924	2014	actress,soundtrack,archive_footage	tt0037382,tt0075213,tt0117057,tt0038355
                                        nm0005690	Brigitte Bardot	1934	\\N	actress,music_department,producer	tt0057345,tt0049189,tt0056404,tt0054452
                        """;
    public static String TITLE_CREW = """
                                        tconst	directors	writers
                                        tt0000001	nm0005690	nm0721526
                                        tt0000002	nm0721526	nm0005690
                                        tt0000003	nm0721526	\\N
                                        tt0000004	nm0721526	\\N
                                        tt0000005	nm0005690	nm0005690
                                        tt0000006	nm0005690	\\N
                                        tt0000007	nm0005690,nm0374658	\\N
                                        tt0000008	nm0005690	nm0005690
                        """;
    public static String TITLE_PRINCIPALS = """
                                        tconst	ordering	nconst	category	job	characters
                                        tt0000001	1	nm0005690	self	\\N	["Self"]
                                        tt0000001	2	nm0005691	director	\\N	\\N
                                        tt0000001	3	nm0005692	producer	producer	\\N
                                        tt0000001	4	nm0721526	cinematographer	director of photography	\\N
                                        tt0000002	1	nm0721526	director	\\N	\\N
                                        tt0000002	2	nm1335271	composer	\\N	\\N
                                        tt0000003	1	nm0721520	director	\\N	\\N
                                        tt0000003	2	nm0721527	producer	producer	\\N
                                        tt0000003	3	nm0721528	producer	producer	\\N
                                        tt0000003	4	nm0005690	composer	\\N	\\N
                                        tt0000003	5	nm0721529	editor	editor	\\N
                        """;
    public static String TITLE_RATING = """
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
                        """;
}
