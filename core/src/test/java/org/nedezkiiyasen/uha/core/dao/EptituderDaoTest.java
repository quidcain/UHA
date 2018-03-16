package org.nedezkiiyasen.uha.core.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nedezkiiyasen.uha.core.config.CoreConfig;
import org.nedezkiiyasen.uha.core.model.Eptituder;
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
public class EptituderDaoTest {
    @Autowired
    private EptituderDao eptituderDao;

    @Test
    public void testEptituderDaoIsNotNull() {
        assertNotNull(eptituderDao);
    }

    @Test
    public void testSaveAndGet() {
        Eptituder saved = eptituderDao.save(stub());
        Eptituder gotten = eptituderDao.getOne(saved.getId());
        assertEquals(saved.getName(), gotten.getName());
    }

    @Test(expected = JpaObjectRetrievalFailureException.class)
    public void testSaveAndDelete() {
        Eptituder saved = eptituderDao.save(stub());
        eptituderDao.delete(saved);
        eptituderDao.getOne(saved.getId());
    }

    @Test
    public void testSaveAndUpdate() {
        Eptituder saved = eptituderDao.save(stub());
        saved.setName("igor");
        eptituderDao.save(saved);
        Eptituder gotten = eptituderDao.getOne(saved.getId());
        assertEquals(saved.getName(), gotten.getName());
    }

    @Test
    public void testSaveAllAndFindAll() {
        List<Eptituder> eptituders = Arrays.asList(stub(), stub(), stub());
        eptituderDao.saveAll(eptituders);
        List<Eptituder> all = eptituderDao.findAll();
        assertEquals(eptituders.size(), all.size());
    }

    private Eptituder stub() {
        Eptituder eptituder = new Eptituder();
        eptituder.setName("vadim");
        eptituder.setEptitudes("php, handsome suit");
        return eptituder;
    }
}
