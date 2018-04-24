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
public class EptituderDto extends Dto {
    private ClanDto clan;
    private Set<EventDto> events = new HashSet<>();
    @NotBlank
    @Size(max = 255)
    private String name;
    @NotBlank
    @Size(max = 255)
    private String side;
    @Size(max = 255)
    private String eptitudes;
    private String ico;
    @Size(max = 255)
    private String bio;
    private String rank;
    private Integer points;
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ClanDto extends Dto {
        private String name;
        private String side;
        private String ico;
        private String description;
    }
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class EventDto extends Dto {
        private String name;
        private String ico;
        private String description;
        private Date date;
        private Integer points;
        private String status;
        private String rank;
    }
}
