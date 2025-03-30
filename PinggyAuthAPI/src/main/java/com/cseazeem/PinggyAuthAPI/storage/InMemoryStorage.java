package com.cseazeem.PinggyAuthAPI.storage;


import com.cseazeem.PinggyAuthAPI.dto.PostResponseDTO;
import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {
    private static final List<PostResponseDTO> posts = new ArrayList<>();

    public static void addPost(PostResponseDTO post) {
        posts.add(post);
    }

    public static List<PostResponseDTO> getPosts() {
        return new ArrayList<>(posts); // Return a copy to avoid modification
    }
}
