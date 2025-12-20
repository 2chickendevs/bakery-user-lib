package com.twochickendevs.bakeryuserlib.service;

import com.twochickendevs.bakeryuserlib.client.UserClient;
import com.twochickendevs.bakeryuserlib.model.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserClient userClient;

    public UserInfo getUserInfo(String token) {
        try {
            return userClient.getUserInfo(token).getData();
        } catch (Exception e) {
            log.error("[Authentication] Error when get user info", e);
            return null;
        }
    }
}
