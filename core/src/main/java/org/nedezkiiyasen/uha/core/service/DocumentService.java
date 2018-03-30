package org.nedezkiiyasen.uha.core.service;

import java.io.IOException;
import java.io.OutputStream;

public interface DocumentService {
    void write(OutputStream os) throws IOException;
}
