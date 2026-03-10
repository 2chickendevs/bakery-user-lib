package com.twochickendevs.bakeryuserlib.service;

import com.twochickendevs.bakerycommonlib.exception.AuthenticationException;
import com.twochickendevs.bakeryuserlib.model.UserAuthenticationToken;
import com.twochickendevs.bakeryuserlib.model.UserInfo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CurrentPrincipal {

    public UserInfo getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            UserAuthenticationToken token = (UserAuthenticationToken) authentication;
            return token.getUserInfo();
        }

        throw new AuthenticationException("Unauthenticated request");
    }
}
