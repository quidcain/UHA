package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.dao.EptituderRepository;
import org.nedezkiiyasen.uha.core.model.Eptituder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eptituders")
public class EptituderController extends BaseController<Eptituder> {
    @Autowired
    public EptituderController(EptituderRepository eptituderRepository) {
        setRepository(eptituderRepository);
    }

    @Override
    protected Eptituder createForm() {
        return new Eptituder();
    }

    @Override
    protected String getSingleViewName() {
        return Eptituder.class.getSimpleName().toLowerCase();
    }
}
