package com.soni.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.soni.messenger.datasource.InMemoryDataSource;
import com.soni.messenger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = InMemoryDataSource.getProfiles();
	
	public ProfileService() {
		profiles.put("suyash248", new Profile(1L, "suyash248", "Suyash", "Soni"));
		profiles.put("abhi25", new Profile(2L, "abhi25", "Abhi", "Soni"));	
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String userName) {
		return profiles.get(userName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getUserName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		profiles.put(profile.getUserName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String userName) {
		Profile message = profiles.get(userName);
		profiles.remove(userName);
		return message;
	}
}
