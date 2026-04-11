package com.github.irohasu2120.sample_bbs.api.login.model;

import lombok.Data;

@Data
public class LoginRequestBody {
    private String id;
    private String password;
}
