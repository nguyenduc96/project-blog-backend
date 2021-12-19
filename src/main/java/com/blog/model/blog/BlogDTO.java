package com.blog.model.blog;

import com.blog.model.user.User;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class BlogDTO {
    private Long id;

    private String title;

    private String content;

    private String image;
}
