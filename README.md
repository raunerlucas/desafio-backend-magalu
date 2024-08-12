## Desafio Magalu - Serviço de Mensageria

**API REST em Spring Boot para agendamento de mensagens (email, SMS, push, WhatsApp).**

**Status:** Em Desenvolvimento 🚧

**Documentação da API (Swagger):** http://localhost:8080/swagger-ui/index.html

## Descrição

Este projeto é uma API REST desenvolvida em Java com Spring Boot que oferece funcionalidades para agendamento de envio de mensagens. O serviço suporta o agendamento de emails, SMS, notificações push e mensagens WhatsApp (funcionalidade de envio não implementada nesta etapa).

A API foi desenvolvida como solução para o desafio backend da Magalu, proposto no processo seletivo.

Este projeto utiliza o Springdoc OpenAPI para gerar documentação interativa da API, acessível através da interface do Swagger.

## Instalação e Execução

**Pré-requisitos:**

* Docker instalado e em execução.

**Passo 1: Clonar o Repositório**

```bash
git clone https://github.com/raunerlucas/desafio-backend-magalu.git
cd desafio-backend-magalu
```

**Passo 2: Subir a Aplicação com Docker Compose**

```bash
docker-compose up -d
```

Este comando irá:

* Baixar as imagens Docker necessárias (OpenJDK 22 e PostgreSQL).
* Criar e iniciar os contêineres para a aplicação Spring Boot e o banco de dados PostgreSQL.

**Passo 3: Acessar a Aplicação**

* **API:** Acesse a documentação da API (Swagger) em: http://localhost:8080/swagger-ui/index.html

A aplicação estará disponível em `http://localhost:8080/`. A interface do Swagger, configurada como página inicial, estará disponível em `http://localhost:8080/swagger-ui/index.html`.

## Tecnologias Utilizadas

* Java 22
* Spring Boot
* PostgreSQL
* Maven
* Spring Data JPA
* Springdoc OpenAPI
* Spring Scheduler
* Docker

## Contato

Rauner Lucas: [https://raunerlu.bio.link/](https://raunerlu.bio.link/)

## Agradecimentos

O desenvolvimento deste projeto teve como referência o vídeo "[Resolvendo DESAFIO BACKEND da Magalu com Spring Boot](https://www.youtube.com/watch?v=af4W9Q4vB1s)" do canal Build & Run.
