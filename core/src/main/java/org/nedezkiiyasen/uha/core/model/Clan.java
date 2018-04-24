package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clans")
@Getter
@Setter
public class Clan extends RepositoryItem {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "eptituders_clans",
            joinColumns = { @JoinColumn(name = "clan_id") },
            inverseJoinColumns = { @JoinColumn(name = "eptituder_id") }
    )
    private Set<Eptituder> eptituders = new HashSet<>();
    private String name;
    private String side;
    private String ico;
    private String description;
}
