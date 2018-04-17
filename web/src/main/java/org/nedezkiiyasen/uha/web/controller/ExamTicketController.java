package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.ExamTicketRepository;
import org.nedezkiiyasen.uha.core.dao.QuestionRepository;
import org.nedezkiiyasen.uha.core.model.ExamTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.Stream;

@Controller
@RequestMapping("/examTickets")
public class ExamTicketController extends BaseController<ExamTicket> {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    HttpServletRequest request;

    @Autowired
    public ExamTicketController(ExamTicketRepository examTicketRepository) {
        setRepository(examTicketRepository);
    }

    @GetMapping
    @Override
    public String get(Model model) {
        model.addAttribute(questionRepository.findAll());
        return super.get(model);
    }

    @PostMapping
    @Override
    public String create(@ModelAttribute("form") @Valid ExamTicket examTicket,
                         BindingResult result,
                         RedirectAttributes redirectAttrs) {
        Stream.of(request.getParameterValues("questionIds"))
                .map(Integer::valueOf)
                .map(questionRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(examTicket.getQuestions()::add);
        return super.create(examTicket, result, redirectAttrs);
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
