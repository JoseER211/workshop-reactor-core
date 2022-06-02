package com.example.demo.controller;

import com.example.demo.collections.Person;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Mono<Void> post(@RequestBody Mono<Person> personMono) {
        return personService.insert(personMono);
    }

    @GetMapping("/{id}")
    public Mono<Person> getPerson(@PathVariable("id") String id) {
        return personService.findPersonById(id);
    }

    @PutMapping
    public Mono<Void> update(@RequestBody Mono<Person> personMono) {
        return personService.update(personMono);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return personService.delete(id);
    }

    @GetMapping
    public Flux<Person> list() {
        return personService.listAll();
    }


}
