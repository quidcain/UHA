package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.ClanRepository;
import org.nedezkiiyasen.uha.core.model.Clan;
import org.nedezkiiyasen.uha.core.service.csv.impl.ClanCsvService;
import org.nedezkiiyasen.uha.core.service.excel.impl.ClanExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clans")
public class ClanController extends BaseController<Clan> {
    @Autowired
    public ClanController(ClanRepository clanRepository,
                          ClanCsvService clanCsvService,
                          ClanExcelService clanExcelService) {
        setRepository(clanRepository);
        setCsvService(clanCsvService);
        setExcelService(clanExcelService);
    }

    @Override
    protected Clan createForm() {
        return new Clan();
    }

    @Override
    protected String getSingleViewName() {
        return Clan.class.getSimpleName().toLowerCase();
    }
}
