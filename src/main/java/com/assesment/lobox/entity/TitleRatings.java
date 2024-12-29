package com.assesment.lobox.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitleRatings {
    @Id
    private String tconst;
    private Double averageRating;
    private Integer numVotes;
}
