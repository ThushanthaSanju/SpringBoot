package com.lab.first.firstProject.controller;

import com.lab.first.firstProject.api.PostApi;
import com.lab.first.firstProject.domain.Post;
import com.lab.first.firstProject.dto.PodtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostEndPoint {
    private final PostApi postApi;

    @Autowired
    public PostEndPoint(PostApi postApi){
        this.postApi =postApi;
    }

    @GetMapping
    public List<Post> getPosts(){
        return postApi.getAllPosts();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost(@RequestBody PodtDto postDto){
    Post post = new Post();
    post.setName(postDto.getName());
    post.setDescription(postDto.getDescription());
    return postApi.addPost(post);
    }
}
