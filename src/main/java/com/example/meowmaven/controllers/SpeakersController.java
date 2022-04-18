package com.example.meowmaven.controllers;

import com.example.meowmaven.models.Speaker;
import com.example.meowmaven.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Micro server API based on JSON
@RestController
@RequestMapping("api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerRepository speakerRepository;

    // GET http:/localhost:8080/api/v1/speakers
    @GetMapping
    public List<Speaker> list() { return speakerRepository.findAll(); }

    // GET http:/localhost:8080/api/v1/speakers/2
    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) { return speakerRepository.getById(id); }

    // POST http:/localhost:8080/api/v1/speakers/ with a body JSON of the new
    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker) {
         return speakerRepository.saveAndFlush(speaker);
    }

    // DELETE http:/localhost:8080/api/v1/speakers/3
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        speakerRepository.deleteById(id);
    }

    // PUT http:/localhost:8080/api/v1/speakers/94 with a body JSON of the new speaker
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        Speaker existingSpeaker = speakerRepository.getById(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
