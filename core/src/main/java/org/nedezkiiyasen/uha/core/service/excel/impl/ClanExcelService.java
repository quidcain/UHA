package org.nedezkiiyasen.uha.core.service.excel.impl;

import org.nedezkiiyasen.uha.core.service.ClanDocumentService;
import org.nedezkiiyasen.uha.core.service.excel.ExcelService;
import org.springframework.stereotype.Component;

@Component
public class ClanExcelService extends ClanDocumentService implements ExcelService {
    @Override
    public String getSheetName() {
        return "Clans";
    }
}
