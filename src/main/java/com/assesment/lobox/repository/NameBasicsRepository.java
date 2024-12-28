package com.assesment.lobox.repository;

import com.assesment.lobox.Entity.NameBasics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NameBasicsRepository extends JpaRepository<NameBasics, String> {
}
