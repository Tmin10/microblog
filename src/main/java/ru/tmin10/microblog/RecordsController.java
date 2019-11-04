package ru.tmin10.microblog;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("record")
public class RecordsController {

    @Autowired
    RecordsService recordsService;

    @PostConstruct
    public void saveRecords() throws UnknownHostException {
        List<BlogRecord> records = new ArrayList<>();
        records.add(new BlogRecord(new BlogRecordKey("test", UUIDs.timeBased()), "test", InetAddress.getByName("localhost"), "Nozilla"));
        recordsService.init(records);
    }

    @GetMapping("/list")
    public Flux<BlogRecord> getAllRecords() {
        Flux<BlogRecord> records = recordsService.getAllRecords();
        return records;
    }

}
