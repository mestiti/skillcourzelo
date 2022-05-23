package com.courzelo.quiz_skills.skills.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MicroskillsDTO {
    private String name;
    private float progress;

    public MicroskillsDTO()
    {super();}
}
