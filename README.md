**Welcome to our microservice microservice, use it as a quickstarter for new ms**

---

## The code

Next, you’ll need to understand the main rules of the code

1. APIController implements DummyAPI interface.
2. The **client** package contains client for other web services.
3. Use **entities** to crud entities in database using JPA **repositories**
4. Use **mappers** to move data between layers. model to dto or dto to model or entity to dto.
5. We use database as code. You can use **liquibase** master for adding your own sql to be executed on deploy.
6. You must **test** all your methods in service layers, using mockbeans for clients and repositories you will find and example in DummyServiceTest.java.
7. You must cover all your methods in controller layers, using spring cloud contracts, you will find and example in getDummy.groovy
8. You must replace this README content with your own microservice readme.

---
