# ========================
# 🏗️ Fase de build
# ========================
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /workspace

# Copia o POM e o Maven Wrapper (para cache de dependências)
COPY pom.xml mvnw* ./
COPY .mvn .mvn

RUN mvn -B -ntp dependency:go-offline

# Copia o código fonte
COPY src src

# Compila o projeto e empacota o JAR (sem testes)
RUN mvn -B -ntp -DskipTests=true package


# ========================
# 🚀 Fase de execução
# ========================
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copia o JAR gerado na build
COPY --from=builder /workspace/target/*.jar app.jar

# Configuração de memória otimizada para container
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

EXPOSE 8080

# Executa o JAR com as opções de memória
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
