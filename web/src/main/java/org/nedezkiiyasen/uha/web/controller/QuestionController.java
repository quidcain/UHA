package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.QuestionRepository;
import org.nedezkiiyasen.uha.core.model.Question;
import org.nedezkiiyasen.uha.core.service.csv.impl.QuestionCsvService;
import org.nedezkiiyasen.uha.core.service.excel.impl.QuestionExcelService;
import org.nedezkiiyasen.uha.core.service.pdf.impl.QuestionPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionController extends BaseController<Question> {
    @Autowired
    public QuestionController(QuestionRepository questionRepository,
                              QuestionCsvService questionCsvService,
                              QuestionExcelService questionExcelService,
                              QuestionPdfService questionPdfService) {
        setRepository(questionRepository);
        setCsvService(questionCsvService);
        setExcelService(questionExcelService);
        setPdfService(questionPdfService);
    }

    @Override
    protected Question createForm() {
        return new Question();
    }

    @Override
    protected String getSingleViewName() {
        return Question.class.getSimpleName().toLowerCase();
    }
}
