package com.example.meowmaven.repositories;

import com.example.meowmaven.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

// Some default CRUD?
public interface SessionRepository extends JpaRepository<Session, Long> {

}
