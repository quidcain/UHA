package org.nedezkiiyasen.uha.core.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nedezkiiyasen.uha.core.config.CoreConfig;
import org.nedezkiiyasen.uha.core.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
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
public class EventDaoIntegrationTest {
    @Autowired
    private EventDao eventDao;

    @Test
    public void testEventDaoIsNotNull() {
        assertNotNull(eventDao);
    }

    @Test
    public void testSaveAndGet() {
        Event saved = eventDao.save(stub());
        Event gotten = eventDao.getOne(saved.getId());
        assertEquals(saved.getName(), gotten.getName());
    }

    @Test(expected = JpaObjectRetrievalFailureException.class)
    public void testSaveAndDelete() {
        Event saved = eventDao.save(stub());
        eventDao.delete(saved);
        eventDao.getOne(saved.getId());
    }

    @Test
    public void testSaveAndUpdate() {
        Event saved = eventDao.save(stub());
        saved.setName("Civil war");
        eventDao.save(saved);
        Event gotten = eventDao.getOne(saved.getId());
        assertEquals(saved.getName(), gotten.getName());
    }

    @Test
    public void testSaveAllAndFindAll() {
        int before = eventDao.findAll().size();
        List<Event> events = Arrays.asList(stub(), stub(), stub());
        eventDao.saveAll(events);
        List<Event> all = eventDao.findAll();
        assertEquals(before + events.size(), all.size());
    }

    private Event stub() {
        Event event = new Event();
        event.setName("Age of Ultron");
        return event;
    }
}
