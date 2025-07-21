# Catálogo de Livros

Este projeto é uma aplicação Spring Boot para cadastro, consulta, atualização e remoção de livros em um catálogo.

## Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* H2 Database (banco de dados em memória)
* Maven

## Funcionalidades

* Listar livros cadastrados
* Adicionar novo livro
* Atualizar informações de um livro
* Remover livro
* Buscar livro por ID ou título

## Como Executar

1. Clone o repositório:

```
git clone https://github.com/seu-usuario/catalogo-livros.git
```

2. Acesse o diretório do projeto:

```
cd catalogo-livros
```

3. Execute o projeto:

```
./mvnw spring-boot:run
```

4. A aplicação estará disponível em:

```
http://localhost:8080
```

## Banco de Dados

A aplicação utiliza o banco H2 em memória. O console pode ser acessado em:

```
http://localhost:8080/h2-console
```

Usuário: `sa`
Senha: *(em branco)*

## Endpoints

* `GET /livros`: lista todos os livros
* `GET /livros/{id}`: busca livro por ID
* `POST /livros`: cadastra um novo livro
* `PUT /livros/{id}`: atualiza um livro existente
* `DELETE /livros/{id}`: remove um livro

## Contribuição

Contribuições são bem-vindas. Sinta-se à vontade para abrir issues ou pull requests.
