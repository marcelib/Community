package com.marcelib.community.data.repositories;


import com.marcelib.community.data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    User findOne(Long id);

    @Override
    User save(User s);
}