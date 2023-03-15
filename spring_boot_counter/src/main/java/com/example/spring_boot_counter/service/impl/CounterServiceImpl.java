package com.example.spring_boot_counter.service.impl;

import com.example.spring_boot_counter.service.CounterService;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Getter
@Setter
public class CounterServiceImpl implements CounterService {

    @Value("${pathToFile}")
    private String path;

    @PostConstruct
    public void addFile() {

        if (Files.notExists(Path.of(path))) {
            try {
                Files.createFile(Path.of(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    @PreDestroy
    public void countRuns() {
        try {
            String line = Files.readString(Path.of(path));
            if (StringUtils.isNotBlank(line)) {
                int count = Integer.parseInt(line);
                Files.writeString(Path.of(path), String.valueOf(++count));
            } else {
                Files.writeString(Path.of(path), String.valueOf(1));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}