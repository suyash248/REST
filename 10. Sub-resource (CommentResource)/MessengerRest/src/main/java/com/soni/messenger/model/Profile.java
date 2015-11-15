package com.soni.messenger.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Profile {
	private long id;
	private String userName;
	private String firstName;
	private String lastName;
}
