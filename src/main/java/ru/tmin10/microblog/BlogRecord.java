package ru.tmin10.microblog;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.net.InetAddress;

@Table("blog_records")
public class BlogRecord {
    @PrimaryKey
    private BlogRecordKey blogRecordKey;
    @Column("blog_text")
    private String blogText;
    @Column("ip_address")
    private InetAddress ipAddress;
    private String useragent;

    public BlogRecord(BlogRecordKey blogRecordKey, String blogText, InetAddress ipAddress, String useragent) {
        this.blogRecordKey = blogRecordKey;
        this.blogText = blogText;
        this.ipAddress = ipAddress;
        this.useragent = useragent;
    }

    public BlogRecordKey getBlogRecordKey() {
        return blogRecordKey;
    }


    public String getBlogText() {
        return blogText;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public String getUseragent() {
        return useragent;
    }

    @Override
    public String toString() {
        return "BlogRecord{" +
                "blogRecordKey=" + blogRecordKey +
                ", blogText='" + blogText + '\'' +
                ", ipAddress=" + ipAddress +
                ", useragent='" + useragent + '\'' +
                '}';
    }
}
