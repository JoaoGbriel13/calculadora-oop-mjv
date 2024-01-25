# Sistema Simples de Gerenciamento de Usuários e Calculadora

Este projeto consiste em uma aplicação simples em Java que gerencia o cadastro e login de usuários, além de oferecer operações aritméticas básicas.

## Estrutura do Projeto

### `br.com.jg.Utils.Menu`

A classe `Menu` trata das interações do menu principal, entrada do usuário e navegação pela aplicação.

### `br.com.jg.Service.CalculadoraService`

A classe `CalculadoraService` fornece operações aritméticas básicas, como adição, subtração, multiplicação e divisão.

### `br.com.jg.Model.UserList`

A classe `UserList` gerencia uma lista de usuários registrados. Ela cuida do cadastro de usuários, login e verificações de usernames e emails duplicados.

### `br.com.jg.Model.User`

A classe `User` representa a entidade usuário, com atributos como username, password, primeiro nome, último nome, idade e email.

## Como Utilizar

1. Execute a aplicação.
2. O menu principal apresentará as opções:
   - **1: Cadastrar usuário** - Registrar um novo usuário.
   - **2: Login** - Entrar como um usuário existente.
   - **3: Sair** - Sair da aplicação.

3. Dependendo da escolha, é possível registrar um novo usuário, fazer login e utilizar uma calculadora simples.

## Diagrama de Classes

```plaintext
```mermaid
classDiagram
  class Menu {
    - scan: Scanner
    - userList: UserList
    - calculadoraService: CalculadoraService
    + exibirMenu(): void
    - iniciarMenu(): void
    - cadastrarUser(): void
    - loginUser(): User
    - calcular(User): void
  }

  class CalculadoraService {
    - scanner: Scanner
    + add(): double
    + subtract(): double
    + multiply(): double
    + divide(): double
  }

  class UserList {
    - usersList: List<User>
    + cadastrarUsuario(): void
    + loginUsuario(): User
    - searchUsernameAndEmail(): boolean
  }

  class User {
    - username: String
    - password: String
    - firstName: String
    - lastName: String
    - age: int
    - email: String
    + User(String, String, String, String, int, String)
    + getters and setters
    + toString(): String
  }

  Menu --> CalculadoraService
  Menu --> UserList
  CalculadoraService --> Scanner
  UserList --> List<User>
  UserList --> User

