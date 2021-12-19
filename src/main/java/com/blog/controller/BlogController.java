package com.blog.controller;

import com.blog.model.blog.Blog;
import com.blog.model.blog.BlogDTO;
import com.blog.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Blog>> getAllBlog() {
        return ResponseEntity.ok(blogService.findAll());
    }

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody BlogDTO blogDTO, Authentication authentication) {
        Blog blog = new Blog();
        blog.setId(blogDTO.getId());
        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());
        blog.setImage(blogDTO.getImage());
        blog.setDate(convertDateToString(new Date()));
        return ResponseEntity.ok(blogService.save(blog));
    }

    private String convertDateToString(Date date) {
        Format format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(date);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(blogService.findById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") Long id, @RequestBody BlogDTO blogDTO, Authentication authentication) {
        Blog blog = blogService.findById(id).get();
        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());
        blog.setImage(blogDTO.getImage());
        blog.setDate(convertDateToString(new Date()));
        return ResponseEntity.ok(blogService.save(blog));
    }
}
