package org.nedezkiiyasen.uha.core.dao;

import org.nedezkiiyasen.uha.core.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
