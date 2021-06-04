package cn.tqyao.elastic.controller;

import cn.tqyao.elastic.entity.Person;
import cn.tqyao.elastic.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/people")
public class PersonController {

    PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Person> add(@RequestBody Person person){
        return personRepository.save(person);
    }

    @GetMapping("/{id}")
    public Mono<Person> getById(@PathVariable String id) {
        return personRepository.findById(id);
    }
    @GetMapping
    public Flux<Person> list(){
        return personRepository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable("id") String id) {
        return personRepository.deleteById(id);
    }



}