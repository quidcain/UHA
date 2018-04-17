package org.nedezkiiyasen.uha.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clans")
@Getter
@Setter
public class Clan extends RepositoryItem {
    @OneToMany(mappedBy = "clan", fetch = FetchType.EAGER)
    private Set<Eptituder> eptituders = new HashSet<>();
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
