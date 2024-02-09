package com.app.service;

import java.util.List;
import java.util.Set;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ApplicantEntity;
import com.app.entities.SkillEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.response.ProjectResponse;
import com.app.payload.response.SkillResponse;
import com.app.repository.ApplicantRepository;
import com.app.repository.SkillEntityRepository;



@Service
@Transactional
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired
	private SkillEntityRepository skillRepo;
	
	@Autowired //To map entity with the DTO 
	private ModelMapper mapper;

	
	
	
}
