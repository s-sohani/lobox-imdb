package com.assesment.lobox.controller;

import com.assesment.lobox.dto.ResponseDto;
import com.assesment.lobox.service.TitleService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/titles")
@Log4j2
public class TitleController {
    @Autowired
    private TitleService titleService;
    private final Counter numOfCall = Metrics.counter("lobox.title.numOfCall");

    @GetMapping("/same-director-writer")
    public ResponseEntity<ResponseDto> getTitlesWithSameDirectorAndWriter() {
        numOfCall.increment();
        try {
            return ResponseEntity
                    .ok(ResponseDto.builder().result(titleService.getTitlesWithSameDirectorAndWriter())
                    .build());
        } catch (Exception e) {
            log.error("Error while getting title with same directors and writers.", e);
            return ResponseEntity
                    .ok(ResponseDto.builder().errors("Error while getting title with same directors and writers.")
                            .build());
        }
    }
    @GetMapping("/common-titles")
    public ResponseEntity<ResponseDto> getCommonTitles(
            @RequestParam String actor1,
            @RequestParam String actor2) {
        numOfCall.increment();
        try {
            return ResponseEntity
                    .ok(ResponseDto.builder().result(titleService.getTitles(actor1, actor2))
                            .build());
        } catch (Exception e) {
            log.error("Error while getting title from given actors.", e);
            return ResponseEntity
                    .ok(ResponseDto.builder().errors("Error while getting title from given actors.")
                            .build());
        }
    }

    @GetMapping("/best-titles-by-genre")
    public ResponseEntity<ResponseDto> getBestTitlesByGenre(@RequestParam String genre) {
        numOfCall.increment();
        try {
            return ResponseEntity
                    .ok(ResponseDto.builder().result(titleService.getBestTitles(genre))
                            .build());
        } catch (Exception e) {
            log.error("Error while getting best titels from given genre.", e);
            return ResponseEntity
                    .ok(ResponseDto.builder().errors("Error while getting best titels from given genre.")
                            .build());
        }
    }
}
