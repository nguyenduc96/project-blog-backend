package com.blog.model.user;

import com.blog.model.role.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String fullName;

    private String email;

    private String phone;

    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
