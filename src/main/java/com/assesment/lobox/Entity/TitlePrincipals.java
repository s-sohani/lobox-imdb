package com.assesment.lobox.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class TitlePrincipals {
    @Id
    private String tconst;
    @Id
    private Integer ordering;
    private String nconst;
    private String category;
    private String job;
    private String characters;
}