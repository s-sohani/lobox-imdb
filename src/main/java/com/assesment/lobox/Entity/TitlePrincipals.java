package com.assesment.lobox.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(TitlePrincipalCompositeKye.class)
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