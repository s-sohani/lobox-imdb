package com.assesment.lobox.controller;

import com.assesment.lobox.dto.FileTypeToImport;
import com.assesment.lobox.dto.ResponseDto;
import com.assesment.lobox.service.DatasetImporterService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/dataset")
public class DatasetController {
    @Autowired
    private DatasetImporterService datasetImporterService;
    private final Counter numOfCall = Metrics.counter("lobox.dataset.numOfCall");

    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseDto> importDataset(
            @RequestPart("file") MultipartFile file,
            @RequestParam("fileTypeToImport") FileTypeToImport fileTypeToImport) {
        numOfCall.increment();
        try {
            datasetImporterService.importDataset(file, fileTypeToImport);
            return ResponseEntity.ok(ResponseDto.builder().result("Data Import Successfully").build());
        } catch (Exception e) {
            return ResponseEntity.ok(ResponseDto.builder().errors("Error while inserting data to database").build());
        }
    }
}
