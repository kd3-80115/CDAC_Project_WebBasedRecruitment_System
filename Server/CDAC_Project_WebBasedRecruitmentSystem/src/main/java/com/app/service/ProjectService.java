package com.app.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.app.payload.response.ProjectResponse;

public interface ProjectService {

	List<ProjectResponse> getProjectDetail();

}
