package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "eptituders")
@Getter
@Setter
@ToString(exclude = {"clan", "events"})
public class Eptituder extends RepositoryItem {
    @ManyToOne
    @JoinColumn(name = "clan_id")
    private Clan clan;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "eptituders_events",
        joinColumns = { @JoinColumn(name = "eptituder_id") },
        inverseJoinColumns = { @JoinColumn(name = "event_id") }
    )
    private Set<Event> events = new HashSet<>();
    private String name;
    private String side;
    private String eptitudes;
    private String ico;
    private String bio;
    private String rank;
    private Integer points;
}
