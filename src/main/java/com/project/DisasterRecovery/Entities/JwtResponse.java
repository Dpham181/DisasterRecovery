package com.project.DisasterRecovery.Entities;

import java.io.Serializable;

import lombok.*;



@Setter
@Getter
@AllArgsConstructor

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final String role;

}