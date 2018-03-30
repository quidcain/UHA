package org.nedezkiiyasen.uha.core.mapping;

import org.nedezkiiyasen.uha.core.document.Document;
import org.nedezkiiyasen.uha.core.model.RepositoryItem;

import java.util.List;

public abstract class ModelToDocumentMapper<T extends RepositoryItem> {
    public Document map(List<T> t) {
        Document document = new Document();
        document.setHeaders(getHeaders());
        document.setLines(getLines(t));
        return document;
    }

    protected abstract List<String> getHeaders();
    protected abstract List<List<String>> getLines(List<T> t);
}
