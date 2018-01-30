package com.bipo.iac.exceptions;

public class MobileRegisteredException extends Exception {
    public MobileRegisteredException() {
        super("There is already a user registered with the mobileNo provided");
    }
}
