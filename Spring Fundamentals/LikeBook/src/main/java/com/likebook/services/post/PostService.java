package com.likebook.services.post;

import com.likebook.binding.AddPostForm;
import com.likebook.dto.PostDto;
import com.likebook.entities.Post;

import java.util.List;

public interface PostService {

    void addPost(AddPostForm addPostForm);

    List<PostDto> getAllPosts();

    Post getPostById(String postId);

    void deletePost(String postId);

    void likePost(String postId);
}
