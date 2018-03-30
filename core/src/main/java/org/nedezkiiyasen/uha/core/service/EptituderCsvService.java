package org.nedezkiiyasen.uha.core.service;

import org.nedezkiiyasen.uha.core.dao.EptituderRepository;
import org.nedezkiiyasen.uha.core.model.Eptituder;
import org.nedezkiiyasen.uha.core.utils.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EptituderCsvService implements CsvService {
    @Autowired
    private EptituderRepository eptituderRepository;

    @Override
    public void write(Writer writer) throws IOException {
        CsvUtils.writeLine(writer, Arrays.asList("Id", "Name", "Side", "Eptitudes", "Points", "Clan"));
        for (Eptituder eptituder : eptituderRepository.findAll()) {
            List<String> list = new ArrayList<>();
            list.add(eptituder.getId().toString());
            list.add(eptituder.getName());
            list.add(eptituder.getSide());
            list.add(eptituder.getEptitudes());
            list.add(eptituder.getPoints() == null ? "" : eptituder.getPoints().toString());
            list.add(eptituder.getClan() == null ? "" : eptituder.getClan().getName());
            CsvUtils.writeLine(writer, list);
        }
    }
}
