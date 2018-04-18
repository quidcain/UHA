package org.nedezkiiyasen.uha.core.mapping.impl;

import org.nedezkiiyasen.uha.core.mapping.ModelToDocumentMapper;
import org.nedezkiiyasen.uha.core.model.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class QuestionModelToDocumentMapper extends ModelToDocumentMapper<Question> {
    @Override
    protected List<String> getHeaders() {
        return Arrays.asList("Id", "Question");
    }

    @Override
    protected List<List<String>> getLines(List<Question> questions) {
        List<List<String>> lines = new ArrayList<>();
        for (Question question : questions) {
            List<String> line = new ArrayList<>();
            line.add(question.getId().toString());
            line.add(question.getQuestion());
            lines.add(line);
        }
        return lines;
    }
}
