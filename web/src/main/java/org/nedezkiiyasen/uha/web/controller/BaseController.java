package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.model.RepositoryItem;
import org.nedezkiiyasen.uha.core.service.DocumentService;
import org.nedezkiiyasen.uha.core.service.csv.CsvService;
import org.nedezkiiyasen.uha.core.service.excel.ExcelService;
import org.nedezkiiyasen.uha.core.service.pdf.PdfService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

public abstract class BaseController<T extends RepositoryItem> {
    private JpaRepository<T, Integer> repository;
    private CsvService csvService;
    private ExcelService excelService;
    private PdfService pdfService;

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

    @GetMapping("/csv")
    public void csv(HttpServletResponse response) throws IOException {
        response.setContentType("data:text/csv;charset=utf-8");
        response.setHeader("Content-Disposition","attachment; filename=\"" + getMultipleViewName() + ".csv\"");
        writeDocument(response, csvService);
    }

    @GetMapping("/xls")
    public void xls(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + getMultipleViewName() + ".xls\"");
        writeDocument(response, excelService);
    }

    @GetMapping("/pdf")
    public void pdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition","inline; filename=\"" + getMultipleViewName() + ".pdf\"");
        writeDocument(response, pdfService);
    }

    private void writeDocument(HttpServletResponse response, DocumentService documentService) throws IOException {
        try(ServletOutputStream outputStream = response.getOutputStream()) {
            documentService.write(outputStream);
        }
    }

    protected abstract T createForm();
    protected abstract String getSingleViewName();
    protected String getMultipleViewName() {
        return getSingleViewName() + 's';
    }
    protected void setRepository(JpaRepository<T, Integer> repository) {
        this.repository = repository;
    }
    protected void setCsvService(CsvService csvService) {
        this.csvService = csvService;
    }
    public void setExcelService(ExcelService excelService) {
        this.excelService = excelService;
    }
    public void setPdfService(PdfService pdfService) {
        this.pdfService = pdfService;
    }
}