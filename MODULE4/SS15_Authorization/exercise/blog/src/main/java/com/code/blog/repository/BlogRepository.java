package com.code.blog.repository;


import com.code.blog.model.Blog;
import com.code.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface BlogRepository extends JpaRepository<Blog,Long> {
    Iterable<Blog> findAllByCategory(Category category);
}
