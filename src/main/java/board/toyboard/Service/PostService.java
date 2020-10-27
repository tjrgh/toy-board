package board.toyboard.Service;

import board.toyboard.DTO.PostDTO;
import board.toyboard.Entity.Post;
import board.toyboard.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    //게시글 하나 검색 메소드.
    @Transactional(readOnly = true)
    public PostDTO getPost(long id){
        Post post = postRepository.getPostById(id);
        PostDTO postDto = new PostDTO(post);
        return postDto;
    }

    //게시글 목록 검색 메소드.
    @Transactional(readOnly = true)
    public List<PostDTO> getPostList(int pageNum){
        List<PostDTO> postDtoList = new ArrayList<PostDTO>();//반환할 게시글 리스트.
        Pageable pageable = PageRequest.of(pageNum,20, Sort.by("time").descending());
        Page<Post> page = postRepository.getPostList(pageable);//페이지를 받아옴.
        List<Post> postList = page.getContent();
        Iterator<Post> iterator = postList.iterator();
        Post tempPost=null;
        while(iterator.hasNext()){
            tempPost=iterator.next();
            postDtoList.add(new PostDTO(tempPost));
        }
        return postDtoList;
    }

    //게시글 작성 메소드.
    @Transactional
    public void writePost(PostDTO postDto){
        postRepository.save(new Post(postDto));
    }

    //게시글 삭제 메소드.
    @Transactional
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    //게시글 수정 메소드.
    public void updatePost(PostDTO postDTO) {
        Optional<Post> opt = postRepository.findById(postDTO.getId());
        if(opt.isPresent()){
            Post post = opt.get();
            post.setTitle((postDTO.getTitle()));
            post.setContent(postDTO.getContent());
            postRepository.save(post);
        }
        return;
    }
}
