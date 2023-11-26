# NeoStore API

## Instruções para instanciar o projeto
Na elaboração do projeto, utilizei Java 17, Maven, JUnit, Netbeans, Glassfish Server e MySQL DataBase.

Para executá-lo, será necessário no mínimo os itens abaixo estejam em conformidade:
1. O banco de dados MySQL deve conter um schema chamado `neo_store`;
2. O servidor precisará conter um pool de conexões com o banco MySQL;
3. O servidor deve ter uma conexão JTA chamada `mysq/neo_store` relacionada ao pool de conexões mencionado acima.
4. As dependencias do Maven devem estar instaladas corretamente.

Uma vez que os itens necessários sejam atendidos, basta fazer o build da aplicação via IDE ou linha de comando e hospedar o `.war` no servidor de sua escolha.

Em geral o endereço de acesso será `http://localhost:8080/NeoStore/api/`.

ATENÇÃO: Dependendo do servidor utilizado, a API pode estar disponível em portas diferentes!

## Endpoints
No arquivo `NeoStore.postman_collection.json` você encontrará a collection do Postman utilizada durante os testes com todos os endpoints.

Abaixo segue uma breve relação dos endpoints, verbos HTTP e suas funções:
- **GET** `/api/suppliers`: Lista todos os fornecedores;
- **GET** `/api/suppliers/{id}`: Lista um fornecedor específico a partir de seu id;
- **POST** `/api/suppliers`: Cria um novo fornecedor;
- **POST** `/api/suppliers/import`: Cria novos fornecedores a partir de lista em formato .json recebida;
- **PUT** `/api/suppliers/{id}`: Atualiza um fornecedor específico a partir de seu id;
- **DELETE** `/api/suppliers/{id}`: Remove um fornecedor específico a partir de seu id;