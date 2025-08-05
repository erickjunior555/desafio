# Consulta de CEP - API RESTful

Este projeto é uma API REST desenvolvida em **Java 17** com **Spring Boot** para realizar consultas de CEPs, utilizando o **WireMock** como simulação de serviço externo e **PostgreSQL** como banco de dados para registrar o histórico de consultas.

---

## 🛠 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- WireMock
- Docker e Docker Compose
- JUnit 5 + Mockito
- DBeaver (opcional, para visualização do banco)

---
### Pré-requisitos

- Docker e Docker Compose instalados
- Java 17+ instalado (caso queira rodar o Spring localmente)

### 1. Subir os serviços (PostgreSQL e Wiremock)

- No terminal :
- docker-compose up -d
- Rodar a aplicação Spring Boot
  Via sua IDE (IntelliJ, VSCode, etc) ou com ./mvnw spring-boot:run


### 2. 📨 Endpoints
GET /cep/{cep}
Consulta o CEP informado e retorna os dados simulados via Wiremock.

- GET http://localhost:8080/cep/01001000

- 🗺️ Desenho de solução técnica

![img.png](img.png)