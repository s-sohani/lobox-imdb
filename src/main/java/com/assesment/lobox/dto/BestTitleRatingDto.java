package com.assesment.lobox.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BestTitleRatingDto {
    private String primaryTitle;
    private String averageRating;
    private String numVotes;
    private String startYear;
}
