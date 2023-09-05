package com.dh.subject.controller;

import com.dh.subject.model.Subject;
import com.dh.subject.service.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/findAll")
    public List<Subject> findAll(@RequestParam(defaultValue = "true") Boolean throwError) {
        return subjectService.findAll(throwError);
    }

}