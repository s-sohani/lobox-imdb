package com.assesment.lobox.service;

import com.assesment.lobox.dto.BestTitleRatingDto;
import com.assesment.lobox.Entity.NameBasics;
import com.assesment.lobox.Entity.TitleBasics;
import com.assesment.lobox.Entity.TitlePrincipals;
import com.assesment.lobox.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TitleService {
    @Autowired
    private TitleCrewRepository titleCrewRepository;
    @Autowired
    private NameBasicsRepository nameBasicsRepository;
    @Autowired
    private TitlePrincipalsRepository titlePrincipalsRepository;
    @Autowired
    private TitleRatingsRepository titleRatingsRepository;
    @Autowired
    private TitleBasicsRepository titleBasicsRepository;

    public List<TitleBasics> getTitlesWithSameDirectorAndWriter() {
        var titleCrew = titleCrewRepository.findAll().stream()
                .filter(crew -> crew.getDirectors().equals(crew.getWriters()))
                .map(crew -> {
                    NameBasics person = nameBasicsRepository.findById(crew.getDirectors()).orElse(null);
                    return person != null && person.getDeathYear() == null ? crew.getTconst() : null;
                })
                .filter(Objects::nonNull)
                .toList();
        return titleBasicsRepository.findByTconstIn(titleCrew);
    }

    public List<TitleBasics> getTitles(String actor1, String actor2) {
        var actorId1 = nameBasicsRepository.findByPrimaryName(actor1).orElseThrow().getNconst();
        var actorId2 = nameBasicsRepository.findByPrimaryName(actor2).orElseThrow().getNconst();
        var titlesActor1 = titlePrincipalsRepository.findAllByNconst(actorId1)
                .stream().map(TitlePrincipals::getTconst).toList();
        var titlesActor2 = titlePrincipalsRepository.findAllByNconst(actorId2)
                .stream().map(TitlePrincipals::getTconst).toList();
        var sameTconst = titlesActor1.stream().filter(titlesActor2::contains).toList();
        return titleBasicsRepository.findByTconstIn(sameTconst);
    }

    public List<BestTitleRatingDto> getBestTitles(String genre) {
        var bestTitle = titleRatingsRepository.findBestTitlesByGenre(genre);
        return bestTitle.stream()
                .map(m -> new BestTitleRatingDto(String.valueOf(m[0]),String.valueOf(m[1]),String.valueOf(m[2]),String.valueOf(m[3])))
                .collect(Collectors.toList());
    }
}
