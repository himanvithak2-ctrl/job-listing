package com.candy.JobListing.repo;

import com.candy.JobListing.model.Post;

import java.util.List;

public interface SearchRepository {

     List<Post> findByText(String text);
}
