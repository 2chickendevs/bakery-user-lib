package com.twochickendevs.bakeryuserlib.filter;

import com.twochickendevs.bakeryuserlib.constant.AppConstant;
import com.twochickendevs.bakeryuserlib.model.UserAuthenticationToken;
import com.twochickendevs.bakeryuserlib.model.UserInfo;
import com.twochickendevs.bakeryuserlib.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Log4j2
@NoArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.isNoneBlank(token)) {
            UserInfo userInfo = userService.getUserInfo(token);
            if (userInfo != null) {
                UserAuthenticationToken authenticationToken = new UserAuthenticationToken(userInfo);

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(AppConstant.UNAUTHORIZED_MESSAGE);
                return;
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token not found");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
