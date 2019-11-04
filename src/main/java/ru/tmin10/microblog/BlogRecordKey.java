package ru.tmin10.microblog;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.UUID;

@PrimaryKeyClass
public class BlogRecordKey {
    @PrimaryKeyColumn(name = "user_name", type = PrimaryKeyType.PARTITIONED)
    private String userName;
    @PrimaryKeyColumn(name = "created_at", ordering = Ordering.DESCENDING)
    private UUID createdAt;

    public BlogRecordKey(String userName, UUID createdAt) {
        this.userName = userName;
        this.createdAt = createdAt;
    }

    public String getUserName() {
        return userName;
    }

    public UUID getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "BlogRecordKey{" +
                "userName='" + userName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
