package com.amigoscode.springboot.sbcourse.jsonplaceholder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "jsonplaceholder",
        url = "https://jsonplaceholder.typicode.com/"
)
public interface JSONPlaceholderClient {
    @GetMapping("posts")
    List<Post> getPosts();

    @GetMapping("posts/{userId}")
    Post getPost(@PathVariable("userId") Integer userId);
}
