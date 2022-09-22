package com.example.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
	private String address1;
	private String address2;
	private String address3;
	private String kana1;
	private String kana2;
	private String kana3;
}
