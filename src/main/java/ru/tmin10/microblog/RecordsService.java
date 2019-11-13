package ru.tmin10.microblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class RecordsService {

    @Autowired
    BlogRecordsRepository blogRecordsRepository;

    public Flux<BlogRecord> getLatestRecords() {
        return blogRecordsRepository.findAll().take(10);
    }

}
