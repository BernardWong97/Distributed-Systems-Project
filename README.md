# Distributed Systems Project 2019

A distributed user account management system that uses gRPC password 
service and RESTful User Account Service.

## Clone this repository
```bash
git clone https://github.com/BernardWong97/Distributed-Systems-Project.git
```
## Part 1: Password Service
### Instructions
#### Checkout to Part 1 commit
```bash
git checkout 4a877b385a35fda5ce993aa8a95d074e938a84e5
```
#### Clean Install and Run Server
```bash
mvn clean install
java -jar target/Distributed-Systems-Project-1.0-SNAPSHOT.jar
```
#### Run Client
Client class is just a testing class, need to compile and run the main method manually.

## Part 2: User Account Service
### Instructions
Be sure to checkout back to master by:
```bash
git checkout master
```
### Clean install and Run Server
```bash
mvn clean install
java -jar target/Distributed-Systems-Project-2.0-SNAPSHOT.jar server userApiConfig.yaml
```

### Health check
To check application health, enter http://localhost:8081/healthcheck in browser.

### REST API
The SwaggerHub URL of the OpenAPI definition for the REST API in this application:
https://app.swaggerhub.com/apis/BernardWong97/UserAPI/1

## Author

**Name:** Bernard Wong  
**ID:** G00341962  
**Email:** <G00341962@gmit.ie>  
**Repository:** <https://github.com/BernardWong97/Distributed-Systems-Project>
