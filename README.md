Para executar o projeto será necessario ter um container docker com o postgres rodando (você deve ter o docker instalado);

Após instalar o docker execute o seguinte comando.

docker run --name postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres

Para roda a aplicação será necessario cria um database chamado partner_fan
Para roda os testes de integração será necessario cria um database chamado partner_fan_test

na sua IDE import o arquivo build.gradle para poder startar o server
para rodar o client va na pasta socio_torcedor/client e execute o comando 
    npm install 
depois 
    npm start
