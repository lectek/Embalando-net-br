<p align="center">
  <img src="https://raw.githubusercontent.com/lectek/EMBALANDO-NET-BR/main/.github/banner.png" width="640" alt="Logo EMBALANDO-NET-BR">
</p>

<h1 align="center">EMBALANDO-NET-BR</h1>
<p align="center">
  <b>Java 21 • Spring Boot 3 • Arquitetura Hexagonal</b><br>
  Plataforma de dropshipping leve, testável e pronta para escalar.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/java-21-blue?logo=java">
  <img src="https://img.shields.io/badge/spring_boot-3.3-green?logo=spring">
  <img src="https://img.shields.io/github/actions/workflow/status/lectek/EMBALANDO-NET-BR/ci.yml?branch=main&label=CI">
  <img src="https://img.shields.io/badge/status-pre--alpha-orange">
  <img src="https://img.shields.io/badge/license-MIT-lightgrey">
</p>

---

## ✨ Visão geral

* **Hexagonal (Ports & Adapters)**: core isolado; troca facilmente banco ou API sem tocar na regra de negócio.  
* **Stack moderna:** Java 21, Spring Boot 3, MapStruct, Lombok, JUnit 5, Testcontainers.  
* **Dropshipping ready:** porta dedicada para integrar catálogo de fornecedor e sincronizar estoque.  
* **CI/CD GitHub Actions:** build, teste, análise e imagem Docker em cada PR.  
* **Observabilidade embutida:** Actuator + OpenTelemetry (traços e métricas Prometheus).

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
     ├── inbound/web/         ← Controllers REST
     └── outbound/
         ├── persistence/     ← JPA entities & repos
         └── fornecedor/      ← Cliente REST do dropshipper
resources/
 ├── static/                  ← CSS / JS
 └── templates/               ← Páginas server-side (Thymeleaf)
