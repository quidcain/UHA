package org.nedezkiiyasen.uha.core.mapping.impl;

import org.nedezkiiyasen.uha.core.mapping.ModelToDocumentMapper;
import org.nedezkiiyasen.uha.core.model.Eptituder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EptituderModelToDocumentMapper extends ModelToDocumentMapper<Eptituder> {
    @Override
    protected List<String> getHeaders() {
        return Arrays.asList("Id", "Name", "Side", "Eptitudes", "Points", "Clan");
    }

    @Override
    protected List<List<String>> getLines(List<Eptituder> eptituders) {
        List<List<String>> lines = new ArrayList<>();
        for (Eptituder eptituder : eptituders) {
            List<String> line = new ArrayList<>();
            line.add(eptituder.getId().toString());
            line.add(eptituder.getName());
            line.add(eptituder.getSide());
            line.add(eptituder.getEptitudes() == null ? "" : eptituder.getEptitudes());
            line.add(eptituder.getPoints() == null ? "" : eptituder.getPoints().toString());
            lines.add(line);
        }
        return lines;
    }
}
