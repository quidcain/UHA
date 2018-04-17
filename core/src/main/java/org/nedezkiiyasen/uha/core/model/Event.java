package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "events")
@Getter
@Setter
public class Event extends RepositoryItem {
    @ManyToMany(mappedBy = "events", fetch = FetchType.EAGER)
    private Set<Eptituder> eptituders = new HashSet<>();
    @NotBlank
    @Size(max = 255)
    private String name;
    private String ico;
    @NotBlank
    @Size(max = 255)
    private String description;
    private Date date;
    private Integer points;
    private String status;
    private String rank;
}
