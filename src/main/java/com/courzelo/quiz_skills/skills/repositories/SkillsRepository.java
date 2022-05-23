package com.courzelo.quiz_skills.skills.repositories;


import com.courzelo.quiz_skills.skills.entities.Type;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.courzelo.quiz_skills.skills.entities.Skills;




@Repository
public interface SkillsRepository extends MongoRepository<Skills, String>{

    @Query("{iduser: ?0, type: ?1}")
    Skills findskillsByUser(String iduser, Type type); //trouver sol pour type

}
