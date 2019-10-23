CREATE KEYSPACE IF NOT EXISTS microblog
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

USE microblog;

CREATE TABLE IF NOT EXISTS blog_records (
	record_id uuid,
	user_name text,
	created_at timestamp,
	blog_text text,
	ip_address inet,
	useragent text,
	PRIMARY KEY (user_name, created_at)
) WITH CLUSTERING ORDER BY (created_at DESC);

//INSERT INTO blog_records 
//	(record_id, user_name, created_at, blog_text, ip_address, useragent) 
//VALUES (uuid(), 'test', toTimestamp(now()), 'test', '192.168.1.1', 'Mozilla');

//SELECT * FROM blog_records WHERE user_name = 'test';