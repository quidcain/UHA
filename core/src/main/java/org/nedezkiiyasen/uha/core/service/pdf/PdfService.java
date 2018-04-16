package org.nedezkiiyasen.uha.core.service.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.nedezkiiyasen.uha.core.document.Document;
import org.nedezkiiyasen.uha.core.service.DocumentService;

import java.io.OutputStream;
import java.util.Collection;

public interface PdfService extends DocumentService {
    Font FONT = FontFactory.getFont("DejaVuSans.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

    default void write(OutputStream os) {
        Document document = createDocument();
        com.itextpdf.text.Document pdfDocument = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(pdfDocument, os);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        pdfDocument.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 26, BaseColor.MAGENTA);
        Chunk chunk = new Chunk("UHA", font);
        try {
            pdfDocument.add(chunk);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        PdfPTable table = new PdfPTable(document.getHeaders().size());
        addTableHeader(table, document);
        addRows(table, document);
        try {
            pdfDocument.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        pdfDocument.close();
    }

    default void addTableHeader(PdfPTable table, Document document) {
        document.getHeaders().forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle, FONT));
            table.addCell(header);
        });
    }

    default void addRows(PdfPTable table, Document document) {
        document.getLines().stream()
                .flatMap(Collection::stream)
                .forEach(line -> {
                    PdfPCell cell = new PdfPCell();
                    cell.setBackgroundColor(BaseColor.WHITE);
                    cell.setBorderWidth(2);
                    cell.setPhrase(new Phrase(line, FONT));
                    table.addCell(cell);
                });
    }
}
