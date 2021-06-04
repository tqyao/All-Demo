package cn.tqyao.elastic.repository;

import cn.tqyao.elastic.entity.Person;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

public interface PersonRepository extends ReactiveElasticsearchRepository<Person, String> {
}