# Visão geral do projeto:

O projeto contempla a criação de uma aplicação fullstack que atenda os seguintes requisitos:
[Documentação](https://github.com/SoaresEnzo/avaliacao-full-stack/blob/main/requirements.md).

# Tecnologias e ferramentas utilizadas:
- Java 17
- Springboot 2.7.3
- H2
- Angular
- Docker
- Visual Studio Code
- Intellij IDEA

# Back-end
Durante o desenvolvimento, foi utilizado TDD para evitar bugs e ter mais confiabilidade do que foi desenvolvido.
Para isolar as regras de negócio e tornar a aplicação mais flexível e desacoplada de tecnologias, foi utilizada a arquitetura hexagonal.
![arquitetura-hexagonal](https://user-images.githubusercontent.com/62313997/188759813-180f0f67-6137-4b8c-8b4d-ff02d4bc6da2.svg)

Existem os seguintes endpoints disponíveis:
GET: /transfer
  Retorna uma lista de transferências paginadas
POST: /transfer
  Cria uma nova transferência no sistema.
GET: /transfer/fee
  Retorna o valor da taxa calculada de acordo com a data agendada e valor passado.
  
# Subida do projeto:
Há duas formas de subir o projeto: instalando direto em sua máquina ou subindo em containeres Docker.
## Forma 1 - Em sua máquina
Passo 1:
  Instale o NodeJS em sua versão LTS.

Passo 2:
  Instale a CLI do Angular conforme a documentação oficial.

Passo 3:
  Na pasta /ui-app rode o comando ng serve. 

Passo 4:
  Instale o Java 17 conforme a documentação oficial.

Passo 5:
  Instale o maven.

Passo 6:
  Na pasta /transferencias rode o comando mvn clean install.

Passo 7:
  Entre na pasta /transferencias/target que foi criada e rode o comando java -jar transferencias-0.0.1-SNAPSHOT.jar

Passo 8:
  Acesse a aplicação front-end em http://localhost:4200 e a back-end em http://localhost:8080

## Forma 2 - Containerizado
Passo 1:
  Instale o Docker conforme a documentação oficial.

Passo 2:
  Na pasta raíz do projeto, execute o comando "docker-compose up --build" e espere o projeto terminar de buildar.
  
Passo 3:
  Acesse a aplicação front-end em http://localhost:4200 e a back-end em http://localhost:8080
