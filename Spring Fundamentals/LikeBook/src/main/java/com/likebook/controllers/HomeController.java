package com.likebook.controllers;

import com.likebook.dto.PostDto;
import com.likebook.services.post.PostService;
import com.likebook.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final UserService userService;
    private final PostService postService;

    public HomeController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;

    }

    @ModelAttribute("ownPosts")
    public List<PostDto> getOwnPosts() {
        return this.postService
                .getAllPosts()
                .stream()
                .filter(e -> e.getUsername().equals(userService.getCurrentUsername()))
                .toList();
    }

    @ModelAttribute("otherPosts")
    public List<PostDto> getOtherPosts() {
        return this.postService
                .getAllPosts()
                .stream()
                .filter(e -> !e.getUsername().equals(userService.getCurrentUsername()))
                .toList();
    }

    @GetMapping("/")
    public String getIndex() {
        if (this.userService.hasUser()) {
            return "home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String getHome() {
        if (this.userService.hasUser()) {
            return "home";
        }

        return "redirect:/";
    }


}
