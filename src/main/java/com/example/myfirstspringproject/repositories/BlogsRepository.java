
package com.example.myfirstspringproject.repositories;


import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogsRepository extends JpaRepository<Blog, Long> {

    @Query(value = "SELECT * FROM article where blog_id = id", nativeQuery = true)
    List<Article> findArticlesByBlogId(long id);

    @Query(value = "SELECT * FROM blogs where user_id = id" , nativeQuery = true)
    List<Blog> findBlogsByIdUser(long id);
}

