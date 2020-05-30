package com.example.myfirstspringproject.repositories;

import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.State;
import com.example.myfirstspringproject.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UsersRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    Optional<User> findByConfirmCode(String confirmCode);
    Optional<User> findUserByEmail(String email);
    List<User> findAllByUsernameContainsIgnoreCase(String username);

    @Query("from User user where " +
            "upper(user.username) like concat('%', upper(:query), '%')")
    Page<User> search(@Param("query") String query, Pageable pageable);


}

