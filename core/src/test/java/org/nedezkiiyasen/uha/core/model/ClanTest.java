package org.nedezkiiyasen.uha.core.model;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ClanTest {
    private static Integer ID = 1;
    private static String NAME = "name";
    private static String SIDE = "side";
    private static String ICO = "ico";
    private static String DESCRIPTION = "description";
    private static Set<Eptituder> EPTITUDERS = Collections.EMPTY_SET;

    @Test
    public void testSettersAndGetters() {
        Clan clan = new Clan();
        clan.setId(ID);
        clan.setName(NAME);
        clan.setSide(SIDE);
        clan.setIco(ICO);
        clan.setDescription(DESCRIPTION);
        clan.setEptituders(EPTITUDERS);
        assertEquals(ID, clan.getId());
        assertEquals(NAME, clan.getName());
        assertEquals(SIDE, clan.getSide());
        assertEquals(ICO, clan.getIco());
        assertEquals(DESCRIPTION, clan.getDescription());
        assertEquals(EPTITUDERS, clan.getEptituders());
    }
}
