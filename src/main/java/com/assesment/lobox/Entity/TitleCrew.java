package com.assesment.lobox.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TitleCrew {
    @Id
    private String tconst;
    private String directors;
    private String writers;
}


