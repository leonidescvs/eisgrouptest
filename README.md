EISGROUP PROJECT: in this project we have 02 microservices: the first one is eisgroup-test-api responsible to receive REST Request and send the message in the KAFKA topic (requesttopic2 - need bo create in the kafka) and waiting the response (topic replytopic2 - need to be created) code to REPLY.

The another one is the eisgroup-test-service, responsible to listen the Kafka topic and after do persist in Cassandra DB.

"In this project I´m not using either rxJava and Cammel frameworks"

To create the environment, you need to execute:
For KAFKA
docker-compose -f docker-kafka.yml up --> to crate the KAFKA service;
after, by Conduktor application on command line create the topics: requesttopic2 and replytopic2.
For CASSANDRA
docker-compose -f docker-cassandra.yml up --> to crate the Cassandra DB
After to up the Cassandra , execute the commands:
docker exec -it #ID /bin/bash
cqlsh -u cassandra -p cassandra
CREATE KEYSPACE IF NOT EXISTS message_keyspace WITH REPLICATION = {'class':'NetworkTopologyStrategy','datacenter1':3};

use customer_keyspace;
CREATE TABLE Message (id UUID PRIMARY KEY, message text);



eisgrouptest-api: microservice responsible to process REST request
eisgroup-test-save: microservice responsible to save in Cassandra DB

