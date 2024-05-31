package io.github.gneiva.fullstack.challenge.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.gneiva.fullstack.challenge.api.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String login);
}
