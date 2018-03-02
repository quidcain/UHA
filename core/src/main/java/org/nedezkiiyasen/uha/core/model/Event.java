package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
