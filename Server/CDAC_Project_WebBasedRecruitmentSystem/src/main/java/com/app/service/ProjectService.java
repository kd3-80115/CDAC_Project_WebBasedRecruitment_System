package com.app.service;

import java.util.List;

import com.app.payload.response.ProjectResponse;

public interface ProjectService {

	List<ProjectResponse> getProjectDetail(Long applicantId);

}
