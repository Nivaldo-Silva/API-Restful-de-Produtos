# Projeto API de Produtos

## Visão Geral

Este projeto é uma API RESTful simples para gerenciar produtos. Ele permite a criação, recuperação, atualização e exclusão (inativação) de produtos. A API é construída usando Spring Boot e segue uma arquitetura em camadas com controladores, modelo, serviços, repositórios e DTOs (Objetos de Transferência de Dados).

### Estrutura do Projeto

* Camada de Controle: Lida com as requisições e respostas HTTP.
* Camada de Serviço: Contém a lógica de negócio.
* Camada de Repositório: Lida com as interações com o banco de dados.
* DTOs (Objetos de Transferência de Dados): Usados para transferir dados entre camadas.
* Mapeamento de Modelos: Mapeia DTOs para Entidades e vice-versa.
* Validação: Garante a integridade e correção dos dados.

#### Endpoints

Criar um Produto
URL: /products
Método: POST

Obter Todos os Produtos
URL: /products
Método: GET

Atualizar um Produto
URL: /products/{id}
Método: PUT

Inativar (Excluir) um Produto
URL: /products/{id}
Método: DELETE

##### Arquivos do Projeto

* Controlador
  
Localizado em br.com.nivaldosilva.api_product.controller.ProductController

Lida com os endpoints da API e delega o processamento para a camada de serviço.

* DTO
  
Localizado em br.com.nivaldosilva.api_product.dto.ProductDTO

Define a estrutura dos dados do produto transferidos entre o cliente e o servidor. Inclui anotações de validação para garantir a integridade dos dados.

* Modelo
  
Localizado em br.com.nivaldosilva.api_product.model.ProductEntity

Representa a entidade do produto armazenada no banco de dados. Anotada com anotações JPA para mapeá-la para a tabela tb_product.

* Configuração do Mapeador
  
Localizado em br.com.nivaldosilva.api_product.mapper.MapperConfig

Configura o ModelMapper para mapear entre ProductDTO e ProductEntity.

* Serviço
  
Localizado em br.com.nivaldosilva.api_product.service.ProductService

Contém a lógica de negócio para criar, recuperar, atualizar e inativar produtos.

* Repositório
  
Localizado em br.com.nivaldosilva.api_product.repository.ProductRepository

Estende JpaRepository para fornecer operações CRUD na ProductEntity.

### Dependências

* Spring Boot
* Spring Data JPA
* ModelMapper
* Jakarta Validation
* Banco de Dados PostgreSQL

## Executando o Projeto

### Clone o repositório

 git clone https:github.com/Nivaldo-Silva/ Projeto-API-Restful.git

### Navegue até o diretório do projeto

cd api_product

### Compile o projeto

mvn clean install

### Execute a aplicação

mvn spring-boot:run

### A API estará acessível em http:localhost:8080/products
