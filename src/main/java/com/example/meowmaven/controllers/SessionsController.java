package com.example.meowmaven.controllers;

import com.example.meowmaven.models.Session;
import com.example.meowmaven.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions") // url
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    // Get all sessions
    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    // Get a session by id
    @GetMapping
    @RequestMapping("{id}") // parameter for get
    public Session get(@PathVariable Long id) {
        return sessionRepository.getById(id);
    }

    // Insert a speaker-session JSON, save is pending, flush is commit
    // @ResponseStatus(HttpStatus.CREATED) // A response you get for a proper CRUD operation, can be a generic 200 error
    @PostMapping
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    // Delete by id
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // also delete cascade issues need to be dealt with, do it at the stored proc
        sessionRepository.deleteById(id);
    }

    // PUT requires all attributes, PATCH would only need what's necessary
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        // Validate here if you want
        Session existingSession = sessionRepository.getById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id"); // ignore PK, no replacing
        return sessionRepository.saveAndFlush(existingSession);
    }
}
