package com.inesshasanoui.bibliotheekbeheersysteem.service;

import com.inesshasanoui.bibliotheekbeheersysteem.model.User;
import com.inesshasanoui.bibliotheekbeheersysteem.service.exception.AuthenticationException;

public interface AuthenticationService {
	User login(String username, String password) throws AuthenticationException;
	 User register(User user);
	 Boolean hasPermissionMember (User user);
	 Boolean hasPermissionLibrarian (User user);
}
