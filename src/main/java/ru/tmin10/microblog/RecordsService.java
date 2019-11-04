package ru.tmin10.microblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class RecordsService {

    @Autowired
    BlogRecordsRepository blogRecordsRepository;

    public void init(List<BlogRecord> records) {
        Flux<BlogRecord> savedRecords = blogRecordsRepository.saveAll(records);
        savedRecords.subscribe();
    }

    public Flux<BlogRecord> getAllRecords() {
        return blogRecordsRepository.findAll();
    }

}
