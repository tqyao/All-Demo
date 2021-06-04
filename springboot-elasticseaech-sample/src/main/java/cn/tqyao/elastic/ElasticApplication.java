package cn.tqyao.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

@SpringBootApplication

public class ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run (ElasticApplication.class, args);
    }

}
