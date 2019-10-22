# Microblog prototype

Prototype of naive microblogging platform like Twitter. 

Main technologies:
* **Cassandra** - store microblogs records;
* **Spring** Boot -  provide backend REST API for frontend;
* **ElasticSearch** - provide fulltext search over microblogs records;
* **Elassandra** - connect Cassandra and ElasticSearch;
* **Vagrant** - set up VM with docker
* **Ansible** - run necessary docker containers on VM.
