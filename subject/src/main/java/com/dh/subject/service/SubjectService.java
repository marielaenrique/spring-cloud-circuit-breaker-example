package com.dh.subject.service;

import com.dh.subject.model.Subject;
import com.dh.subject.repository.ISubjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectService {

    private ISubjectRepository iSubjectRepository;

    public SubjectService(ISubjectRepository iSubjectRepository) {
        this.iSubjectRepository = iSubjectRepository;
    }

    public List<Subject> findAll(Boolean throwError) {
        if (throwError)
            throw new RuntimeException();

        return iSubjectRepository.findAll();
    }

}