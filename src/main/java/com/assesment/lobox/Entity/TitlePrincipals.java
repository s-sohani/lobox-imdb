package com.assesment.lobox.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitlePrincipals {
    @Id
    private String tconst;
    private Integer ordering;
    private String nconst;
    private String category;
    private String job;
    private String characters;
}