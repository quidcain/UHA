package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.ExamTicketRepository;
import org.nedezkiiyasen.uha.core.dao.QuestionRepository;
import org.nedezkiiyasen.uha.core.model.ExamTicket;
import org.nedezkiiyasen.uha.core.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/examTickets")
public class ExamTicketController extends BaseController<ExamTicket> {
    private String[] EMPTY_STRING_ARRAY = new String[0];

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
        getQuestionStream().forEach(examTicket.getQuestions()::add);
        return super.create(examTicket, result, redirectAttrs);
    }

    @GetMapping(value = "/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute(questionRepository.findAll());
        return super.getById(id, model);
    }

    @PostMapping(value = "/{id}")
    public String updateDelete(@RequestParam String action,
                               @PathVariable Integer id,
                               @ModelAttribute("form") @Valid ExamTicket examTicket,
                               BindingResult result,
                               RedirectAttributes redirectAttrs) {
        examTicket.setQuestions(getQuestionStream()
                .collect(Collectors.toSet()));
        return super.updateDelete(action, id, examTicket, result, redirectAttrs);
    }

    private Stream<Question> getQuestionStream() {
        return Stream.of(Optional.ofNullable(
                request.getParameterValues("questionIds"))
                .orElseGet(() -> EMPTY_STRING_ARRAY))
                .map(Integer::parseInt)
                .map(questionRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get);
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
