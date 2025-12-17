package com.twochickendevs.bakeryuserlib.model;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private Integer status;
    private T data;
}
