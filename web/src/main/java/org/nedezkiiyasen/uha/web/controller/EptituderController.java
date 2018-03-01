package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.EptituderDao;
import org.nedezkiiyasen.uha.core.model.Eptituder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping({"/", "/eptituders"})
public class EptituderController {
    @Autowired
    private EptituderDao eptituderDao;

    @GetMapping
    public String get(Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new Eptituder());
        }
        model.addAttribute(eptituderDao.findAll());
        return "eptituders";
    }

    @GetMapping(value = "/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute("eptituder", eptituderDao.findById(id).get());
        return "eptituder";
    }

    @PostMapping
    public String post(@RequestParam String action,
                       @ModelAttribute("form") @Valid Eptituder eptituder,
                       BindingResult result,
                       RedirectAttributes redirectAtrrs) {
        switch (action) {
            case "create_update":
                if (result.hasErrors()) {
                    redirectAtrrs.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
                    redirectAtrrs.addFlashAttribute("form", eptituder);
                    return "redirect:/eptituders";
                }
                eptituderDao.save(eptituder);
                break;
            case "delete":
                eptituderDao.delete(eptituder);
                break;
        }
        return "redirect:/eptituders";
    }
}
