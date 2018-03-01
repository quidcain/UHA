package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "eptituders")
@Getter
@Setter
@ToString(exclude = {"clan", "events"})
public class Eptituder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @NotEmpty
    private String name;
    @NotEmpty
    private String side;
    @Size(max = 255)
    private String eptitudes;
    private String ico;
    @NotEmpty
    private String bio;
    @Null
    private String rank;
    @Null
    private Integer points;
}
