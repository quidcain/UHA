package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.EptituderRepository;
import org.nedezkiiyasen.uha.core.model.Eptituder;
import org.nedezkiiyasen.uha.core.service.csv.impl.EptituderCsvService;
import org.nedezkiiyasen.uha.core.service.excel.impl.EptituderExcelService;
import org.nedezkiiyasen.uha.core.service.pdf.impl.EptituderPdfService;
import org.nedezkiiyasen.uha.web.dto.EptituderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eptituders")
public class EptituderController extends BaseController<Eptituder, EptituderDto> {
    @Autowired
    public EptituderController(EptituderRepository eptituderRepository,
                               EptituderCsvService eptituderCsvService,
                               EptituderExcelService eptituderExcelService,
                               EptituderPdfService eptituderPdfService) {
        setRepository(eptituderRepository);
        setCsvService(eptituderCsvService);
        setExcelService(eptituderExcelService);
        setPdfService(eptituderPdfService);
    }

    @Override
    protected Class<Eptituder> getEntityClass() {
        return Eptituder.class;
    }

    @Override
    protected Class<EptituderDto> getDtoClass() {
        return EptituderDto.class;
    }

    @Override
    protected String getViewName() {
        return "eptituders";
    }
}
