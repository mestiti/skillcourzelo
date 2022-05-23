package com.courzelo.quiz_skills.skills.servicerest.iservicesrest;

import com.courzelo.quiz_skills.skills.entities.dtos.SkillsDTO;

import java.util.List;

public interface IServiceRestSkills {
    public SkillsDTO addskills(SkillsDTO skills);
    public SkillsDTO updateskills(String id, SkillsDTO skilldto);
    public List<SkillsDTO> getallskills();
    public void deleteskills(String id );
}
