package org.nedezkiiyasen.uha.core.service.excel.impl;

import org.nedezkiiyasen.uha.core.service.EptituderDocumentService;
import org.nedezkiiyasen.uha.core.service.excel.ExcelService;
import org.springframework.stereotype.Component;

@Component
public class EptituderExcelService extends EptituderDocumentService implements ExcelService {
    @Override
    public String getSheetName() {
        return "Eptituders";
    }
}
