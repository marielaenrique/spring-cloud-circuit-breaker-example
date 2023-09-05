package com.dh.catalog.repository;

import com.dh.catalog.model.Subject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient(name = "subject-service")
public interface SubjectRepository {
    @GetMapping("/subject/findAll")
    List<Subject> findAll(@RequestParam Boolean throwError);

}