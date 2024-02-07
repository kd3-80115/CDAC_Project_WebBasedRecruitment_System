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
import com.app.entities.Gender;
import com.app.entities.SkillEntity;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ApplicantEntityRepositoryTest {
	
	@Autowired
	private UserEntityRepository userRepo;
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired
	private SkillEntityRepository skillRepo;
	
	@Test
	void testAddApplicants() {
		
		UserEntity user1= userRepo.findById(4l).orElseThrow(() -> new UsernameNotFoundException("Email not found!!!!"));
		UserEntity user2= userRepo.findById(5l).orElseThrow(() -> new UsernameNotFoundException("Email not found!!!!"));
		UserEntity user3= userRepo.findById(6l).orElseThrow(() -> new UsernameNotFoundException("Email not found!!!!"));
		UserEntity user4= userRepo.findById(7l).orElseThrow(() -> new UsernameNotFoundException("Email not found!!!!"));
		
		List<ApplicantEntity> list = List.of(
				new ApplicantEntity(user1, false, false, "Headline1", "Profile Summary1", "Single"),
				new ApplicantEntity(user2, false, false, "Headline1", "Profile Summary1", "Single"),
				new ApplicantEntity(user3, false, false, "Headline1", "Profile Summary1", "Single"),
				new ApplicantEntity(user4, false, false, "Headline1", "Profile Summary1", "Single")
				);
		List<ApplicantEntity> list2 = applicantRepo.saveAll(list);
		assertEquals(4, list2.size());

	}
	
	@Test
	void testAddApplicantSkill() {
		
		SkillEntity skill1= skillRepo.findById(1l).orElseThrow(() -> new UsernameNotFoundException("Email not found!!!!"));
		SkillEntity skill2= skillRepo.findById(2l).orElseThrow(() -> new UsernameNotFoundException("Email not found!!!!"));
		SkillEntity skill3= skillRepo.findById(3l).orElseThrow(() -> new UsernameNotFoundException("Email not found!!!!"));
		SkillEntity skill4= skillRepo.findById(4l).orElseThrow(() -> new UsernameNotFoundException("Email not found!!!!"));
		

		ApplicantEntity applicant1= applicantRepo.findById(1l).orElseThrow();
		ApplicantEntity applicant2= applicantRepo.findById(2l).orElseThrow();
		ApplicantEntity applicant3= applicantRepo.findById(3l).orElseThrow();
		ApplicantEntity applicant4= applicantRepo.findById(4l).orElseThrow();
		
		applicant1.addSkill(skill1);
		applicant2.addSkill(skill2);
		applicant3.addSkill(skill3);
		applicant4.addSkill(skill4);
		

	}
}

