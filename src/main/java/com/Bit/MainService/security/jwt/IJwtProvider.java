package com.Bit.MainService.security.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.Bit.MainService.security.UserPrincipal;

public interface IJwtProvider {

	String generateToken(UserPrincipal authentication);

	Authentication getAuhentication(HttpServletRequest request);

	boolean isTokenValid(HttpServletRequest request);

}
