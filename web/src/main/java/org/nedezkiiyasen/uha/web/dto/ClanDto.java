package org.nedezkiiyasen.uha.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClanDto extends Dto {
    private Set<EptituderDto> eptituders = new HashSet<>();
    @NotBlank
    @Size(max = 255)
    private String name;
    @NotBlank
    @Size(max = 255)
    private String side;
    private String ico;
    @Size(max = 255)
    private String description;
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class EptituderDto extends Dto {
        private String name;
        private String side;
        private String eptitudes;
        private String ico;
        private String bio;
        private String rank;
        private Integer points;
    }
}
