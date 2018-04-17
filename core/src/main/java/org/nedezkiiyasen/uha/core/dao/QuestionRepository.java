package org.nedezkiiyasen.uha.core.dao;

import org.nedezkiiyasen.uha.core.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
