package com.marcelib.community.data.repositories;

import com.marcelib.community.data.UserPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPostRepository extends CrudRepository<UserPost, Long> {

    @Override
    UserPost save(UserPost userPost);

    List<UserPost> findByAuthorId(Long id);

    List<UserPost> findFirst10ByDateAddedOrderByDateAddedAsc(Long id);
}
