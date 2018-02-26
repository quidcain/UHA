package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "eptituders")
@Getter
@Setter
public class Eptituder {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "clan_id")
    private Clan clan;
    @ManyToMany
    @JoinTable(
        name = "eptituders_events",
        joinColumns = { @JoinColumn(name = "eptituder_id") },
        inverseJoinColumns = { @JoinColumn(name = "event_id") }
    )
    private List<Event> events;
    private String name;
    private String side;
    private String eptitudes;
    private String ico;
    private String bio;
    private String rank;
    private Integer points;
}
