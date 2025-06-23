# 🐾 EMBALANDO – Loja Pet & Dropshipping API

Plataforma Java 21 com Spring Boot 3.3.0 usando arquitetura hexagonal, voltada para automação e gestão de vendas.

---

## ✨ Visão geral

* **Hexagonal (Ports & Adapters)**: core isolado; troca facilmente banco ou API sem tocar na regra de negócio.  
* **Stack moderna:** Java 21, Spring Boot 3, MapStruct, Lombok, JUnit 5, Testcontainers.  
* **Dropshipping ready:** porta dedicada para integrar catálogo de fornecedor e sincronizar estoque.  
* **CI/CD GitHub Actions:** build, teste, análise e imagem Docker em cada PR.  
* **Observabilidade embutida:** Actuator + OpenTelemetry (traços e métricas Prometheus).

---

## 🚀 Como iniciar (modo DEV)

1. **Requisitos:**
   - Docker + Docker Compose
   - Java 21
   - Maven 3.9.6 ou superior

2. **Execute:**

```bash
docker-compose up --build
```

A aplicação subirá em:  
📦 `http://localhost:8080`  
🔍 Actuator/Health: `http://localhost:8081/actuator/health`

---

## 🧪 Executar TESTES

Por padrão, o perfil `test` usa banco em memória (H2) com `create-drop`.

```bash
./mvnw test -Dspring.profiles.active=test
```

Ou edite `application-test.properties` para usar MySQL local em vez de H2.

---

## 🏠 Modo Produção (exemplo)

Configure variáveis de ambiente:

```env
SPRING_PROFILES_ACTIVE=prod
DB_USERNAME=embalando
DB_PASSWORD=embalando_pwd
JWT_SECRET=segredo_supersecreto
SMTP_USER=mail@exemplo.com
SMTP_PASS=senha_do_email
```

Então execute com Docker ou JAR:

```bash
java -jar target/embalando-net-br-0.0.1-SNAPSHOT.jar
```

---

## 🗂️ Estrutura de pastas

```text
src/main/java/br/com/embalando
 ├── application
 │   └── core
 │       ├── domain/          ← Entidades + Value Objects
 │       ├── service/         ← Caso de uso (implementação)
 │       └── port/
 │           ├── in/          ← Use-case interfaces
 │           └── out/         ← Repositórios / APIs externas
 └── adapter
     ├── inbound/rest/        ← Controllers REST
     └── outbound/
         ├── persistence/     ← JPA entities & repos
         └── fornecedor/      ← Cliente REST do dropshipper
resources/
 ├── static/                  ← CSS / JS
 └── templates/               ← Páginas server-side (Thymeleaf)
```

---

## 📆 Perfis disponíveis

| Perfil | Descrição                            | Porta | Banco     |
|--------|--------------------------------------|-------|-----------|
| dev    | Desenvolvimento local (default)      | 8080  | MySQL 8   |
| test   | Testes com JUnit ou Testcontainers   | 8081  | H2 / MySQL|
| prod   | Produção real com segurança e cache  | 8080  | MySQL / RDS|

---

## 🛠 Tecnologias usadas

- Java 21
- Spring Boot 3.3
- MySQL 8 / H2
- Spring Data JPA
- Docker & Docker Compose
- MapStruct & Lombok
- Actuator & Prometheus
