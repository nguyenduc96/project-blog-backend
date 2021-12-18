package com.blog.model.blog;

import com.blog.model.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String image;

    private String date;

    @ManyToOne
    private User user;
}
