package com.courzelo.quiz_skills.skills.businesses;


import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;


import com.courzelo.quiz_skills.skills.entities.Microskills;
import com.courzelo.quiz_skills.skills.entities.Skills;
import com.courzelo.quiz_skills.skills.entities.Type;
import com.courzelo.quiz_skills.skills.entities.dtos.MacroskillsDTO;
import com.courzelo.quiz_skills.skills.entities.dtos.MicroskillsDTO;
import com.courzelo.quiz_skills.skills.entities.dtos.SkillsDTO;
import com.courzelo.quiz_skills.skills.repositories.SkillsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courzelo.quiz_skills.skills.businesses.iservices.IServiceSkills;




@Service
public class SkillsBusiness implements IServiceSkills {

    ModelMapper mapper=new ModelMapper();

    @Autowired
    SkillsRepository skillsrepository;



    @Override
    public SkillsDTO getskillbyid(String id) {
        Skills skill = skillsrepository.findById(id).orElseGet(Skills::new);
        return mapper.map(skill,SkillsDTO.class);
    }


    //retouner les macros skills selon le type et le user
    @Override
    public List<MacroskillsDTO> getmacroskills(String iduser, Type type) { //selon user id
        Skills skills = skillsrepository.findskillsByUser(iduser,type);
        List<MacroskillsDTO> l = new ArrayList<>();
       List<MacroskillsDTO> macro=  skills.getMacroskills().stream().map(macroskills->mapper.map(macroskills, MacroskillsDTO.class)).collect(Collectors.toList());


       int nb=macro.size()-1;

       for (int i = 0; i <= nb; i++) {
            l.add(macro.get(i));
        }

        return l;}

    @Override
    public List<MicroskillsDTO> getmicroskills(String iduser, String name, Type type) {
        List <MicroskillsDTO> l = new ArrayList<>();
            Skills skills = skillsrepository.findskillsByUser(iduser,type);

        List<MacroskillsDTO> macro=skills.getMacroskills().stream().map(macroskills->mapper.map(macroskills, MacroskillsDTO.class)).filter(m->m.getName().equalsIgnoreCase(name)).collect(Collectors.toList());

            int nb=macro.get(0).getmicroskills().size()-1;



        for (int i = 0; i <= nb; i++) {
         l.add(macro.get(0).getmicroskills().get(i));
        }
        return l;
        }
    @Override
    public List<List<Microskills>> getallmicroskills(String iduser, Type type) {
        List<List<Microskills>> l = new ArrayList<>();
        Skills skills = skillsrepository.findskillsByUser(iduser,type);
        l= skills.getMacroskills().stream().map(macroskills -> macroskills.getMicroskills()).collect(Collectors.toList());

        return l;
    }
    }




