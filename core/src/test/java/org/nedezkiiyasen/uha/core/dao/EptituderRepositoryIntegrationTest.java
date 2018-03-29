package org.nedezkiiyasen.uha.core.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nedezkiiyasen.uha.core.config.CoreConfig;
import org.nedezkiiyasen.uha.core.model.Eptituder;
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
public class EptituderRepositoryIntegrationTest {
    @Autowired
    private EptituderRepository eptituderRepository;

    @Test
    public void testEptituderDaoIsNotNull() {
        assertNotNull(eptituderRepository);
    }

    @Test
    public void testSaveAndGet() {
        Eptituder saved = eptituderRepository.save(stub());
        Eptituder gotten = eptituderRepository.getOne(saved.getId());
        assertEquals(saved.getName(), gotten.getName());
    }

    @Test(expected = JpaObjectRetrievalFailureException.class)
    public void testSaveAndDelete() {
        Eptituder saved = eptituderRepository.save(stub());
        eptituderRepository.delete(saved);
        eptituderRepository.getOne(saved.getId());
    }

    @Test
    public void testSaveAndUpdate() {
        Eptituder saved = eptituderRepository.save(stub());
        saved.setName("igor");
        eptituderRepository.save(saved);
        Eptituder gotten = eptituderRepository.getOne(saved.getId());
        assertEquals(saved.getName(), gotten.getName());
    }

    @Test
    public void testSaveAllAndFindAll() {
        int before = eptituderRepository.findAll().size();
        List<Eptituder> eptituders = Arrays.asList(stub(), stub(), stub());
        eptituderRepository.saveAll(eptituders);
        List<Eptituder> all = eptituderRepository.findAll();
        assertEquals(before + eptituders.size(), all.size());
    }

    private Eptituder stub() {
        Eptituder eptituder = new Eptituder();
        eptituder.setName("vadim");
        eptituder.setEptitudes("php, handsome suit");
        return eptituder;
    }
}
