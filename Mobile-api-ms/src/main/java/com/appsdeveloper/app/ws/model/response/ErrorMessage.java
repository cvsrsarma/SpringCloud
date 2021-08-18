package com.appsdeveloper.app.ws.model.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class ErrorMessage {
	
	private Date timeStamp;
	private String errorMessage;

}
