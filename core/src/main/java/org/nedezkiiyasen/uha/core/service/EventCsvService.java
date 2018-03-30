package org.nedezkiiyasen.uha.core.service;

import org.nedezkiiyasen.uha.core.dao.EventRepository;
import org.nedezkiiyasen.uha.core.model.Event;
import org.nedezkiiyasen.uha.core.utils.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EventCsvService implements CsvService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public void write(Writer writer) throws IOException {
        CsvUtils.writeLine(writer, Arrays.asList("Id", "Name", "Side", "Description", "Date", "Points"));
        for (Event event : eventRepository.findAll()) {
            List<String> list = new ArrayList<>();
            list.add(event.getId().toString());
            list.add(event.getName());
            list.add(event.getDescription());
            list.add(event.getDate() == null ? "" : event.getDate().toString());
            list.add(event.getPoints() == null ? "" : event.getPoints().toString());
            CsvUtils.writeLine(writer, list);
        }
    }
}
