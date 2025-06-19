###########################
# 🏗️ 1. Fase de build
###########################
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /workspace

# 1. Só o POM + wrapper → cache de dependências
COPY pom.xml mvnw* ./
COPY .mvn .mvn
RUN mvn -B -ntp dependency:go-offline

# 2. Código completo
COPY src src
RUN mvn -B -ntp -DskipTests=true package

###########################
# 🚀 2. Fase de runtime
###########################
FROM eclipse-temurin:17-jre


WORKDIR /app
# copia o único JAR gerado (wildcard cobre o snapshot)
COPY --from=builder /workspace/target/*.jar app.jar

# boas práticas de memória p/ Java 17 em container
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

EXPOSE 8080
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]
