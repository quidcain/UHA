package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "clans")
@Getter
@Setter
public class Clan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "clan", fetch = FetchType.EAGER)
    private List<Eptituder> eptituders;
    @NotBlank
    @Size(max = 255)
    private String name;
    @NotBlank
    @Size(max = 255)
    private String side;
    private String ico;
    @Size(max = 255)
    private String description;
}
