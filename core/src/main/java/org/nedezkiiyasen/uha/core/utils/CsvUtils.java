package org.nedezkiiyasen.uha.core.utils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.util.List;

public class CsvUtils {
    private static final char DEFAULT_SEPARATOR = ';';

    public static void writeLine(Writer w, List<String> values) {
        writeLine(w, values, DEFAULT_SEPARATOR);
    }

    public static void writeLine(Writer w, List<String> values, char separators) {
        boolean first = true;
        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }
        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            sb.append(value);
            first = false;
        }
        sb.append("\n");
        try {
            w.append(sb.toString());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
