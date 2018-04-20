package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.EptituderRepository;
import org.nedezkiiyasen.uha.core.dao.EventRepository;
import org.nedezkiiyasen.uha.core.model.Eptituder;
import org.nedezkiiyasen.uha.core.model.Event;
import org.nedezkiiyasen.uha.core.service.csv.impl.EventCsvService;
import org.nedezkiiyasen.uha.core.service.excel.impl.EventExcelService;
import org.nedezkiiyasen.uha.core.service.pdf.impl.EventPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/events")
public class EventController extends ParentWithChildsController<Event, Eptituder> {
    @Autowired
    public EventController(EventRepository eventRepository,
                           EventCsvService eventCsvService,
                           EventExcelService eventExcelService,
                           EventPdfService eventPdfService,
                           EptituderRepository eptituderRepository) {
        setRepository(eventRepository);
        setCsvService(eventCsvService);
        setExcelService(eventExcelService);
        setPdfService(eventPdfService);
        setChildRepository(eptituderRepository);
    }

    @PostMapping
    @Override
    public String create(@ModelAttribute("form") @Valid Event event,
                         BindingResult result,
                         RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
            redirectAttrs.addFlashAttribute("form", event);
        } else {
            repository.save(event);
            getChoosedChildsStream()
                    .peek(e -> e.getEvents().add(event))
                    .peek(childRepository::save)
                    .forEach(event.getEptituders()::add);
        }
        return "redirect:/" + getMultipleViewName();
    }

    @PostMapping(value = "/{id}")
    public String updateDelete(@RequestParam String action,
                               @PathVariable Integer id,
                               @ModelAttribute("form") @Valid Event event,
                               BindingResult result,
                               RedirectAttributes redirectAttrs) {
        event.setEptituders(getChoosedChildsStream()
                .peek(e -> e.getEvents().add(event))
                //.peek(childRepository::save)
                .collect(Collectors.toSet()));
        return super.updateDelete(action, id, event, result, redirectAttrs);
    }

    @Override
    protected String getChildIdsParameter() {
        return "eptituderIds";
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
