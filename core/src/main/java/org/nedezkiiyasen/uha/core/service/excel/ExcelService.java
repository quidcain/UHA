package org.nedezkiiyasen.uha.core.service.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.nedezkiiyasen.uha.core.document.Document;
import org.nedezkiiyasen.uha.core.service.DocumentService;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.util.List;

public interface ExcelService extends DocumentService {
    int HEADER_LINE_NUMBER = 0;
    int HEADER_INDENT = 1;

    String getSheetName();

    default void write(OutputStream os) {
        Document document = createDocument();
        try(Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(getSheetName());
            writeHeader(sheet, document);
            writeLines(sheet, document);
            workbook.write(os);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    default void writeHeader(Sheet sheet, Document document) {
        Row row = sheet.createRow(HEADER_LINE_NUMBER);
        List<String> headers = document.getHeaders();
        for (int i = 0; i < headers.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(headers.get(i));
        }
    }

    default void writeLines(Sheet sheet, Document document) {
        List<List<String>> lines = document.getLines();
        for (int i = 0; i < lines.size(); i++) {
            Row row = sheet.createRow(i + HEADER_INDENT);//since 1 line is for header
            List<String> line = lines.get(i);
            for (int j = 0; j < line.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(line.get(j));
            }
        }
    }
}
