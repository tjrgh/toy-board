package board.toyboard.Repository;

import board.toyboard.Entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {


    @Query("select p from Post p where p.id = :post_id")
    public Post getPostById(long post_id);

    //게시글 목록 검색.
    @Query("select p from Post p")
    public Page<Post> getPostList(Pageable pageable);
}
