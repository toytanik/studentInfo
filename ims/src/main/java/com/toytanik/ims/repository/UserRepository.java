package com.toytanik.ims.repository;

import com.toytanik.ims.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findAllById(Long id);
}
