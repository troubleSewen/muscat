package com.bipo.iac.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MobileRegisteredException extends Exception {
    public MobileRegisteredException() {
        super("There is already a user registered with the mobileNo provided");
    }
}
