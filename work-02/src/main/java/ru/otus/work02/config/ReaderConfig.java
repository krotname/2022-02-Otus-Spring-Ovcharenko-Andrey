package ru.otus.work02.config;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileReader;
import java.io.IOException;

@Configuration
public class ReaderConfig {

    @Value("${app.csv}")
    private String questions;

    @Bean
    public Resource getResource() {
        return new ClassPathResource(questions);
    }

    @Bean
    public CSVParser getCSVParser() {
        return new CSVParserBuilder().withSeparator(';').build();
    }

    @Bean
    public CSVReader getCSVReader(CSVParser csvParser, Resource resource) throws IOException {
        return new CSVReaderBuilder(
                new FileReader(resource.getFile()))
                .withCSVParser(csvParser)
                .withSkipLines(0)
                .build();
    }

}
