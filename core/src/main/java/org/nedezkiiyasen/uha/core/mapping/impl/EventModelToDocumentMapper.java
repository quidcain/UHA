package org.nedezkiiyasen.uha.core.mapping.impl;

import org.nedezkiiyasen.uha.core.mapping.ModelToDocumentMapper;
import org.nedezkiiyasen.uha.core.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EventModelToDocumentMapper extends ModelToDocumentMapper<Event> {
    @Override
    protected List<String> getHeaders() {
        return Arrays.asList("Id", "Name", "Side", "Description", "Date", "Points");
    }

    @Override
    protected List<List<String>> getLines(List<Event> events) {
        List<List<String>> lines = new ArrayList<>();
        for (Event event : events) {
            List<String> line = new ArrayList<>();
            line.add(event.getId().toString());
            line.add(event.getName());
            line.add(event.getDescription());
            line.add(event.getDate() == null ? "" : event.getDate().toString());
            line.add(event.getPoints() == null ? "" : event.getPoints().toString());
            lines.add(line);
        }
        return lines;
    }
}
