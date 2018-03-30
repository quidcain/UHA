package org.nedezkiiyasen.uha.core.service;

import org.nedezkiiyasen.uha.core.dao.EventRepository;
import org.nedezkiiyasen.uha.core.document.Document;
import org.nedezkiiyasen.uha.core.mapping.impl.EventModelToDocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class EventDocumentService implements DocumentService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventModelToDocumentMapper mapper;

    public Document createDocument() {
        return mapper.map(eventRepository.findAll());
    }
}
