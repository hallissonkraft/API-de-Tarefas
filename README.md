# 🧩 API de Gerenciamento de Tarefas – Desenvolvimento Web Back-End

## 👨‍💻 Autor
**Nome:** Hallisson Krawczyk  
**RU:** 4684962  
**Disciplina:** Desenvolvimento Web Back-End

---

## 📘 Descrição do Projeto
Este projeto consiste na implementação de uma **API RESTful** para o **gerenciamento de tarefas**, desenvolvida em **Java com Spring Boot**.  
A API permite o **cadastro, consulta, atualização e exclusão** de tarefas, armazenando informações como:

- Nome da tarefa  
- Data de entrega  
- Responsável pela tarefa  

A aplicação utiliza um **banco de dados H2 em memória** e segue as boas práticas de desenvolvimento REST.

---

## ⚙️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Web**
- **Spring Data JPA**
- **Banco de Dados H2 (em memória)**
- **Postman** (para testes e documentação)

---

## 🏗️ Estrutura do Projeto
tarefas_api/
├── src/
│ ├── main/
│ │ ├── java/tarefas_api/
│ │ │ ├── controller/TarefaController.java
│ │ │ ├── model/Tarefa.java
│ │ │ ├── repository/TarefaRepository.java
│ │ │ └── TarefasApiApplication.java
│ │ └── resources/
│ │ ├── application.properties
│ │ └── static/
│ └── test/ (testes unitários opcionais)
└── pom.xml


---

## ⚙️ Configuração do Banco de Dados (H2)

Arquivo `application.properties`:

```properties
# Porta do servidor
server.port=8080

# Banco H2 em memória
spring.datasource.url=jdbc:h2:mem:tarefasdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Console H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2


Acesse o console H2 em:
👉 http://localhost:8080/h2


