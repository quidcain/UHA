package org.nedezkiiyasen.uha.core.mapping.impl;

import org.nedezkiiyasen.uha.core.mapping.ModelToDocumentMapper;
import org.nedezkiiyasen.uha.core.model.ExamTicket;
import org.nedezkiiyasen.uha.core.model.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExamTicketModelToDocumentMapper extends ModelToDocumentMapper<ExamTicket> {
    @Override
    protected List<String> getHeaders() {
        return Arrays.asList("Id", "Rank", "Questions");
    }

    @Override
    protected List<List<String>> getLines(List<ExamTicket> examTickets) {
        List<List<String>> lines = new ArrayList<>();
        for (ExamTicket examTicket : examTickets) {
            List<String> line = new ArrayList<>();
            line.add(examTicket.getId().toString());
            line.add(examTicket.getRank());
            line.add(getQuestions(examTicket));
            lines.add(line);
        }
        return lines;
    }

    private String getQuestions(ExamTicket examTicket) {
        return String.join(", ", examTicket.getQuestions().stream()
                .map(Question::getQuestion)
                .collect(Collectors.toList()));
    }
}
