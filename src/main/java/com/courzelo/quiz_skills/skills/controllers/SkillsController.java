package com.courzelo.quiz_skills.skills.controllers;

import com.courzelo.quiz_skills.skills.entities.Type;
import com.courzelo.quiz_skills.skills.entities.dtos.MacroskillsDTO;
import com.courzelo.quiz_skills.skills.entities.dtos.MicroskillsDTO;
import com.courzelo.quiz_skills.skills.entities.dtos.SkillsDTO;
import com.courzelo.quiz_skills.skills.repositories.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.courzelo.quiz_skills.skills.businesses.iservices.IServiceSkills;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping( "/skills" )
@RestController
public class SkillsController {
	@Autowired
	private IServiceSkills iskills;
	@Autowired
	SkillsRepository skillsrepository;

	@GetMapping("/get_skillsbyid/{id}")
	public SkillsDTO showskillbyid(@PathVariable("id") String id) {

		return  iskills.getskillbyid(id);

	}



	//get macro hard skills from one user
	@GetMapping(path = "/getHardMacroByIdUser/{id}")
	public List<MacroskillsDTO> gethardmacroskills(@PathVariable("id") String id) {

		return iskills.getmacroskills(id, Type.HARD);
	}

	//get macro soft skills from one user
	@GetMapping(path = "/getSoftMacroByIdUser/{id}")
	public List<MacroskillsDTO> getSoftmacroskills(@PathVariable("id") String id) {
		return iskills.getmacroskills(id,Type.SOFT);
	}

	//get micro skills from one user according to a hard skill
	@GetMapping(path = "/getHardMicroByIdUser/{id}/{name}")
	public List<MicroskillsDTO> gethardmicrobyiduser(@PathVariable("id") String id , @PathVariable("name")  String name) {
		return iskills.getmicroskills(id,name,Type.HARD);
	}
	//get micro skills from one user according to a hard skill
	@GetMapping(path = "/getSoftMicroByIdUser/{id}/{name}")
	public List<MicroskillsDTO> getsoftmicrobyiduser(@PathVariable("id") String id , @PathVariable("name")  String name) {
		return iskills.getmicroskills(id,name,Type.SOFT);
	}

}
