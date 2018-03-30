package org.nedezkiiyasen.uha.core.service.excel.impl;

import org.nedezkiiyasen.uha.core.service.EventDocumentService;
import org.nedezkiiyasen.uha.core.service.excel.ExcelService;
import org.springframework.stereotype.Component;

@Component
public class EventExcelService extends EventDocumentService implements ExcelService {
    @Override
    public String getSheetName() {
        return "Events";
    }
}
