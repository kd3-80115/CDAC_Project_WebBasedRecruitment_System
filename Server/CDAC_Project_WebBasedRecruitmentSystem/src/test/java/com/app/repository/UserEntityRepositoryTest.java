package com.app.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
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
	void testAddUsers1() {
		List<UserEntity> list = List.of(
				new UserEntity("Adnan", "Khan",Gender.MALE,"adnan@gmail.com","9876543210",enc.encode("12345"),LocalDate.of(2000, 10, 5) ,UserRole.ROLE_ADMIN),
				new UserEntity("Mahendr", "Kumar",Gender.MALE,"mahender@gmail.com","9898747465",enc.encode("2345"),LocalDate.of(1998, 7,8) ,UserRole.ROLE_APPLICANT),
				new UserEntity("Arshad", "Mujawar",Gender.MALE,"arshad@gmail.com","9876543210",enc.encode("1345"), LocalDate.of(1999, 8, 25),UserRole.ROLE_HR),
				new UserEntity("Naveen", "Kumar",Gender.MALE,"naveen@gmail.com","9555414192",enc.encode("9555"),LocalDate.of(1997, 10, 2) ,UserRole.ROLE_APPLICANT),
				new UserEntity("Mugdha", "Moghe",Gender.FEMALE,"mugdha@gmail.com","9555414193",enc.encode("8555"), LocalDate.of(2000, 5, 12),UserRole.ROLE_APPLICANT),
				new UserEntity("Prashant", "Rathor",Gender.MALE,"prashant@gmail.com","9555414194",enc.encode("7555"),LocalDate.of(1999, 12, 30) ,UserRole.ROLE_APPLICANT),
				new UserEntity("Himanshu", "Kumar",Gender.MALE,"himashu@gmail.com","9555414195",enc.encode("6555"), LocalDate.of(1998, 5, 21),UserRole.ROLE_APPLICANT)
				);
		List<UserEntity> list2 = userRepo.saveAll(list);
		assertEquals(7, list2.size());

	}
	
}
