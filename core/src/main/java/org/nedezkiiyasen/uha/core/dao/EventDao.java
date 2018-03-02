package org.nedezkiiyasen.uha.core.dao;

import org.nedezkiiyasen.uha.core.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventDao extends JpaRepository<Event, Integer> {
}
