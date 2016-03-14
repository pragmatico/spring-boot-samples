package com.example.config;


import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.ExportMetricReader;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.reader.MetricReader;
import org.springframework.boot.actuate.metrics.reader.MetricRegistryMetricReader;
import org.springframework.boot.actuate.metrics.statsd.StatsdMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableMetrics(proxyTargetClass = true)
public class MetricsConfig extends MetricsConfigurerAdapter {

    private static final Logger LOGGER = LogManager.getLogger();

    @Value("${spring.application.name:application}")
    private String prefix;

    @Value("${spring.metrics.export.statsd.host}")
    private String host;

    @Value("${spring.metrics.export.statsd.port}")
    private int port;

    @Autowired
    private MetricRegistry metricRegistry;

    @Bean
    @ExportMetricReader
    public MetricReader metricReader() {
        return new MetricRegistryMetricReader(metricRegistry);
    }

    @Bean
    @ExportMetricWriter
    public MetricWriter metricWriter() {
        LOGGER.info("Configuring StatsdMetricWriter to export with prefix {} to {}:{}", prefix, host, port);
        return new StatsdMetricWriter(prefix, host, port);
    }

}
