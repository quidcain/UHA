package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.List;

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
    private List<Event> events;
    @NotBlank
    @Size(max = 255)
    private String name;
    @NotBlank
    @Size(max = 255)
    private String side;
    @Size(max = 255)
    private String eptitudes;
    private String ico;
    @NotBlank
    @Size(max = 255)
    private String bio;
    @Null
    private String rank;
    @Null
    private Integer points;
}
