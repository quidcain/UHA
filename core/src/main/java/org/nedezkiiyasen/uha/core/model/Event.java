package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "events")
@Getter
@Setter
public class Event extends RepositoryItem {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "eptituders_events",
            joinColumns = { @JoinColumn(name = "event_id") },
            inverseJoinColumns = { @JoinColumn(name = "eptituder_id") }
    )
    private Set<Eptituder> eptituders = new HashSet<>();
    private String name;
    private String ico;
    private String description;
    private Date date;
    private Integer points;
    private String status;
    private String rank;
}
