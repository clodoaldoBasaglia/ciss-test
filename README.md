# Cadastro de funcionários - Teste da CISS

Autor: Clodoaldo Basaglia da Fonseca

# Sobre o projeto
## Stack
Java Spring Boot, React e PostgreSQL. 
O projeto se encontra em um mono repo:
* ciss-test-backend: Backend feito em Java utilizando Spring Boot
* * O banco se encontra em uma pasta chamada docker
* ciss-test-frontend: Frontend feito em React
* postman-collection: Coleção que pode ser importada para o postman para consumir a API sem a necessidade de rodar o frontend

## Como iniciar o projeto

Utilizei a IDE Intellij IDEA para editar e rodar o projeto backend, já o front utilizei o Visual Studio Code.

* Navegue até a pasta docker dentro da pasta ciss-test-backend e execute:
```terminal
docker-compose -f .\postgresql.yml up -d
```

* Navegue até a raiz do backend(pasta ciss-test-backend) e execute: 
```terminal
./mvnw spring-boot:run
```
Isso vai rodar o projeto no caminho http://localhost:8080

* Navegue até a raiz do projeto frontend(pasta ciss-test-frontend) e execute:
```terminal
npm start
```
Isso inicializara o projeto na porta 3000 (http://localhost:300)

