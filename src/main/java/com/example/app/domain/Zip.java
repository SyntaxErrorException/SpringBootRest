package com.example.app.domain;

import lombok.Data;

@Data
public class Zip {
	private String message;
	private Result[] results;
	private int status;
}
