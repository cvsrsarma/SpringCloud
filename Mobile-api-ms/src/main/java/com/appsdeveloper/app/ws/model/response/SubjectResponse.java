package com.appsdeveloper.app.ws.model.response;

import com.appsdeveloper.app.ws.entity.Subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class SubjectResponse{
	long id;
	private String subjectName;
	private Double marksObtained;
	
	public SubjectResponse(Subject obj) {
		this.id=obj.getId();
		this.subjectName=obj.getSubjectName();
		this.marksObtained=obj.getMarksObtained();
	}
	
	
}