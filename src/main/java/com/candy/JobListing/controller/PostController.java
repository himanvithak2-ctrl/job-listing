package com.candy.JobListing.controller;

import com.candy.JobListing.model.Post;
import com.candy.JobListing.repo.PostRepository;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@Tag(name = "Job Listing", description = "APIs for listing Jobs")
public class PostController
{
    @Autowired
    PostRepository repo;

    @RequestMapping(value="/")
    @Hidden
    public void  redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/getAllPosts")
    public List<Post> getAllPosts() {
      return repo.findAll();
    }

    @PostMapping("/postJob")
    public Post postJob(@RequestBody Post post) {
        return repo.save(post);
    }



}
