package com.blog.model.user;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JWTResponse {
    private Long id;

    private String token;

    private String username;

    private String type = "Bearer";

    private Collection<? extends GrantedAuthority> roles;

    public JWTResponse() {
    }

    public JWTResponse(Long id, String token, String username, String type, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.type = type;
        this.roles = roles;
    }
}
