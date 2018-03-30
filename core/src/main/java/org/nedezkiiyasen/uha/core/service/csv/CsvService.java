package org.nedezkiiyasen.uha.core.service.csv;

import org.nedezkiiyasen.uha.core.document.Document;
import org.nedezkiiyasen.uha.core.service.DocumentService;
import org.nedezkiiyasen.uha.core.utils.CsvUtils;

import java.io.*;

public interface CsvService extends DocumentService {
    default void write(OutputStream os) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            write(bufferedWriter);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    default void write(Writer writer) {
        Document document = createDocument();
        CsvUtils.writeLine(writer, document.getHeaders());
        document.getLines().forEach((line) -> CsvUtils.writeLine(writer, line));
    }
}
