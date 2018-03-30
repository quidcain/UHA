package org.nedezkiiyasen.uha.core.service;

import org.nedezkiiyasen.uha.core.dao.ClanRepository;
import org.nedezkiiyasen.uha.core.document.Document;
import org.nedezkiiyasen.uha.core.mapping.impl.ClanModelToDocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClanDocumentService implements DocumentService {
    @Autowired
    private ClanRepository clanRepository;
    @Autowired
    private ClanModelToDocumentMapper mapper;

    public Document createDocument() {
        return mapper.map(clanRepository.findAll());
    }
}
