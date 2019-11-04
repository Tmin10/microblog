CREATE KEYSPACE IF NOT EXISTS microblog
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

USE microblog;

CREATE TABLE IF NOT EXISTS blog_records (
	user_name text,
	created_at timeuuid,
	blog_text text,
	ip_address inet,
	useragent text,
	PRIMARY KEY (user_name, created_at)
) WITH CLUSTERING ORDER BY (created_at DESC);

//INSERT INTO blog_records 
//	(user_name, created_at, blog_text, ip_address, useragent) 
//VALUES ('test', now(), 'test1', '192.168.1.1', 'Mozilla1');



//SELECT user_name, created_at, blog_text, ip_address, useragent, toTimestamp(created_at) FROM blog_records WHERE user_name = 'test' and created_at = 762b3510-ff15-11e9-a5a4-6d2c86545d91;

//SELECT user_name FROM blog_records; 
