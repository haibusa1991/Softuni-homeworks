package com.likebook.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddPostForm {

    @NotBlank
    @Size(min = 2, max = 50)
    private String content;

    @NotBlank
    private String mood;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
