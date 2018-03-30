package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.EventRepository;
import org.nedezkiiyasen.uha.core.model.Event;
import org.nedezkiiyasen.uha.core.service.csv.impl.EventCsvService;
import org.nedezkiiyasen.uha.core.service.excel.impl.EventExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventController extends BaseController<Event> {
    @Autowired
    public EventController(EventRepository eventRepository,
                           EventCsvService eventCsvService,
                           EventExcelService eventExcelService) {
        setRepository(eventRepository);
        setCsvService(eventCsvService);
        setExcelService(eventExcelService);
    }

    @Override
    protected Event createForm() {
        return new Event();
    }

    @Override
    protected String getSingleViewName() {
        return Event.class.getSimpleName().toLowerCase();
    }
}
