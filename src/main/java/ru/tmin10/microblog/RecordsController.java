package ru.tmin10.microblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("record")
public class RecordsController {

    @Autowired
    RecordsService recordsService;

    @GetMapping("/list")
    public Flux<BlogRecord> getLatestRecords() {
        return recordsService.getLatestRecords();
    }

}
