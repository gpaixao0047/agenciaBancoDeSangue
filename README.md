# Projeto Agência de banco de sangue
Agência de banco de sangue, Front implementado utilizando JSF,Primefaces,Wildfly. Core utiliza Spring Boot, liquibase e Postgres. Ide utilizada foi o Eclipse.

Configuração:
Projeto Agencia Core precisa alterar usuario e senha do postgres, em application.properties.


Para cadastrar os doadores precisa pegar o Json-Atualizado, fazer uma requisição POST para http://localhost:8070/api/doador (Utilizei Postmen para realizar o cadastro) passando também usuario "gpaixao" e senha "123456" no basic Auth.

Para subir o projeto Agencia Front precisa wildfly(Utilizei versão 17), e acesse a url http://localhost:8080/home.xhtml

Mudanças no Json:
data_nasc p/: dataNasc
em dataNasc o valor com as "\/" foi trocado para: \/ -> / 
telefone_fixo p/: telefoneFixo
tipo_sanguineo p/ : tipoSanguineo



