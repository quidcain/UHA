package org.nedezkiiyasen.uha.core.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nedezkiiyasen.uha.core.config.CoreConfig;
import org.nedezkiiyasen.uha.core.model.Clan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CoreConfig.class)
@Transactional
@ActiveProfiles("test")
public class ClanRepositoryTest {
    @Autowired
    private ClanRepository clanRepository;

    @Test
    public void testClanDaoIsNotNull() {
        assertNotNull(clanRepository);
    }

    @Test
    public void testSaveAndGet() {
        Clan saved = clanRepository.save(stub());
        Clan gotten = clanRepository.getOne(saved.getId());
        assertEquals(saved.getName(), gotten.getName());
    }

    @Test(expected = JpaObjectRetrievalFailureException.class)
    public void testSaveAndDelete() {
        Clan saved = clanRepository.save(stub());
        clanRepository.delete(saved);
        clanRepository.getOne(saved.getId());
    }

    @Test
    public void testSaveAndUpdate() {
        Clan saved = clanRepository.save(stub());
        saved.setName("X-men");
        clanRepository.save(saved);
        Clan gotten = clanRepository.getOne(saved.getId());
        assertEquals(saved.getName(), gotten.getName());
    }

    @Test
    public void testSaveAllAndFindAll() {
        List<Clan> clans = Arrays.asList(stub(), stub(), stub());
        clanRepository.saveAll(clans);
        List<Clan> all = clanRepository.findAll();
        assertEquals(clans.size(), all.size());
    }

    private Clan stub() {
        Clan clan = new Clan();
        clan.setName("Avengers");
        return clan;
    }
}
