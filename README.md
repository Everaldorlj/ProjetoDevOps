**Projeto DevOps - Aplicação Spring Boot
Descrição do Projeto**

Esta é uma aplicação Spring Boot que gerencia categorias e serviços. O projeto foi desenvolvido com foco em boas práticas de DevOps, incluindo a utilização de containers Docker para facilitar a implantação.

**Tecnologias Utilizadas**
Java 17
Spring Boot
Spring Data JPA
Spring Web
Spring Validation
Maven
Docker
Banco de Dados: H2 (em memória) ou outro banco relacional de sua escolha

**Estrutura do Projeto**
Categoria: Entidade que representa uma categoria de serviço.
Serviço: Entidade que representa um serviço associado a uma categoria.
Endpoints REST:
/categorias (CRUD de Categorias)
/servicos (CRUD de Serviços)
Como Executar a Aplicação Localmente
Pré-requisitos
Java 17 ou superior
Maven
Docker (opcional para rodar com container)
Passos


**Clone o repositório:**

cd projeto-devops
Compile e empacote o projeto:

mvn clean package
Execute o JAR gerado:

java -jar target/ProjetoDevOps-0.0.1-SNAPSHOT.jar
A aplicação estará disponível em http://localhost:8080.

**Utilizando Docker**
Build da imagem Docker:

docker build -t projeto-devops:latest .
Run do container:

docker run -p 8080:8080 projeto-devops:latest


_**Endpoints**_
Categoria
GET /categorias: Retorna todas as categorias.
GET /categorias/{id}: Retorna uma categoria pelo ID.
POST /categorias: Cria uma nova categoria.
PUT /categorias/{id}: Atualiza uma categoria existente.
DELETE /categorias/{id}: Remove uma categoria.
Serviço
GET /servicos: Retorna todos os serviços.
GET /servicos/{id}: Retorna um serviço pelo ID.
POST /servicos: Cria um novo serviço.
PUT /servicos/{id}: Atualiza um serviço existente.
DELETE /servicos/{id}: Remove um serviço.
Configuração do Banco de Dados
A aplicação está configurada para usar o banco H2 em memória por padrão. Você pode acessar o console do H2 em http://localhost:8080/h2-console.

Configuração Padrão (H2)
No arquivo application.properties:

spring.datasource.url=jdbc:h2:mem:devopsdb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update

**Testes**
Para executar os testes:
mvn test
