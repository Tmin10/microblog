CREATE KEYSPACE IF NOT EXISTS microblog
    WITH replication = {'class': 'NetworkTopologyStrategy', 'DC1' : '1'};

USE microblog;

CREATE TABLE IF NOT EXISTS blog_records (
	user_name text,
	created_at timeuuid,
	blog_text text,
	ip_address inet,
	useragent text,
	PRIMARY KEY (user_name, created_at)
) WITH CLUSTERING ORDER BY (created_at DESC);
