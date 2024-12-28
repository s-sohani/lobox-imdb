package com.assesment.lobox.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TitleRatings {
    @Id
    private String tconst;
    private Double averageRating;
    private Integer numVotes;
}
