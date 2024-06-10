# Etapa de build
FROM openjdk:21-slim AS build

# Instala Maven
RUN apt-get update && apt-get install -y maven

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml e baixa as dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o restante do código fonte
COPY src ./src

# Compila o projeto
RUN mvn clean install

# Etapa final
FROM alpine:edge

# Instala OpenJDK 21
RUN apk add --no-cache openjdk21-jdk

# Define a variável de ambiente para o JDK
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk
ENV PATH="$JAVA_HOME/bin:${PATH}"

# Exposição da porta
EXPOSE 8081

# Copia o jar construído para a imagem final
COPY --from=build /app/target/*.jar app.jar

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
