package com.assesment.lobox.repository;

import com.assesment.lobox.entity.TitlePrincipals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitlePrincipalsRepository extends JpaRepository<TitlePrincipals, String> {
    List<TitlePrincipals> findAllByNconst(String nconst);
}