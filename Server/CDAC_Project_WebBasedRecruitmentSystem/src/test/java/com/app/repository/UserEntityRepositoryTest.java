package com.app.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Gender;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;
import com.app.repository.UserEntityRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserEntityRepositoryTest {
	// dep
	@Autowired
	private UserEntityRepository userRepo;

	@Autowired
	private PasswordEncoder enc;

	@Test
	void testAddUsers() {
		List<UserEntity> list = List.of(
//				new UserEntity("a1", "b1",Gender.MALE,"a1@gmail.com","9876543210",enc.encode("12345"), UserRole.ROLE_ADMIN),
//				new UserEntity("a2", "b2",Gender.FEMALE,"a2@gmail.com","9898747465",enc.encode("2345"), UserRole.ROLE_APPLICANT),
//				new UserEntity("a3", "b3",Gender.FEMALE,"a3@gmail.com","9876543210",enc.encode("1345"), UserRole.ROLE_HR),
				new UserEntity("a4", "b4",Gender.FEMALE,"a4@gmail.com","9876543210",enc.encode("3232"), UserRole.ROLE_HR)
				);
		List<UserEntity> list2 = userRepo.saveAll(list);
		assertEquals(1, list2.size());

	}
	
	@Test
	void testAddUsers2() {
		List<UserEntity> list = List.of(
//				new UserEntity("a1", "b1",Gender.MALE,"a1@gmail.com","9876543210",enc.encode("12345"), UserRole.ROLE_ADMIN),
//				new UserEntity("a2", "b2",Gender.FEMALE,"a2@gmail.com","9898747465",enc.encode("2345"), UserRole.ROLE_APPLICANT),
//				new UserEntity("a3", "b3",Gender.FEMALE,"a3@gmail.com","9876543210",enc.encode("1345"), UserRole.ROLE_HR),
				new UserEntity("Naveen", "Kumar",Gender.MALE,"naveen@gmail.com","9555414192",enc.encode("9555"), UserRole.ROLE_APPLICANT),
				new UserEntity("Mugdha", "Moghe",Gender.FEMALE,"mugdha@gmail.com","9555414193",enc.encode("8555"), UserRole.ROLE_APPLICANT),
				new UserEntity("Prashant", "Rathor",Gender.MALE,"prashant@gmail.com","9555414194",enc.encode("7555"), UserRole.ROLE_APPLICANT),
				new UserEntity("Himanshu", "Kumar",Gender.MALE,"himashu@gmail.com","9555414195",enc.encode("6555"), UserRole.ROLE_APPLICANT)
				);
		List<UserEntity> list2 = userRepo.saveAll(list);
		assertEquals(4, list2.size());

	}

}
