# Sentinel AI - Monitoramento Inteligente de Queimadas e Desmatamento

A ideia é usar tecnologia para apoiar a preservação ambiental, fornecendo dados em tempo real que podem ajudar governos, ONGs e pesquisadores a tomarem decisões rápidas e eficientes.

## Sobre o Projeto

O Sentinel AI é uma API REST desenvolvida em Java, com arquitetura em camadas para garantir organização e escalabilidade do código. Dividi o sistema nas seguintes partes principais:

- Controller – onde ficam as requisições REST.
- Service – contém a lógica de negócio.
- Repository – responsável pela persistência e acesso aos dados (usando Spring Data JPA).
- Model – onde defini as classes que representam as tabelas do banco.
- DTOs - para controlar o tráfego de dados de forma segura e enxuta.

A ideia foi criar uma estrutura limpa e modular, que facilite futuras expansões e integrações.

## Tecnologias Usadas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- Maven  
- Lombok  
- Swagger (OpenAPI)  
- Banco de dados Oracle

## Endpoints da API

### Satélites (`/satelite`)

| Método | Endpoint          | Descrição                      |
|--------|-------------------|-------------------------------|
| GET    | /satelite         | Lista todos os satélites      |
| GET    | /satelite/{id}    | Busca satélite por ID         |
| POST   | /satelite         | Cria um novo satélite         |
| PUT    | /satelite/{id}    | Atualiza um satélite existente|
| DELETE | /satelite/{id}    | Remove um satélite            |

### Imagens de Satélite (`/imagemsatelite`)

| Método | Endpoint               | Descrição                             |
|--------|------------------------|----------------------------------------|
| GET    | /imagemsatelite        | Lista todas as imagens de satélite     |
| GET    | /imagemsatelite/{id}   | Busca imagem por ID                    |
| POST   | /imagemsatelite        | Cria uma nova imagem de satélite       |
| PUT    | /imagemsatelite/{id}   | Atualiza uma imagem de satélite        |
| DELETE | /imagemsatelite/{id}   | Remove uma imagem de satélite          |

### Alertas de Queimada (`/alertaqueimada`)

| Método | Endpoint               | Descrição                              |
|--------|------------------------|-----------------------------------------|
| GET    | /alertaqueimada        | Lista todos os alertas de queimada      |
| GET    | /alertaqueimada/{id}   | Busca alerta por ID                     |
| POST   | /alertaqueimada        | Cria um novo alerta de queimada         |
| PUT    | /alertaqueimada/{id}   | Atualiza um alerta de queimada          |
| DELETE | /alertaqueimada/{id}   | Remove um alerta de queimada            |

### Áreas Protegidas (`/areaprotegida`)

| Método | Endpoint               | Descrição                              |
|--------|------------------------|-----------------------------------------|
| GET    | /areaprotegida         | Lista todas as áreas protegidas         |
| GET    | /areaprotegida/{id}    | Busca área protegida por ID             |
| POST   | /areaprotegida         | Cria uma nova área protegida            |
| PUT    | /areaprotegida/{id}    | Atualiza uma área protegida             |
| DELETE | /areaprotegida/{id}    | Remove uma área protegida               |

### Clima Local (`/climalocal`)

| Método | Endpoint             | Descrição                           |
|--------|----------------------|-------------------------------------|
| GET    | /climalocal          | Lista todos os registros de clima   |
| GET    | /climalocal/{id}     | Busca clima local por ID            |
| POST   | /climalocal          | Cria um novo registro de clima      |
| PUT    | /climalocal/{id}     | Atualiza um clima local             |
| DELETE | /climalocal/{id}     | Remove um clima local               |

## Organização em Camadas

Pra manter o código limpo e fácil de manter, usei a separação por camadas clássica:

src
│
├── controller
├── service
├── repository
├── exception
├── model
└── dto


Essa estrutura facilita muito a manutenção e testes. Além disso, permite escalar o projeto sem se perder no meio do código.


## Melhorias Futuras

- Implementar autenticação e autorização com Spring Security  
- Criar testes unitários e de integração com JUnit e Mockito  
- Implementar previsão de queimadas com IA/ML  
- Criar um painel visual com dashboard em React ou Angular  

