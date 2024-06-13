package uz.pdp.g34commentservice.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.g34commentservice.entity.Comment;
import uz.pdp.g34commentservice.repo.CommentRepository;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getComment(@PathVariable Long postId) {
        return ResponseEntity.ok(commentRepository.findAllByPostId(postId));
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<Void> deleteComments(@PathVariable Long postId) {
        commentRepository.deleteAllByPostId(postId);
        return ResponseEntity.noContent().build();
    }
}
