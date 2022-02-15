# Trabalho Containers & Virtualization
- Professor: Daniel de Andrade Lemeszenski

#### Grupo

- Guilherme Mauricio
- Douglas Mateus
- João Rafael
- Julia Assunção

#### Definição

```
Criar projeto java no git com Docker-composse.yml
1 – container Aplicação java / spring boot (apontando para o container 2 do banco)
2 – container Postgres ou mongoDB
3 – Nginx com proxy pass apontando para (apontando para o container 1 do java)

compartilhar projeto github com prof daniboy82

exemplo docker-compose:

https://github.com/daniboy82/exemplo-docker-compose


exemplo configuração nginx:

location /some/path/ {
    proxy_set_header Host $host;
    proxy_set_header X-Real-IP $remote_addr;
    proxy_pass http://localhost:8000;
}

LOCAL ARQUIVO CONF DO NGINX:
/etc/nginx/conf.d/default.conf

```

#### Requisitos

- Docker

#### Como executar o projeto:

\*\* O terminal deve estar na pasta raiz do projeto

1. Executar o comando para fazer o build e aguardar a execução:

   ```
      docker-compose build
   ```

2. Depois de executado o comando anterior, executar o seguinte:

   ```
      docker-compose up -d
   ```

#### Link
**Swagger:** http://localhost

