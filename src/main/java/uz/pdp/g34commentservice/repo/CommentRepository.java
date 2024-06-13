package uz.pdp.g34commentservice.repo;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.g34commentservice.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(Long id);

    @Transactional
    void deleteAllByPostId(Long id);
}