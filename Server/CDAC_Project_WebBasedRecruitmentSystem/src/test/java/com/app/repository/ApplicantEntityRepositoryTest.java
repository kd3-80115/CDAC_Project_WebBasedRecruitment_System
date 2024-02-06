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
	
	@Test
	void testAddApplicants() {
		
		UserEntity user1= userRepo.findById(5l).orElseThrow(() -> new UsernameNotFoundException("Email not found!!!!"));
		UserEntity user2= userRepo.findById(6l).orElseThrow(() -> new UsernameNotFoundException("Email not found!!!!"));
		UserEntity user3= userRepo.findById(7l).orElseThrow(() -> new UsernameNotFoundException("Email not found!!!!"));
		UserEntity user4= userRepo.findById(8l).orElseThrow(() -> new UsernameNotFoundException("Email not found!!!!"));
		
		List<ApplicantEntity> list = List.of(
				new ApplicantEntity(user1, false, false, "Headline1", "Profile Summary1", "Single"),
				new ApplicantEntity(user2, false, false, "Headline1", "Profile Summary1", "Single"),
				new ApplicantEntity(user3, false, false, "Headline1", "Profile Summary1", "Single"),
				new ApplicantEntity(user4, false, false, "Headline1", "Profile Summary1", "Single")
				);
		List<ApplicantEntity> list2 = applicantRepo.saveAll(list);
		assertEquals(4, list2.size());

	}
}
