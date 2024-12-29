package com.assesment.lobox.repository;

import com.assesment.lobox.Entity.TitleRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRatingsRepository extends JpaRepository<TitleRatings, String> {
    @Query("""
    select ss.primaryTitle, sr.averageRating, sr.numVotes, ss.startYear from FROM TitleBasics ss
    JOIN TitleRatings sr ON ss.tconst = sr.tconst
    where ss.tconst in (
    SELECT tb.tconst
    FROM TitleBasics tb
    JOIN TitleRatings tr ON tb.tconst = tr.tconst
    WHERE tb.genres LIKE %:genre% and tb.startYear = ss.startYear
    ORDER BY tb.startYear, tr.numVotes DESC, tr.averageRating DESC
    limit 1)
    """)
    List<Object[]> findBestTitlesByGenre(String genre);
}
