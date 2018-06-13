# Currency Exchange Project
This is a proof-of-concept project of a [Microservice Architecture Pattern](http://martinfowler.com/microservices/) using SpringBoot and SpringCloud (Docker in next releases)

## Business Services

This project was decomposed in two core microservices. The services are independent applications, with standalone deploys and respectives databases. They are organized around two business domains:

#### Forex Service
Responsible to evaluate the diferrent currency rates between currencies

#### Exchange Service
Responsible to convert and exchange some quantity of a currency to another

<img width="880" alt="Functional services" src="https://raw.githubusercontent.com/BruhMeh/microservices-springboot/master/Business%20Services.png">

#### Cloud Architecture
There's a lot of patterns for cloud archtecture using distributed systems. Spring Cloud provides some of the tools necessary for these patterns. In the diagram bellow I described how the architecture will be implemented and waht tool I'll use for this project

<img width="880" alt="Functional services" src="https://raw.githubusercontent.com/BruhMeh/microservices-springboot/master/Infrastructure%20Services.png">




