package board.toyboard.Entity;

import board.toyboard.DTO.PostDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="id")
    private User writer;

    private String title;
    private LocalDateTime time;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Post(){}
    public Post(PostDTO post){
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
