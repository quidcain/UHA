package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clans")
@Getter
@Setter
public class Clan {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(mappedBy = "clan")
    private List<Eptituder> eptituders;
    private String name;
    private String side;
    private String ico;
    private String description;
}
