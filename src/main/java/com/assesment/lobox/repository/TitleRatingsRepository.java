package com.assesment.lobox.repository;

import com.assesment.lobox.Entity.TitleRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRatingsRepository extends JpaRepository<TitleRatings, String> {

}
