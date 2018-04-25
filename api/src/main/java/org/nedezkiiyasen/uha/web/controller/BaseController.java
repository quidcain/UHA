package org.nedezkiiyasen.uha.web.controller;

import org.modelmapper.ModelMapper;
import org.nedezkiiyasen.uha.core.model.RepositoryItem;
import org.nedezkiiyasen.uha.core.service.DocumentService;
import org.nedezkiiyasen.uha.core.service.csv.CsvService;
import org.nedezkiiyasen.uha.core.service.excel.ExcelService;
import org.nedezkiiyasen.uha.core.service.pdf.PdfService;
import org.nedezkiiyasen.uha.web.dto.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.String.format;

public abstract class BaseController<T extends RepositoryItem, TD extends Dto> {
    protected JpaRepository<T, Integer> repository;
    private CsvService csvService;
    private ExcelService excelService;
    private PdfService pdfService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Map<String, Object> get(@PageableDefault(size = 2) Pageable pageable) {
        Map<String, Object> model = new HashMap<>();
        Page<T> page = repository.findAll(pageable);
        model.put("currentPage", pageable.getPageNumber() + 1);
        model.put("totalPages", page.getTotalPages());
        model.put(getViewName(), toDto(page.getContent()));
        return model;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody @Valid TD dto, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        } else {
            T saved = repository.save(toEntity(dto));
            return new ResponseEntity<>(toDto(saved), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Optional<T> byId = repository.findById(id);
        if (byId.isPresent()) {
            return new ResponseEntity<>(toDto(byId.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(format("Eptituder %d not found", id), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid TD dto, BindingResult result) {
        dto.setId(id);
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        } else {
            T saved = repository.save(toEntity(dto));
            return new ResponseEntity<>(toDto(saved), HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Optional<T> byId = repository.findById(id);
        if (byId.isPresent()) {
            repository.delete(byId.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(format("Eptituder %d not found", id), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/csv")
    public void csv(HttpServletResponse response) throws IOException {
        response.setContentType("data:text/csv;charset=utf-8");
        response.setHeader("Content-Disposition","attachment; filename=\"" + getViewName() + ".csv\"");
        writeDocument(response, csvService);
    }

    @GetMapping("/xls")
    public void xls(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + getViewName() + ".xls\"");
        writeDocument(response, excelService);
    }

    @GetMapping("/pdf")
    public void pdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition","inline; filename=\"" + getViewName() + ".pdf\"");
        writeDocument(response, pdfService);
    }

    private void writeDocument(HttpServletResponse response, DocumentService documentService) throws IOException {
        try(ServletOutputStream outputStream = response.getOutputStream()) {
            documentService.write(outputStream);
        }
    }

    protected List<TD> toDto(List<T> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    protected TD toDto(T entity) {
        return modelMapper.map(entity, getDtoClass());
    }

    protected List<T> toEntity(List<TD> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    protected T toEntity(TD dto) {
        return modelMapper.map(dto, getEntityClass());
    }

    protected abstract Class<T> getEntityClass();

    protected abstract Class<TD> getDtoClass();

    protected abstract String getViewName();

    protected void setRepository(JpaRepository<T, Integer> repository) {
        this.repository = repository;
    }
    protected void setCsvService(CsvService csvService) {
        this.csvService = csvService;
    }
    protected void setExcelService(ExcelService excelService) {
        this.excelService = excelService;
    }
    protected void setPdfService(PdfService pdfService) {
        this.pdfService = pdfService;
    }
}