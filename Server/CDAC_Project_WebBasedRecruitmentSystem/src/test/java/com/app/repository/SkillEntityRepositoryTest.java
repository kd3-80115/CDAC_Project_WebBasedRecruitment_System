package com.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.annotation.Rollback;

import com.app.entities.ApplicantEntity;
import com.app.entities.SkillEntity;
import com.app.entities.UserEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SkillEntityRepositoryTest {

	
	@Autowired
	private SkillEntityRepository skillRepo;
	
	@Test
	void testAddSkills() {
		
		
		List<SkillEntity> list = List.of(
				new SkillEntity("Java"),
				new SkillEntity("C++"),
				new SkillEntity("C"),
				new SkillEntity("Java Script"),
				new SkillEntity("Node js"),
				new SkillEntity("Express js"),
				new SkillEntity("Spring Boot"),
				new SkillEntity("React js"),
				new SkillEntity("Express js"),
				new SkillEntity("JWT")
				
				
				
				);
		List<SkillEntity> list2 = skillRepo.saveAll(list);
		assertEquals(7, list2.size());

	}
}
