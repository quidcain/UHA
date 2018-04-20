package org.nedezkiiyasen.uha.web.controller;

import org.nedezkiiyasen.uha.core.model.RepositoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class ParentWithChildsController<P extends RepositoryItem, C extends RepositoryItem>
        extends BaseController<P> {
    private static String[] EMPTY_STRING_ARRAY = new String[0];
    protected JpaRepository<C, Integer> childRepository;

    @Autowired
    HttpServletRequest request;

    @GetMapping
    @Override
    public String get(Model model, Pageable pageable) {
        model.addAttribute(childRepository.findAll());
        return super.get(model, pageable);
    }

    @GetMapping(value = "/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute(childRepository.findAll());
        return super.getById(id, model);
    }

    protected Stream<C> getChoosedChildsStream() {
        return Stream.of(Optional.ofNullable(
                request.getParameterValues(getChildIdsParameter()))
                .orElseGet(() -> EMPTY_STRING_ARRAY))
                .map(Integer::parseInt)
                .map(childRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get);
    }
    protected abstract String getChildIdsParameter();
    protected void setChildRepository(JpaRepository<C, Integer> childRepository) {
        this.childRepository = childRepository;
    }
}
