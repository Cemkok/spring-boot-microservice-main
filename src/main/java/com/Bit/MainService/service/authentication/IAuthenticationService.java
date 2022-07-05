package com.Bit.MainService.service.authentication;

import com.Bit.MainService.model.User;

public interface IAuthenticationService {

	String signInAndReturnJWT(User signInRequest);

}
