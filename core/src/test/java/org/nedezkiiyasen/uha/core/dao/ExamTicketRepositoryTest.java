package org.nedezkiiyasen.uha.core.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nedezkiiyasen.uha.core.config.CoreConfig;
import org.nedezkiiyasen.uha.core.model.ExamTicket;
import org.nedezkiiyasen.uha.core.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CoreConfig.class)
@Transactional
@ActiveProfiles("test")
public class ExamTicketRepositoryTest {
    @Autowired
    private ExamTicketRepository examTicketRepository;

    @Test
    public void testRepositoryIsNotNull() {
        assertNotNull(examTicketRepository);
    }

    @Test
    public void test() {
        ExamTicket examTicket = new ExamTicket();
        examTicket.setRank("C");
        examTicket.setQuestions(new HashSet<>(Arrays.asList(
                createQuestion("1"),
                createQuestion("2"),
                createQuestion("3"))));
        examTicketRepository.save(examTicket);
        for (ExamTicket ticket : examTicketRepository.findAll()) {
            Set<Question> questions = ticket.getQuestions();
            System.out.println(questions);
        }
    }

    private Question createQuestion(String questionText) {
        Question question = new Question();
        question.setQuestion(questionText);
        return question;
    }
}
