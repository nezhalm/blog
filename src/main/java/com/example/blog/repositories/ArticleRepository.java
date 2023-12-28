package com.example.blog.repositories;
import com.example.blog.models.decuments.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, String> {
    List<Article> findByTagsContainingOrTextContainingOrTitleContaining(String tag, String text, String title);

}
