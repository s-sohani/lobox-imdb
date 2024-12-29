package com.assesment.lobox.repository;

import com.assesment.lobox.Entity.TitleCrew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleCrewRepository extends JpaRepository<TitleCrew, String> {

    @Query("SELECT tc1 FROM TitleCrew tc1 WHERE tc1.directors = tc1.writers")
    List<TitleCrew[]> findSameDirectorAndWriter();
}
