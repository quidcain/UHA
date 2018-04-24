package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.ClanRepository;
import org.nedezkiiyasen.uha.core.model.Clan;
import org.nedezkiiyasen.uha.core.service.csv.impl.ClanCsvService;
import org.nedezkiiyasen.uha.core.service.excel.impl.ClanExcelService;
import org.nedezkiiyasen.uha.core.service.pdf.impl.ClanPdfService;
import org.nedezkiiyasen.uha.web.dto.ClanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clans")
public class ClanController extends BaseController<Clan, ClanDto> {
    @Autowired
    public ClanController(ClanRepository clanRepository,
                          ClanCsvService clanCsvService,
                          ClanExcelService clanExcelService,
                          ClanPdfService clanPdfService) {
        setRepository(clanRepository);
        setCsvService(clanCsvService);
        setExcelService(clanExcelService);
        setPdfService(clanPdfService);
    }

    @Override
    protected Class<Clan> getEntityClass() {
        return Clan.class;
    }

    @Override
    protected Class<ClanDto> getDtoClass() {
        return ClanDto.class;
    }

    @Override
    protected Clan toEntity(ClanDto dto) {
        Clan clan = super.toEntity(dto);
        //clan.getEptituders().forEach(e -> e.getClan().setId(clan.getId()));
        return clan;
    }

    @Override
    protected String getViewName() {
        return "clans";
    }
}
