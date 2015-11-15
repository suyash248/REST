package com.soni.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.soni.messenger.model.Profile;
import com.soni.messenger.service.ProfileService;

@Path(value="/profiles")
public class ProfileResource {
	ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	@Path(value="/{userName}")
	public Profile getProfile(@PathParam(value="userName") String userName) {
		return profileService.getProfile(userName);
	}
	
	@POST
	@Produces(value=MediaType.APPLICATION_JSON)
	@Consumes(value=MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Produces(value=MediaType.APPLICATION_JSON)
	@Consumes(value=MediaType.APPLICATION_JSON)
	@Path(value="/{userName}")
	public Profile updateProfile(Profile profile, @PathParam(value="usesrName") String userName) {
		return profileService.updateProfile(profile);
	}

	@DELETE
	@Produces(value=MediaType.APPLICATION_JSON)
	@Path(value="/{userName}")
	public Profile removeProfile(@PathParam(value="userName") String userName) {
		return profileService.removeProfile(userName);
	}
}
