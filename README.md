# productms

  Projeto de Crud para catálogo de produtos com Java utilizando o framework Spring Boot, H2 e Maven.
  
## Instruções
  - Para testar o programa utilizar o comando `java -jar productms-0.0.1-SNAPSHOT.jar`, verifique se está na pasta correta.
  - Utilizar Curl ou ferramentas como Postman para realizar requisições.
  - Endpoints disponíveis `/products'.
  - :exclamation: Mudar a porta da aplicação caso necessário. Padrão é 9999
  
## Informações adicionais

### Banco de dados
  Para verificar o Banco de Dados H2 acesse pelo navegador localhost:9999/h2-console, com url "jdbc:h2:mem:tempdb2" e user "sa".

### Rota Products
    -Request:
      Método: GET, POST, PUT ou DELETE
      Rotas Disponiveis: /products ou /products/search 
    -Response: 
      Status Code: 200, 201, 400, 404 ou 500
      Corpo: “OK”, JSON ou "Mensagem de erro"
 
