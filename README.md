# Consolidador de Carteira de Investimentos

### Desenvolvedor:
- Projeto desenvolvido por mim, **Felipe Homem Martins** | [LinkedIn](https://www.linkedin.com/in/felipe-h-martins/) |

### Descrição do Projeto:
- Este projeto consiste em um sistema para centralizar os ativos dos usuários.
- O objetivo é facilitar a visualização dos ativos que o usuário possui em diferentes segmentos: ações, fundos imobiliários e criptomoedas.
- Será permitido cadastrar compras e vendas de ativos, visualizar a porcentagem da carteira em cada segmento, acompanhar o desempenho dos ativos e criar metas para sua carteira.

### Tecnologias utilizadas:
- **| Tecnologia | Finalidade |**
  - | Java 17 | Linguagem de programação |
  - | Maven | Gerenciamento de dependências |
  - | Spring Boot 4 | Desenvolvimento da API |
  - | Spring Data JPA | Persistência de dados |
  - | Spring Validation | Validação de dados |
  - | Spring Security | Controle de acesso |
  - | Token JWT | Autenticação e autorização |
  - | MySQL | Banco de dados |
  - | Git e GitHub | Controle de versão |
  - | Intellij IDE | Ambiente de Desenvolvimento |
  - | brModelo | Criação da modelagem conceitual e lógica do banco de dados |
  - | Postman | Testes da API |

### Endpoints

### Rota: `/user`

- **Cadastro do usuário**
  - `POST`  

    ```json
    {
      "fullName": "Primeiro Usuário",
      "email": "testando01@gmail.com",
      "phone": "51999999999",
      "password": "testando123",
      "birthDate": "2004-10-20"
    } 
    ```


- **Editar perfil do usuário**
  - Precisa estar logado para utilizar esse path
  - `PUT /edit-profile`

    ```json
      {
        "fullName": "Primeiro Usuário Editado",
        "email": "testando001@gmail.com",
        "phone": "51999999999",
        "birthDate": "2004-10-20"
      }
    ```

- **Alterar senha do usuário**
  - Precisa estar logado para utilizar esse path
  - `PUT /change-password`

    ```json
    {
      "currentPassword": "testando123",
      "newPassword": "atualizada"
    }
    ```

- **Deletar perfil de usuário**
  - Precisa estar logado para utilizar esse path
  - `DELETE`

### Rota: `/auth`
- **Login usuário**
  - `POST /login`

    ```json
    {
      "email": "testando01@gmail.com",
      "password": "testando123"
    }
    ```

- **Logout**
  - Precisa estar logado para utilizar esse path
  - `POST /logout`