package com.likebook.services.post;

import com.likebook.binding.AddPostForm;
import com.likebook.dto.PostDto;
import com.likebook.entities.Mood;
import com.likebook.entities.Post;
import com.likebook.entities.User;
import com.likebook.repositories.PostRepository;
import com.likebook.services.mood.MoodService;
import com.likebook.services.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final MoodService moodService;
    private final UserService userService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, MoodService moodService, UserService userService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.moodService = moodService;
        this.userService = userService;
    }

    @Override
    public void addPost(AddPostForm addPostForm) {
        Post post = this.modelMapper.map(addPostForm, Post.class);
        Mood mood = this.moodService.getMoodByName(addPostForm.getMood());
        User user = this.userService.getCurrentUser();

        post.setMood(mood);
        post.setUser(user);

        this.postRepository.save(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<PostDto> posts = new ArrayList<>();

        for (Post post : this.postRepository.findAll()) {
            PostDto postDto = this.modelMapper.map(post, PostDto.class);
            postDto.setMood(post.getMood().moodName.name());
            postDto.setUsername(post.getUser().getUsername());
            postDto.setLikesCount(post.getUserLikes().size());
            posts.add(postDto);
        }

        return posts;
    }

    @Override
    public Post getPostById(String postId) {
        return this.postRepository.getPostById(UUID.fromString(postId));
    }

    @Override
    public void deletePost(String postId) {
        this.postRepository.deleteById(UUID.fromString(postId));
    }

    @Override
    public void likePost(String postId) {
        Post post = this.postRepository.getPostById(UUID.fromString(postId));
        User currentUser = this.userService.getCurrentUser();

        List<User> userLikes = post.getUserLikes();

        boolean hasLiked = userLikes.stream().anyMatch(e -> e.username.equals(currentUser.getUsername()));

        if(hasLiked){
            return;
        }

        userLikes.add(currentUser);
        this.postRepository.save(post);
    }
}
