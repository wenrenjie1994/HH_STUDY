package com.jinjie.sun.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String phone;
    private String addr;
    private String email;
    private String role;
}
