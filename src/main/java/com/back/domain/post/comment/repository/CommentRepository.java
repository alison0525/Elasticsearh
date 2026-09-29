package com.back.domain.post.comment.repository;

import com.back.domain.post.comment.document.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CommentRepository extends ElasticsearchRepository<Comment, String> {
    List<Comment> findAll();

    List<Comment> findByPostId(String postId);

    Page<Comment> findByPostId(String postId, Pageable pageable);

    Page<Comment> findByPostIdAndContentContaining(String postId, String keyword, Pageable pageable);

    Page<Comment> findByPostIdAndAuthorContaining(String postId, String keyword, Pageable pageable);

    Page<Comment> findByPostIdAndContentContainingOrPostIdAndAuthorContaining(
            String postId1, String contentKeyword,
            String postId2, String authorKeyword,
            Pageable pageable
    );
}
