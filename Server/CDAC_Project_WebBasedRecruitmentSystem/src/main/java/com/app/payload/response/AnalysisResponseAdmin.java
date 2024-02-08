package com.app.payload.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnalysisResponseAdmin {

	private int totalNumberOfHr;
	private int activeHr;
	private int totalNumberOfJobs;
	private int openJobs;
}
