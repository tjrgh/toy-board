package board.toyboard.Controller;

import board.toyboard.DTO.PostDTO;
import board.toyboard.Entity.Post;
import board.toyboard.Repository.PostRepository;
import board.toyboard.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
public class MainController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String hello(){
        return "hello toyBoard";
    }

    @GetMapping("/util")
    public PostDTO noName(){
        PostDTO postDTO = new PostDTO();
        postDTO.setContent("updateContent");
        postDTO.setId(10L);
        postDTO.setTitle("updateTitle");

        postService.updatePost(postDTO);
        return null;
    }

    /*게시글 하나 검색*/
    @GetMapping("/post/{id}")
    public PostDTO getPost(@PathVariable int id){
        PostDTO post = postService.getPost(id);

        return post;
    }

    /*게시글 목록 검색*/
    @GetMapping("/posts/{page}")
    public ArrayList<PostDTO> getPostList(@PathVariable int page){
        return (ArrayList<PostDTO>)postService.getPostList(page);
    }

    /*게시글 작성*/
    @PostMapping("/post")
    public void writePost(@RequestParam(name="title") String title, @RequestParam(name="content") String content){
        PostDTO post = new PostDTO();
        post.setContent(content);
        post.setTime(LocalDateTime.now());
        post.setTitle(title);

        System.out.println("title: "+title+", content : "+content);
        //로그인 처리하여 작성자에 User저장.
        //post.setWriter();

        postService.writePost(post);
    }

    //게시글 수정
    @PutMapping("/post")
    public void updatePost(@ModelAttribute PostDTO postDTO){
        postService.updatePost(postDTO);
    }
    
    /*게시글 삭제*/
    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable long id){
        postService.deletePost(id);
        
    }
}
