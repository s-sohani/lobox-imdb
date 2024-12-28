package com.assesment.lobox.repository;

import com.assesment.lobox.Entity.TitlePrincipals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitlePrincipalsRepository extends JpaRepository<TitlePrincipals, String> {
}