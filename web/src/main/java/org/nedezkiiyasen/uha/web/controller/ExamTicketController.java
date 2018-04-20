package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.ExamTicketRepository;
import org.nedezkiiyasen.uha.core.dao.QuestionRepository;
import org.nedezkiiyasen.uha.core.model.ExamTicket;
import org.nedezkiiyasen.uha.core.model.Question;
import org.nedezkiiyasen.uha.core.service.csv.impl.ExamTicketCsvService;
import org.nedezkiiyasen.uha.core.service.excel.impl.ExamTicketExcelService;
import org.nedezkiiyasen.uha.core.service.pdf.impl.ExamTicketPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/examTickets")
    public class ExamTicketController extends ParentWithChildsController<ExamTicket, Question> {

    @Autowired
    public ExamTicketController(ExamTicketRepository examTicketRepository,
                                ExamTicketCsvService examTicketCsvService,
                                ExamTicketExcelService examTicketExcelService,
                                ExamTicketPdfService examTicketPdfService,
                                QuestionRepository questionRepository) {
        setRepository(examTicketRepository);
        setCsvService(examTicketCsvService);
        setExcelService(examTicketExcelService);
        setPdfService(examTicketPdfService);
        setChildRepository(questionRepository);
    }

    @PostMapping
    @Override
    public String create(@ModelAttribute("form") @Valid ExamTicket examTicket,
                         BindingResult result,
                         RedirectAttributes redirectAttrs) {
        getChoosedChildsStream().forEach(examTicket.getQuestions()::add);
        return super.create(examTicket, result, redirectAttrs);
    }

    @PostMapping(value = "/{id}")
    public String updateDelete(@RequestParam String action,
                               @PathVariable Integer id,
                               @ModelAttribute("form") @Valid ExamTicket examTicket,
                               BindingResult result,
                               RedirectAttributes redirectAttrs) {
        examTicket.setQuestions(getChoosedChildsStream()
                .collect(Collectors.toSet()));
        return super.updateDelete(action, id, examTicket, result, redirectAttrs);
    }

    @Override
    protected String getChildIdsParameter() {
        return "questionIds";
    }

    @Override
    protected ExamTicket createForm() {
        return new ExamTicket();
    }

    @Override
    protected String getSingleViewName() {
        return "examTicket";
    }
}
