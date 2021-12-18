package com.blog.model.like;

import com.blog.model.blog.Blog;
import com.blog.model.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "likes")
public class Like {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String date;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Blog> blogs;
}
