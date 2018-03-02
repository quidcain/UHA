package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "events")
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany(mappedBy = "events", fetch = FetchType.EAGER)
    private List<Eptituder> eptituders;
    private String name;
    private String ico;
    private String description;
    private Date date;
    private Integer points;
    private String status;
    private String rank;
}
