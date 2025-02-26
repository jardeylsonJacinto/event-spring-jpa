# Event API - Spring Boot

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen) ![Java](https://img.shields.io/badge/Java-21-blue) ![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)

## 📌 Sobre o Projeto
Este é um projeto de API REST para gerenciamento de eventos e locais, desenvolvido com **Spring Boot** e **MySQL**. A API permite criar, listar, atualizar e excluir eventos e locais, seguindo boas práticas de desenvolvimento.

---

## 🚀 Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.4.3**
- **Spring Data JPA**
- **Spring Validation**
- **SpringDoc OpenAPI**
- **HikariCP** (gerenciamento de conexões com o banco)
- **Lombok** (redução de código boilerplate)
- **MySQL** (banco de dados relacional)
- **Maven** (gerenciamento de dependências)

---

## 📖 Endpoints

### 🔹 Local Controller (`/local`)
| Método | Endpoint | Descrição |
|--------|---------|------------|
| `GET` | `/local` | Lista todos os locais |
| `POST` | `/local` | Cria um novo local |
| `GET` | `/local/{id}` | Obtém um local específico |
| `DELETE` | `/local/{id}` | Remove um local |

### 🔹 Evento Controller (`/api/evento`)
| Método | Endpoint | Descrição |
|--------|---------|------------|
| `POST` | `/api/evento` | Cria um novo evento |
| `GET` | `/api/eventos` | Lista todos os eventos |
| `GET` | `/api/evento/{id}` | Obtém um evento específico |
| `DELETE` | `/api/evento/{id}` | Remove um evento |

### 🔹 Eventos por Local (`/api/local/{localId}/evento`)
| Método | Endpoint | Descrição |
|--------|---------|------------|
| `GET` | `/api/local/{localId}/evento` | Lista eventos de um local |
| `POST` | `/api/local/{localId}/evento` | Cria um evento em um local |
| `DELETE` | `/api/local/{localId}/evento` | Remove eventos de um local |

---

## ⚙️ Configuração do Banco de Dados
Antes de rodar o projeto, crie um banco de dados MySQL chamado `db_event` e configure as credenciais no `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_event
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Como Rodar o Projeto
### **Pré-requisitos**
- **Java 21** instalado
- **MySQL** rodando
- **Maven** instalado

### **Passos**
1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-repositorio.git
   ```
2. Acesse o diretório do projeto:
   ```sh
   cd event-api
   ```
3. Configure o banco de dados conforme explicado acima.
4. Execute o projeto com Maven:
   ```sh
   mvn spring-boot:run
   ```
5. Acesse a documentação da API (Swagger UI):
   - **[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**

---

## 📌 Autor
Desenvolvido por **Jardeylson Jacinto** 🚀

Sinta-se à vontade para contribuir! Se encontrar algum problema ou tiver sugestões, abra uma issue. 😊

