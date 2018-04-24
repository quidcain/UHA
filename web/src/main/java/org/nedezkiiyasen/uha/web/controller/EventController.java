package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.EptituderRepository;
import org.nedezkiiyasen.uha.core.dao.EventRepository;
import org.nedezkiiyasen.uha.core.model.Event;
import org.nedezkiiyasen.uha.core.service.csv.impl.EventCsvService;
import org.nedezkiiyasen.uha.core.service.excel.impl.EventExcelService;
import org.nedezkiiyasen.uha.core.service.pdf.impl.EventPdfService;
import org.nedezkiiyasen.uha.web.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController extends BaseController<Event, EventDto> {
    @Autowired
    private EptituderRepository eptituderRepository;

    @Autowired
    public EventController(EventRepository eventRepository,
                           EventCsvService eventCsvService,
                           EventExcelService eventExcelService,
                           EventPdfService eventPdfService) {
        setRepository(eventRepository);
        setCsvService(eventCsvService);
        setExcelService(eventExcelService);
        setPdfService(eventPdfService);
    }

    @Override
    protected Event toEntity(EventDto dto) {
        Event event = super.toEntity(dto);
        /*Set<Eptituder> collect = dto.getEptituders().stream()
                .map(Dto::getId)
                .map(eptituderRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
        event.setEptituders(collect);*/
        return event;
    }

    @Override
    protected Class<Event> getEntityClass() {
        return Event.class;
    }

    @Override
    protected Class<EventDto> getDtoClass() {
        return EventDto.class;
    }

    @Override
    protected String getViewName() {
        return "events";
    }
}
