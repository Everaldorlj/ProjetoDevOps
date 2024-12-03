# Use a imagem base do JDK para construir o projeto
FROM maven:3.8.8-eclipse-temurin-17 AS build

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o arquivo pom.xml e as dependências do projeto para o container
COPY pom.xml .
COPY src ./src

# Baixe as dependências e construa o aplicativo
RUN mvn clean package -DskipTests

# Use uma imagem mais leve para rodar o aplicativo
FROM eclipse-temurin:17-jre

# Define o diretório de trabalho para o runtime
WORKDIR /app

# Copie o arquivo JAR gerado para o container
COPY --from=build /app/target/ProjetoDevOps-*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
