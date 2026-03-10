package com.twochickendevs.bakeryuserlib.client;

import com.twochickendevs.bakerycommonlib.model.ApiResponse;
import com.twochickendevs.bakeryuserlib.model.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "bakeryUserService", url = "${app.clients.bakery-user-service.url}")
public interface UserClient {

    @GetMapping("/users")
    ApiResponse<UserInfo> getUserInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader);
}
