package org.nedezkiiyasen.uha.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDto extends Dto {
    private Set<EptituderDto> eptituders = new HashSet<>();
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
