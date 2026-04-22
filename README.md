# 📧 Microsserviço de Email com RabbitMQ

[![Java](https://img.shields.io/badge/Java-25-orange?style=flat-square&logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.5-green?style=flat-square&logo=springboot)](https://spring.io/projects/spring-boot)
[![RabbitMQ](https://img.shields.io/badge/RabbitMQ-AMQP-FF6600?style=flat-square&logo=rabbitmq)](https://www.rabbitmq.com/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15+-blue?style=flat-square&logo=postgresql)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)](LICENSE)

> Microsserviço desenvolvido em **Spring Boot** para consumo assíncrono de eventos de usuário via **RabbitMQ** e envio de e-mails transacionais com persistência de logs em **PostgreSQL**.

🔗 **Integração**: Este serviço consome eventos publicados pelo [Microsserviço de Usuário](https://github.com/Arthur-Luiz19/Microsservicos-usuario-com-RabbitMQ) para envio automático de e-mails de boas-vindas e notificações.

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Arquitetura e Fluxo](#-arquitetura-e-fluxo)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Pré-requisitos](#-pré-requisitos)
---

## 🎯 Sobre o Projeto

Este microsserviço é responsável pelo **envio assíncrono de e-mails** em uma arquitetura baseada em eventos. Ele atua como **consumer** no padrão pub/sub, escutando uma fila do RabbitMQ para processar solicitações de envio de e-mail provenientes de outros serviços — principalmente o [Serviço de Usuário](https://github.com/Arthur-Luiz19/Microsservicos-usuario-com-RabbitMQ).

### Por que assíncrono?

- ⚡ **Baixa latência**: O serviço produtor não espera o envio do e-mail para responder ao cliente
- 🔄 **Resiliência**: Falhas no SMTP não impactam o fluxo principal de cadastro de usuários
- 📈 **Escalabilidade**: Múltiplas instâncias podem consumir da mesma fila simultaneamente
- 🧩 **Desacoplamento**: O serviço de usuário não precisa conhecer detalhes de envio de e-mail

---

## ✨ Funcionalidades

- ✅ Consumo assíncrono de mensagens via RabbitMQ (`@RabbitListener`)
- ✅ Envio de e-mails simples e HTML com Spring Mail
- ✅ Persistência de histórico de envios no PostgreSQL com status (`PROCESSING`, `SENT`, `ERROR`)
- ✅ Validação de e-mails de destino com Bean Validation
- ✅ Tratamento de erros com retry automático e Dead Letter Queue (DLQ)
- ✅ Suporte a templates dinâmicos via Thymeleaf (opcional)
- ✅ Logs estruturados para auditoria e monitoramento

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia        | Versão | Finalidade                              |
|------------------|--------|----------------------------------------|
| Java             | 25     | Linguagem base                         |
| Spring Boot      | 4.0.5  | Framework principal                    |
| Spring AMQP      | 4.0.x  | Integração com RabbitMQ                |
| Spring Mail      | 4.0.x  | Envio de e-mails (JavaMail)            |
| Spring Data JPA  | 4.0.x  | Persistência PostgreSQL                |
| Spring Validation| 4.0.x  | Validação de DTOs                      |
| Spring WebMVC    | 4.0.x  | Suporte a controllers (health/check)   |
| PostgreSQL       | 15+    | Banco de dados para logs               |
| RabbitMQ         | 3.12+  | Broker de mensagens                    |
| Lombok           | 1.18.x | Redução de boilerplate (@Data, @Builder) |
| Maven            | 3.9+   | Build e dependências                   |

---

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- [JDK 25](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [Docker & Docker Compose](https://docs.docker.com/get-docker/)
- [RabbitMQ](https://www.rabbitmq.com/download.html) (ou via Docker)
- [PostgreSQL 15+](https://www.postgresql.org/download/) (ou via Docker)

---

