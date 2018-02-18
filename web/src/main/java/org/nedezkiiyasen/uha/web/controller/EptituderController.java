package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.EptituderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping({"/", "eptituders"})
public class EptituderController {
    @Autowired
    private EptituderDao eptituderDao;

    @RequestMapping(method = GET)
    public String hello(Model model) {
        model.addAttribute(eptituderDao.findAll());
        return "eptituders";
    }
}
