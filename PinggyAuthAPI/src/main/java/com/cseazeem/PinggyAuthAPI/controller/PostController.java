package com.cseazeem.PinggyAuthAPI.controller;

import com.cseazeem.PinggyAuthAPI.config.ThreadLocalStorage;
import com.cseazeem.PinggyAuthAPI.dto.PostRequestDTO;
import com.cseazeem.PinggyAuthAPI.dto.PostResponseDTO;
import com.cseazeem.PinggyAuthAPI.storage.InMemoryStorage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody PostRequestDTO postRequest, @RequestHeader(value = "Authorization", required = false) String authHeader) {
        if (authHeader == null || !isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        String pinggyAuthHeader = ThreadLocalStorage.getPinggyAuthHeader();
        PostResponseDTO post = new PostResponseDTO(postRequest.getTitle(), postRequest.getBody(), pinggyAuthHeader);
        InMemoryStorage.addPost(post);
        return ResponseEntity.ok("Post created successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<PostResponseDTO>> getPosts(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        if (authHeader == null || !isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        List<PostResponseDTO> posts = InMemoryStorage.getPosts();
        return ResponseEntity.ok(posts);
    }

    private boolean isAuthenticated() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal instanceof UserDetails;
    }
}
