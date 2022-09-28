package com.example.Web_BD.repo;

import com.example.Web_BD.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
