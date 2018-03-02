package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.ClanDao;
import org.nedezkiiyasen.uha.core.model.Clan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/clans")
public class ClanController {
    @Autowired
    private ClanDao clanDao;

    @GetMapping
    public String get(Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new Clan());
        }
        model.addAttribute(clanDao.findAll());
        return "clans";
    }

    @PostMapping
    public String create(@ModelAttribute("form") @Valid Clan clan,
                         BindingResult result,
                         RedirectAttributes redirectAtrrs) {
        if (result.hasErrors()) {
            redirectAtrrs.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
            redirectAtrrs.addFlashAttribute("form", clan);
        } else {
            clanDao.save(clan);
        }
        return "redirect:/clans";
    }

    @GetMapping(value = "/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new Clan());
        }
        model.addAttribute("clan", clanDao.findById(id).get());
        return "clan";
    }

    @PostMapping(value = "/{id}")
    public String updateDelete(@RequestParam String action,
                               @PathVariable Integer id,
                               @ModelAttribute("form") @Valid Clan clan,
                               BindingResult result,
                               RedirectAttributes redirectAtrrs) {
        clan.setId(id);
        switch (action) {
            case "update":
                if (result.hasErrors()) {
                    redirectAtrrs.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
                    redirectAtrrs.addFlashAttribute("form", clan);
                } else {
                    clanDao.save(clan);
                }
                return "redirect:/eptituders/" + id;
            case "delete":
                clanDao.delete(clan);
                break;
        }
        return "redirect:/eptituders";
    }

}
