package org.nedezkiiyasen.uha.core.service;

import java.io.*;

public interface CsvService extends DocumentService {
    default void write(OutputStream os) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
        write(bufferedWriter);
        bufferedWriter.flush();
    }
    void write(Writer writer) throws IOException;
}
