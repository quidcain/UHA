package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.ClanRepository;
import org.nedezkiiyasen.uha.core.dao.EptituderRepository;
import org.nedezkiiyasen.uha.core.model.Clan;
import org.nedezkiiyasen.uha.core.model.Eptituder;
import org.nedezkiiyasen.uha.core.service.csv.impl.ClanCsvService;
import org.nedezkiiyasen.uha.core.service.excel.impl.ClanExcelService;
import org.nedezkiiyasen.uha.core.service.pdf.impl.ClanPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/clans")
public class ClanController extends ParentWithChildsController<Clan, Eptituder> {
    @Autowired
    public ClanController(ClanRepository clanRepository,
                          ClanCsvService clanCsvService,
                          ClanExcelService clanExcelService,
                          ClanPdfService clanPdfService,
                          EptituderRepository eptituderRepository) {
        setRepository(clanRepository);
        setCsvService(clanCsvService);
        setExcelService(clanExcelService);
        setPdfService(clanPdfService);
        setChildRepository(eptituderRepository);
    }

    @PostMapping
    @Override
    public String create(@ModelAttribute("form") @Valid Clan clan,
                         BindingResult result,
                         RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
            redirectAttrs.addFlashAttribute("form", clan);
        } else {
            Clan saved = repository.save(clan);
            getChoosedChildsStream()
                    .peek(e -> e.setClan(saved))
                    .forEach(childRepository::save);
        }
        return "redirect:/" + getMultipleViewName();
    }

    @PostMapping(value = "/{id}")
    public String updateDelete(@RequestParam String action,
                               @PathVariable Integer id,
                               @ModelAttribute("form") @Valid Clan clan,
                               BindingResult result,
                               RedirectAttributes redirectAttrs) {
        clan.setEptituders(getChoosedChildsStream()
                .peek(e -> e.setClan(clan))
                .collect(Collectors.toSet()));
        return super.updateDelete(action, id, clan, result, redirectAttrs);
    }

    @Override
    protected String getChildIdsParameter() {
        return "eptituderIds";
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
