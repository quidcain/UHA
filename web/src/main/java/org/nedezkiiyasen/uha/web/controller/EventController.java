package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.EventDao;
import org.nedezkiiyasen.uha.core.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventDao eventDao;

    @GetMapping
    public String get(Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new Event());
        }
        model.addAttribute(eventDao.findAll());
        return "events";
    }

    @PostMapping
    public String create(@ModelAttribute("form") @Valid Event event,
                         BindingResult result,
                         RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
            redirectAttrs.addFlashAttribute("form", event);
        } else {
            eventDao.save(event);
        }
        return "redirect:/events";
    }

    @GetMapping(value = "/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new Event());
        }
        model.addAttribute("event", eventDao.findById(id).get());
        return "event";
    }

    @PostMapping(value = "/{id}")
    public String updateDelete(@RequestParam String action,
                               @PathVariable Integer id,
                               @ModelAttribute("form") @Valid Event event,
                               BindingResult result,
                               RedirectAttributes redirectAttrs) {
        event.setId(id);
        switch (action) {
            case "update":
                if (result.hasErrors()) {
                    redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
                    redirectAttrs.addFlashAttribute("form", event);
                } else {
                    eventDao.save(event);
                }
                return "redirect:/events/" + id;
            case "delete":
                eventDao.delete(event);
                break;
        }
        return "redirect:/events";
    }
}
