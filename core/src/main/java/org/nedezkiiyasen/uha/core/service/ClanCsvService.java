package org.nedezkiiyasen.uha.core.service;

import org.nedezkiiyasen.uha.core.dao.ClanRepository;
import org.nedezkiiyasen.uha.core.model.Clan;
import org.nedezkiiyasen.uha.core.utils.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ClanCsvService implements CsvService {
    @Autowired
    private ClanRepository clanRepository;

    @Override
    public void write(Writer writer) throws IOException {
        CsvUtils.writeLine(writer, Arrays.asList("Id", "Name", "Side", "Description"));
        for (Clan clan : clanRepository.findAll()) {
            List<String> list = new ArrayList<>();
            list.add(clan.getId().toString());
            list.add(clan.getName());
            list.add(clan.getSide());
            list.add(clan.getDescription());
            CsvUtils.writeLine(writer, list);
        }
    }
}
