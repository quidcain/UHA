package org.nedezkiiyasen.uha.core.service.excel.impl;

import org.nedezkiiyasen.uha.core.service.QuestionDocumentService;
import org.nedezkiiyasen.uha.core.service.excel.ExcelService;
import org.springframework.stereotype.Component;

@Component
public class QuestionExcelService extends QuestionDocumentService implements ExcelService {
    @Override
    public String getSheetName() {
        return "Questions";
    }
}
