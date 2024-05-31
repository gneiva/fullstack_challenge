# Use a imagem oficial do Maven para construir a aplicação Spring Boot
FROM maven:3.8.1-openjdk-17 AS build

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo pom.xml e as dependências
COPY pom.xml .

# Baixe as dependências
RUN mvn dependency:go-offline -B

# Copie o restante do código
COPY src ./src

# Construa o jar da aplicação
RUN mvn clean package -DskipTests

# Use a imagem oficial do OpenJDK para rodar a aplicação
FROM openjdk:17-jdk-slim

# Copie o jar construído para o container
COPY --from=build /app/target/fullstack-challenge-api-0.0.1-SNAPSHOT.jar /app/fullstack-challenge-api-0.0.1-SNAPSHOT.jar

# Exponha a porta 8080
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "/app/fullstack-challenge-api-0.0.1-SNAPSHOT.jar"]
