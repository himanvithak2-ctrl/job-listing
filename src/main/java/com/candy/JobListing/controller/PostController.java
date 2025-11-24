package com.candy.JobListing.controller;

import com.candy.JobListing.model.Post;
import com.candy.JobListing.repo.PostRepository;
import com.candy.JobListing.repo.SearchRepository;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Job Listing", description = "APIs for listing Jobs")
public class PostController
{
    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository searchRepo;

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
    public void postJob(@RequestBody Post post) {
        System.out.println(post);
        repo.save(post);
    }

    @GetMapping("/search/{text}")
    public List<Post> search(@PathVariable String text)
    {
        return searchRepo.findByText(text);
    }
}
