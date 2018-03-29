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
public class EventRepositoryIntegrationTest {
    @Autowired
    private EventRepository eventRepository;

    @Test
    public void testEventDaoIsNotNull() {
        assertNotNull(eventRepository);
    }

    @Test
    public void testSaveAndGet() {
        Event saved = eventRepository.save(stub());
        Event gotten = eventRepository.getOne(saved.getId());
        assertEquals(saved.getName(), gotten.getName());
    }

    @Test(expected = JpaObjectRetrievalFailureException.class)
    public void testSaveAndDelete() {
        Event saved = eventRepository.save(stub());
        eventRepository.delete(saved);
        eventRepository.getOne(saved.getId());
    }

    @Test
    public void testSaveAndUpdate() {
        Event saved = eventRepository.save(stub());
        saved.setName("Civil war");
        eventRepository.save(saved);
        Event gotten = eventRepository.getOne(saved.getId());
        assertEquals(saved.getName(), gotten.getName());
    }

    @Test
    public void testSaveAllAndFindAll() {
        int before = eventRepository.findAll().size();
        List<Event> events = Arrays.asList(stub(), stub(), stub());
        eventRepository.saveAll(events);
        List<Event> all = eventRepository.findAll();
        assertEquals(before + events.size(), all.size());
    }

    private Event stub() {
        Event event = new Event();
        event.setName("Age of Ultron");
        return event;
    }
}
