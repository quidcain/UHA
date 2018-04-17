package org.nedezkiiyasen.uha.core.service;

import org.nedezkiiyasen.uha.core.dao.ExamTicketRepository;
import org.nedezkiiyasen.uha.core.document.Document;
import org.nedezkiiyasen.uha.core.mapping.impl.ExamTicketModelToDocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ExamTicketDocumentService implements DocumentService {
    @Autowired
    private ExamTicketRepository examTicketRepository;
    @Autowired
    private ExamTicketModelToDocumentMapper mapper;

    @Override
    public Document createDocument() {
        return mapper.map(examTicketRepository.findAll());
    }
}
