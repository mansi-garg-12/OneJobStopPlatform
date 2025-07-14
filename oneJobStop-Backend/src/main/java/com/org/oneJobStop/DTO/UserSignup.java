package com.org.oneJobStop.DTO;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class UserSignup {

    private String name;
    private String phoneNumber;
    private String email;
    private String role;
    private String password;

}
