package org.nedezkiiyasen.uha.core.service;

import org.nedezkiiyasen.uha.core.dao.QuestionRepository;
import org.nedezkiiyasen.uha.core.document.Document;
import org.nedezkiiyasen.uha.core.mapping.impl.QuestionModelToDocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class QuestionDocumentService implements DocumentService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionModelToDocumentMapper mapper;

    @Override
    public Document createDocument() {
        return mapper.map(questionRepository.findAll());
    }
}
