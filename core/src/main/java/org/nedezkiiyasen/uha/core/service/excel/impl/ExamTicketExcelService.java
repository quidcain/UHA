package org.nedezkiiyasen.uha.core.service.excel.impl;

import org.nedezkiiyasen.uha.core.service.ExamTicketDocumentService;
import org.nedezkiiyasen.uha.core.service.excel.ExcelService;
import org.springframework.stereotype.Component;

@Component
public class ExamTicketExcelService extends ExamTicketDocumentService implements ExcelService {
    @Override
    public String getSheetName() {
        return "Exam Tickets";
    }
}
