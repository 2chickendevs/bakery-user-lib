package com.twochickendevs.bakeryuserlib.model;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collections;

public class UserAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;

    public UserAuthenticationToken(UserInfo userInfo) {
        super(Collections.emptyList());
        this.principal = userInfo;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    public UserInfo getUserInfo() {
        return (UserInfo) getPrincipal();
    }
}
