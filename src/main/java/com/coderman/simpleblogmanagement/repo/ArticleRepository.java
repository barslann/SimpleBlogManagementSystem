package com.coderman.simpleblogmanagement.repo;

import com.coderman.simpleblogmanagement.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;


public interface ArticleRepository extends ElasticsearchRepository<Article,String> {
    Optional<Article> findByLink(String link);
    Page<Article> findByTitleContainingAndBodyContaining(String title, String body, Pageable pageable);
}

/*
    Just writing an interface that extends from the ElasticSearchRepository interface would be sufficient to expose methods to find one,
    find all, save, delete and so on.


    Optional<Article> findByLink(String link);
        -Since there are use cases in the application to show Article with a link to that Article,
        the findbyLink method is introduced in the preceding repository, this will return Optional,
       which may or may not have a value inside.


       Page<Article> findByTitleContainingAndBodyContaining(String title, String body, Pageable pageable);
            -Furthermore, to enable the search use case for all the available articles, findByTitleContainingAndBodyContaining method is introduced,
            which will return a page object that will have content, number of total elements, number of total pages, so on.
            So, that full-text search can be done on the title and body properties of Article
 */