package com.assesment.lobox.repository;


import com.assesment.lobox.Entity.TitleBasics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleBasicsRepository extends JpaRepository<TitleBasics, String> {
}
