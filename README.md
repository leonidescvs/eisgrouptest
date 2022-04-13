Eisgroup project: in this project we have two microservices: the first one is eisgroup-test-api respnsible to receive rest REQUESTand sent the  message in the Kafka topic and waiting the response code to REPLY.
the another one is the eisgroup-test-service responsible to listen the Kafka topic and after do persistence in Cassandra DB..
In this project we are not using rxJava and Cammel frameworks. 

eisgrouptest-api: microservice responsible to process REST request
eisgroup-test-save: microservice responsible to save in Cassandra DB

to run the Kafka, please execute this command in DOS pronpt:

1) docker-compose docker-kafka.yml

to create the Cassandra DB:
2) docker-componse -f docker-cassandra.yml
