package com.coderman.simpleblogmanagement.repo;

import com.coderman.simpleblogmanagement.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends ElasticsearchRepository<User, String> {
    User findByUsername(String username);
}
