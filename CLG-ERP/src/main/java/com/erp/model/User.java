package com.erp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private String role;
	private int status;

}
