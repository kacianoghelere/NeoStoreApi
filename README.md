# NeoStore API

## Instruções para instanciar o projeto
Na elaboração do projeto, utilizei Java 17, Maven, JUnit, Netbeans, Glassfish Server e MySQL DataBase.

Para executá-lo, será necessário no mínimo os itens abaixo estejam em conformidade:
1. O banco de dados MySQL deve conter um schema chamado `neo_store`;
2. O servidor precisará conter um pool de conexões com o banco MySQL;
3. O servidor deve ter uma conexão JTA chamada `mysq/neo_store` relacionada ao pool de conexões mencionado acima.
4. As dependencias do Maven devem estar instaladas corretamente.

Uma vez que os itens necessários sejam atendidos, basta fazer o build da aplicação via IDE ou linha de comando e hospedar o `.war` no servidor de sua escolha.