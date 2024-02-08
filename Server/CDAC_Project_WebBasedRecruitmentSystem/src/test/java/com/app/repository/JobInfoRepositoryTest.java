package com.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.ApplicantEntity;
import com.app.entities.DepartmentEntity;
import com.app.entities.HREntity;
import com.app.entities.JobInfoEntity;
import com.app.entities.WorkSchedule;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class JobInfoRepositoryTest {

	@Autowired
	private JobInfoRepository jobRepo;
	
	@Autowired
	private DepartmentEntityRepository depRepo;
	
	@Autowired
	private HREntityRepository hrRepo;
	
	@Autowired
	private ApplicantRepository appRepo;
	
	@Test
	public void addJob()
	{
		DepartmentEntity depart1= depRepo.findById(1l).orElseThrow();
		DepartmentEntity depart2= depRepo.findById(2l).orElseThrow();
		HREntity hr=hrRepo.findById(3L).orElseThrow();
		
		List<JobInfoEntity> jobList = List.of(
			    new JobInfoEntity("Software Engineer", 2, WorkSchedule.FULL_TIME, 80000, LocalDate.now().plusMonths(1), "Remote", LocalDate.now(), "Bachelor's in Computer Science",hr,depart1),
			    new JobInfoEntity("Data Scientist", 3, WorkSchedule.FULL_TIME, 85000, LocalDate.now().plusMonths(1), "Office", LocalDate.now(), "Master's in Data Science",hr,depart2)
			);
		List<JobInfoEntity> jobListTest=jobRepo.saveAll(jobList);
		assertEquals(2,jobListTest.size());
	}
	
	@Test
	public void addSavedJob()
	{
		ApplicantEntity app=appRepo.findById(1L).orElseThrow();
		JobInfoEntity job=jobRepo.findById(1L).orElseThrow();
		job.addApplicant(app);
		
	}
	
}
