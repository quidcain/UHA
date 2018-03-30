package org.nedezkiiyasen.uha.core.service;

import org.nedezkiiyasen.uha.core.dao.EptituderRepository;
import org.nedezkiiyasen.uha.core.document.Document;
import org.nedezkiiyasen.uha.core.mapping.impl.EptituderModelToDocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class EptituderDocumentService implements DocumentService {
    @Autowired
    private EptituderRepository eptituderRepository;
    @Autowired
    private EptituderModelToDocumentMapper mapper;

    public Document createDocument() {
        return mapper.map(eptituderRepository.findAll());
    }
}
