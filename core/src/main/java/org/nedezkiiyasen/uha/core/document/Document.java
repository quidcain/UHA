package org.nedezkiiyasen.uha.core.document;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Document {
    private List<String> headers;
    private List<List<String>> lines;
}
