package board.toyboard.DTO;

import board.toyboard.Entity.Post;
import board.toyboard.Entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;

public class PostDTO {
    private Long id;
    private User writer;
    private String title;
    private LocalDateTime time;
    private String content;

    public PostDTO(){}
    public PostDTO(Post post){
        id=post.getId();
        writer=post.getWriter();
        title=post.getTitle();
        time=post.getTime();
        content=post.getContent();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
