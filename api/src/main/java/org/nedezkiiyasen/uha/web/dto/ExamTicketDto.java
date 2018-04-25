package org.nedezkiiyasen.uha.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExamTicketDto extends Dto {
    private Set<QuestionDto> questions = new HashSet<>();
    @NotBlank
    private String rank;
}
