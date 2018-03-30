package org.nedezkiiyasen.uha.core.mapping.impl;

import org.nedezkiiyasen.uha.core.mapping.ModelToDocumentMapper;
import org.nedezkiiyasen.uha.core.model.Clan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ClanModelToDocumentMapper extends ModelToDocumentMapper<Clan> {

    @Override
    protected List<String> getHeaders() {
        return Arrays.asList("Id", "Name", "Side", "Description");
    }

    @Override
    protected List<List<String>> getLines(List<Clan> clans) {
        List<List<String>> lines = new ArrayList<>();
        for (Clan clan : clans) {
            List<String> line = new ArrayList<>();
            line.add(clan.getId().toString());
            line.add(clan.getName());
            line.add(clan.getSide());
            line.add(clan.getDescription());
            lines.add(line);
        }
        return lines;
    }
}
