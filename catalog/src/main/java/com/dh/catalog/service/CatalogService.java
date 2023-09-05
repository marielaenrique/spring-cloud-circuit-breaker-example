package com.dh.catalog.service;

import com.dh.catalog.model.Subject;
import com.dh.catalog.repository.SubjectRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CatalogService {

    private SubjectRepository subjectRepository;

    @Autowired
    public CatalogService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @CircuitBreaker(name = "subjects", fallbackMethod = "findAllEmpty")
    @Retry(name = "subjects")
    public List<Subject> findAll() {
        log.info("Calling subject service...");
        return subjectRepository.findAll(true);
    }

    private List<Subject> findAllEmpty(CallNotPermittedException exception) {
        return new ArrayList<>();
    }

}