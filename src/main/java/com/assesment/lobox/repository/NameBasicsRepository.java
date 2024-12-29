package com.assesment.lobox.repository;

import com.assesment.lobox.entity.NameBasics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NameBasicsRepository extends JpaRepository<NameBasics, String> {
    Optional<NameBasics> findByPrimaryName(String primaryName);
}
