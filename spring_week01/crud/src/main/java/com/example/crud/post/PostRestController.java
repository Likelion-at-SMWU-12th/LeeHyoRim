package com.example.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostRestController{
    private static final Logger logger= LoggerFactory.getLogger(PostRestController.class);
    private final List<PostDto> postList;
    public PostRestController() {
        this.postList = new ArrayList<>();
    }

    // 1 createPost 게시물 생성
    // http://localhost:8080/post
    // POST /post

    @PostMapping()
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postList.add(postDto);
    }

    // 2 get 모든 게시물 조회
    // http://localhost:8080/post
    // GET /post
    @GetMapping()
    public List<PostDto> readPostAll(){
        logger.info("iin read post all");
        return this.postList;
    }

    // 3 get 특정 게시물 조회
    // GET /post/0/
    // GET /post?id=0/
    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id){
        logger.info("in read post");
        return this.postList.get(id);
    }

    // 4 게시물 수정
    // PUT /post/{id}
    @PutMapping("{id}")
    public void updatePost(@PathVariable("id") int id, @RequestBody PostDto postDto) {
        logger.info("in update post");
        PostDto existingPost = this.postList.get(id);
        existingPost.setTitle(postDto.getTitle());
        existingPost.setContent(postDto.getContent());
        existingPost.setWriter(postDto.getWriter());
    }

    // 5 게시물 삭제
    // DELETE /post/{id}
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id) {
        logger.info("in delete post");
        this.postList.remove(id);
    }
}

