package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.model.RepositoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

public abstract class BaseController<T extends RepositoryItem> {
    private JpaRepository<T, Integer> repository;

    @GetMapping
    public String get(Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", createForm());
        }
        model.addAttribute(repository.findAll());
        return getMultipleViewName();
    }

    @PostMapping
    public String create(@ModelAttribute("form") @Valid T t,
                         BindingResult result,
                         RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
            redirectAttrs.addFlashAttribute("form", t);
        } else {
            repository.save(t);
        }
        return "redirect:/" + getMultipleViewName();
    }

    @GetMapping(value = "/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        T t = repository.findById(id).get();
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", t);
        }
        model.addAttribute(getSingleViewName(), t);
        return getSingleViewName();
    }

    @PostMapping(value = "/{id}")
    public String updateDelete(@RequestParam String action,
                               @PathVariable Integer id,
                               @ModelAttribute("form") @Valid T t,
                               BindingResult result,
                               RedirectAttributes redirectAttrs) {
        t.setId(id);
        switch (action) {
            case "update":
                if (result.hasErrors()) {
                    redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
                    redirectAttrs.addFlashAttribute("form", t);
                } else {
                    repository.save(t);
                }
                return "redirect:/" + getMultipleViewName() + "/" + id;
            case "delete":
                repository.delete(t);
                break;
        }
        return "redirect:/" + getMultipleViewName();
    }

    protected String getMultipleViewName() {
        return getSingleViewName() + 's';
    }

    protected void setRepository(JpaRepository<T, Integer> repository) {
        this.repository = repository;
    }
    protected abstract T createForm();
    protected abstract String getSingleViewName();
}
