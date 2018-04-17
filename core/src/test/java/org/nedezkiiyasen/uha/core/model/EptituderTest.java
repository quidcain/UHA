package org.nedezkiiyasen.uha.core.model;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class EptituderTest {
    private static Integer ID = 1;
    private static String NAME = "name";
    private static String SIDE = "side";
    private static String EPTITUDES = "eptitudes";
    private static String ICO = "ico";
    private static String BIO = "bio";
    private static String RANK = "rank";
    private static Clan CLAN = new Clan();
    private static Set<Event> EVENTS = Collections.EMPTY_SET;
    private static int POINTS = 1;

    @Test
    public void testSettersAndGetters() {
        Eptituder eptituder = new Eptituder();
        eptituder.setId(1);
        eptituder.setName(NAME);
        eptituder.setSide(SIDE);
        eptituder.setEptitudes(EPTITUDES);
        eptituder.setIco(ICO);
        eptituder.setBio(BIO);
        eptituder.setRank(RANK);
        eptituder.setPoints(1);
        eptituder.setEvents(EVENTS);
        eptituder.setClan(CLAN);
        assertEquals(ID, eptituder.getId());
        assertEquals(NAME, eptituder.getName());
        assertEquals(SIDE, eptituder.getSide());
        assertEquals(EPTITUDES, eptituder.getEptitudes());
        assertEquals(ICO, eptituder.getIco());
        assertEquals(BIO, eptituder.getBio());
        assertEquals(RANK, eptituder.getRank());
        assertEquals(EVENTS, eptituder.getEvents());
        assertEquals(CLAN, eptituder.getClan());
    }

    @Test
    public void testToString() {
        Eptituder eptituder = new Eptituder();
        eptituder.setId(1);
        eptituder.setName(NAME);
        eptituder.setSide(SIDE);
        eptituder.setEptitudes(EPTITUDES);
        eptituder.setIco(ICO);
        eptituder.setBio(BIO);
        eptituder.setRank(RANK);
        eptituder.setPoints(1);
        assertEquals(String.format(
                "Eptituder(name=%s, side=%s, eptitudes=%s, ico=%s, bio=%s, rank=%s, points=%d)",
                eptituder.getName(), eptituder.getSide(), eptituder.getEptitudes(),
                eptituder.getIco(), eptituder.getBio(), eptituder.getRank(), eptituder.getPoints()),
                eptituder.toString());
    }
}
