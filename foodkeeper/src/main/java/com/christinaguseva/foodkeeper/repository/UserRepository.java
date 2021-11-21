package com.christinaguseva.foodkeeper.repository;

import com.christinaguseva.foodkeeper.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
