package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exam_tickets")
@Getter
@Setter
public class ExamTicket extends RepositoryItem {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "exam_tickets_questions",
            joinColumns = { @JoinColumn(name = "exam_ticket_id") },
            inverseJoinColumns = { @JoinColumn(name = "question_id") }
    )
    private Set<Question> questions = new HashSet<>();
    private String rank;
}
