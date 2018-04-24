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
    @ManyToMany(mappedBy = "events", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<Eptituder> eptituders = new HashSet<>();
    private String name;
    private String ico;
    private String description;
    private Date date;
    private Integer points;
    private String status;
    private String rank;
}
