package com.assesment.lobox.controller;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MetricController {
    PrometheusMeterRegistry prometheusRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);

    public MetricController() {
        Metrics.addRegistry(prometheusRegistry);
    }

    @GetMapping(value = "/metrics", produces = "text/plain")
    public ResponseEntity<String> metrics() {

        var response = prometheusRegistry.scrape();
        return ResponseEntity.ok(response);
    }
}
