package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.QuestionRepository;
import org.nedezkiiyasen.uha.core.model.Question;
import org.nedezkiiyasen.uha.core.service.csv.impl.QuestionCsvService;
import org.nedezkiiyasen.uha.core.service.excel.impl.QuestionExcelService;
import org.nedezkiiyasen.uha.core.service.pdf.impl.QuestionPdfService;
import org.nedezkiiyasen.uha.web.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController extends BaseController<Question, QuestionDto> {
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
    protected Class<Question> getEntityClass() {
        return Question.class;
    }

    @Override
    protected Class<QuestionDto> getDtoClass() {
        return QuestionDto.class;
    }

    @Override
    protected String getViewName() {
        return "questions";
    }
}
