package org.nedezkiiyasen.uha.core.service;

import org.nedezkiiyasen.uha.core.document.Document;

import java.io.OutputStream;

public interface DocumentService {
    void write(OutputStream os);
    Document createDocument();
}
