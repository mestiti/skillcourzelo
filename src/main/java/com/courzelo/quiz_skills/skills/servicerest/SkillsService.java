package com.courzelo.quiz_skills.skills.servicerest;

import com.courzelo.quiz_skills.skills.entities.Skills;
import com.courzelo.quiz_skills.skills.entities.dtos.SkillsDTO;
import com.courzelo.quiz_skills.skills.repositories.SkillsRepository;
import com.courzelo.quiz_skills.skills.servicerest.iservicesrest.IServiceRestSkills;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillsService implements IServiceRestSkills {

    @Autowired
    SkillsRepository skillsrepository;
    ModelMapper mapper=new ModelMapper();

    @Override
    public SkillsDTO addskills(SkillsDTO skills) {

        Skills s=mapper.map(skills,Skills.class);
        Skills tmps= skillsrepository.save(s);


        return mapper.map(tmps,SkillsDTO.class);

    }

    @Override
    public SkillsDTO updateskills(String id, SkillsDTO skilldto) {

        Skills skill=mapper.map(skilldto,Skills.class);
        Skills foundedskills = skillsrepository.findById(id).orElseGet(Skills::new);
        foundedskills.setType(skill.getType());
        foundedskills.setMacroskills(skill.getMacroskills());
        foundedskills.getMacroskills().get(0).setMicroskills(skill.getMacroskills().get(0).getMicroskills());
        Skills nesskill=skillsrepository.save(foundedskills);


        return mapper.map(nesskill,SkillsDTO.class);
    }


    @Override
    public List<SkillsDTO> getallskills() {
        List<Skills> skills=skillsrepository.findAll();

        return skills.stream().map(skill->mapper.map(skill,SkillsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteskills(String id) {

        Skills skill = skillsrepository.findById(id).orElseGet(Skills::new);
        skillsrepository.delete(skill);

    }
}
