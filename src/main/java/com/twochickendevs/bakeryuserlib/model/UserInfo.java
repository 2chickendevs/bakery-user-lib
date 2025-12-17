package com.twochickendevs.bakeryuserlib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
}
