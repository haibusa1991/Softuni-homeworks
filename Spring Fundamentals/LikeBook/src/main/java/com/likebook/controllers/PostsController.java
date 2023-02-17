package com.likebook.controllers;

import com.likebook.binding.AddPostForm;
import com.likebook.entities.Post;
import com.likebook.services.mood.MoodService;
import com.likebook.services.post.PostService;
import com.likebook.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/posts")
public class PostsController {
    private final UserService userService;
    private final MoodService moodService;
    private final PostService postService;


    public PostsController(UserService userService, MoodService moodService, PostService postService) {
        this.userService = userService;
        this.moodService = moodService;
        this.postService = postService;
    }

    @ModelAttribute("addPostForm")
    private AddPostForm getAddPostForm() {
        return new AddPostForm();
    }

    @ModelAttribute("allMoods")
    private String[] getAllMoods() {
        return this.moodService.getAllMoods();
    }


    @GetMapping("add-post")
    public String AddPostForm() {
        if (!this.userService.hasUser()) {
            return "redirect:/user/login";
        }

        return "post-add";
    }


    @PostMapping("add-post")
    public String publishPost(@Valid AddPostForm addPostForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (!this.userService.hasUser()) {
            return "redirect:/user/login";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addPostForm", addPostForm);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addPostForm", bindingResult);

            return "redirect:add-post";
        }

        this.postService.addPost(addPostForm);
        return "redirect:/home";
    }

    @GetMapping(value = "/remove/{postId}")
    public String deletePost(@PathVariable String postId){
        Post post = this.postService.getPostById(postId);

        if(this.userService.getCurrentUsername().equals(post.user.getUsername())){
            this.postService.deletePost(postId);
        }

        return "redirect:/";
    }

    @GetMapping(value = "/like/{postId}")
    public String likePost(@PathVariable String postId){
        this.postService.likePost(postId);
        return "redirect:/";
    }

}
