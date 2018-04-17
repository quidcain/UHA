package org.nedezkiiyasen.uha.core.model;

import org.junit.Test;

import java.sql.Date;
import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class EventTest {
    private static Integer ID = 1;
    private static String NAME = "name";
    private static String ICO = "ico";
    private static String DESCRIPTION = "description";
    private static Date DATE = new Date(System.currentTimeMillis());
    private static Integer POINTS = 1;
    private static String STATUS = "status";
    private static String RANK = "rank";
    private static Set<Eptituder> EPTITUDERS = Collections.EMPTY_SET;

    @Test
    public void testSettersAndGetters() {
        Event event = new Event();
        event.setId(ID);
        event.setName(NAME);
        event.setIco(ICO);
        event.setDescription(DESCRIPTION);
        event.setDate(DATE);
        event.setPoints(POINTS);
        event.setStatus(STATUS);
        event.setRank(RANK);
        event.setEptituders(EPTITUDERS);
        assertEquals(ID, event.getId());
        assertEquals(NAME, event.getName());
        assertEquals(ICO, event.getIco());
        assertEquals(DESCRIPTION, event.getDescription());
        assertEquals(DATE, event.getDate());
        assertEquals(POINTS, event.getPoints());
        assertEquals(STATUS, event.getStatus());
        assertEquals(RANK, event.getRank());
        assertEquals(EPTITUDERS, event.getEptituders());
    }
}
