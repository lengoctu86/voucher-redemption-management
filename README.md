# VOUCHER REDEMPTION MANAGEMENT

There are following libraries or framework, which has been used in the project:
- Spring Boot
- Spring JPA
- H2
- Liquibase
- Swagger
- JUnit
- Dockerfile


## Prerequisites
Make sure you have installed Java 8 and Maven 3 in your machine, it recommends using Java 8 to run the project
```$xslt
# To check java version, please run the command
java -version
# To check maven version, please run the command
mvn -version
```

## Installing & Starting

###### Packaging  
```$xslt
mvn clean package

```

###### How to start application
> Start in local after packaging
```
java -jar target/voucherRedemptionManagement-0.0.1-SNAPSHOT.jar
```

> Start by docker
```
docker build -t voucher:latest .
docker run -d -p 8080:8080 voucher:latest
```

> Start in local by mvn
```
mvn spring-boot:run
```

## Local testing:
View all vouchers: http://localhost:8080/vouchers

API documentation UI: http://localhost:8080/swagger-ui

H2 database console UI: http://localhost:8080/h2-console

H2 database console Log-In info:
    
    Driver Class: org.h2.Driver
    JDBC URL: jdbc:h2:mem:voucher-db
    User Name: admin
    Password: admin

## Recommendation:
Some suggestions below might be good points to improve the value of this project

> Business:
```
- Implementation for Voucher's Consumer
- Implementation for Redemption transaction log
```
> Technical:
```
- API authentication/authorization
- Component testing using Testcontainers
- Rest API tesing
- JUnit service test does should reach over 80% coverage
- Using proper RDMS Database like MySQL, Postgres...
- Handle concurrent database update by using Pessimistic or Optimistic Locking
```
