package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.EptituderRepository;
import org.nedezkiiyasen.uha.core.model.Eptituder;
import org.nedezkiiyasen.uha.core.service.csv.impl.EptituderCsvService;
import org.nedezkiiyasen.uha.core.service.excel.impl.EptituderExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eptituders")
public class EptituderController extends BaseController<Eptituder> {
    @Autowired
    public EptituderController(EptituderRepository eptituderRepository,
                               EptituderCsvService eptituderCsvService,
                               EptituderExcelService eptituderExcelService) {
        setRepository(eptituderRepository);
        setCsvService(eptituderCsvService);
        setExcelService(eptituderExcelService);
    }

    @Override
    protected Eptituder createForm() {
        return new Eptituder();
    }

    @Override
    protected String getSingleViewName() {
        return Eptituder.class.getSimpleName().toLowerCase();
    }
}
