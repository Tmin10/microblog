package ru.tmin10.microblog;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface BlogRecordsRepository extends ReactiveCassandraRepository<BlogRecord, BlogRecordKey> {

}
