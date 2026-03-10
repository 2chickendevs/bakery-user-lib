package com.twochickendevs.bakeryuserlib.model;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;

    public UserAuthenticationToken(UserInfo userInfo, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
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
