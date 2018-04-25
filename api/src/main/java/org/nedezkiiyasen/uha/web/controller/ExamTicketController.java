package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.ExamTicketRepository;
import org.nedezkiiyasen.uha.core.model.ExamTicket;
import org.nedezkiiyasen.uha.core.service.csv.impl.ExamTicketCsvService;
import org.nedezkiiyasen.uha.core.service.excel.impl.ExamTicketExcelService;
import org.nedezkiiyasen.uha.core.service.pdf.impl.ExamTicketPdfService;
import org.nedezkiiyasen.uha.web.dto.ExamTicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examTickets")
public class ExamTicketController extends BaseController<ExamTicket, ExamTicketDto> {

    @Autowired
    public ExamTicketController(ExamTicketRepository examTicketRepository,
                                ExamTicketCsvService examTicketCsvService,
                                ExamTicketExcelService examTicketExcelService,
                                ExamTicketPdfService examTicketPdfService) {
        setRepository(examTicketRepository);
        setCsvService(examTicketCsvService);
        setExcelService(examTicketExcelService);
        setPdfService(examTicketPdfService);
    }

    @Override
    protected Class<ExamTicket> getEntityClass() {
        return ExamTicket.class;
    }

    @Override
    protected Class<ExamTicketDto> getDtoClass() {
        return ExamTicketDto.class;
    }

    @Override
    protected String getViewName() {
        return "examTickets";
    }
}
