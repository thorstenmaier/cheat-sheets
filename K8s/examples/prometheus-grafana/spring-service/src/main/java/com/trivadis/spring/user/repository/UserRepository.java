package com.trivadis.spring.user.repository;

import com.trivadis.spring.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
