# A Simple Quarkus CRUD with Spring Boot Rest API and Spring Data JPA Library

## Background
Trying to migrate a simple Spring Boot application, and spend no more than 15 minutes for migrating it to Quarkus, with a basic simple CRUD app. 

One MySql table, with five simple CRUD api. 

## Database
```sql
CREATE TABLE `t_user` (
  `id` varchar(48) NOT NULL,
  `username` varchar(100) NOT NULL,
  `passwd` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_username_uindex` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```

## Api
- Insert or Update
- Delete
- Find by Id
- Find All
- Exists

```
curl -X POST \
  http://localhost:8080/ \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 44' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8080' \
  -H 'cache-control: no-cache' \
  -d '{
	"username":"888999",
	"passwd":"456777"
}'
```

## How to Run
```
compile quarkus:dev
```