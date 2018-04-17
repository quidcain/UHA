package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
@Getter
@Setter
public class Question extends RepositoryItem {
    private String question;
}
