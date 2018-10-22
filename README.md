Test ValorProfs
===================================
Application backend for valorProfs

## Getting Started

### Prerequisites

```
MySQL 5.7.23
Wildfly 13
Eclipse Photon Release (4.8.0)
Apache maven 3.5.4
javaSE-1.8
```

### Install & Run

1- Put the script in mysql (valorProfs/src/main/resources/sql/database.sql) and run.
2- Put the project on eclipse.
3- Change the username and password in valorProfs/src/main/resources/mybatis-config.xml and put your credentials of the MySQL.
4- Execute the maven update.
4- Create a new server with wildfly 13.
5- Add the project to configure it on the server.
6- Start the server.

Runs on port `8080`.

### Users

admin@admin.com - admin123
user@user.com - user123

### How works

When user call GET, POST, PUT and DEL must be use the Basic Auth (for example Postman application)

```
Admin (Read and Write)
localhost:8080/valorProfs/product/all
localhost:8080/valorProfs/product/{id}
localhost:8080/valorProfs/product/insert
localhost:8080/valorProfs/product/update
localhost:8080/valorProfs/product/delete

User (Read only)
localhost:8080/valorProfs/product/all
localhost:8080/valorProfs/product/{id}

Open (Don't need user and pass - Test mode)
localhost:8080/valorProfs/open/gridName
localhost:8080/valorProfs/open/all
```


