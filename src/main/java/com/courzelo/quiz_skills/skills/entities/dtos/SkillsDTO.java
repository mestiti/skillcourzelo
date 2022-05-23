package com.courzelo.quiz_skills.skills.entities.dtos;


import com.courzelo.quiz_skills.skills.entities.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SkillsDTO {
    private String id;
    private String iduser;
    @Enumerated(EnumType.STRING)
    private Type type;
    private List<MacroskillsDTO> macroskills;

    public SkillsDTO()
    {
        super();
    }
}
