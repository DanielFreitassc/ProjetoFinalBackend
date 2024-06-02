# Marketplace api documentação

# BASE ULR API PRINCIPAL = http://localhost:8080
# BASE ULR MICROSERVICE 1 = http://localhost:8081
# BASE ULR MICROSERVICE 2 = http://localhost:8082


Cadastro usuário
POST
```json
http://localhost:8080/auth/register
```
> Body Parameters
```json
{
    "name":"Fulado de Tal",
    "login":"teste@teste.satc.edu.br",
    "password":"Aluno123456789",
    "role":"ADMIN"
}
```
> Response (201 Created)
OR
> Response (400 Bad request)

---
Login usuário
POST
```json
http://localhost:8080/auth/login
```
> Body Parameters
```json
{
    "login":"teste@teste.satc.edu.br",
    "password":"Aluno123456789"
}
```
> Response (200 OK)
```json
{
    "token": "eyJhbGciOi...."
}
```
OR
> Response (401 Unauthorized)
---

Cadastro de produto
POST
```json
http://localhost:8080/products
```
> Body Parameters
```json
{
    "name":"Milho",
    "price":22,
    "description":"Milho enlatado",
    "validity":"02/02/2023"
}
```
> Response (201 Created)
OR
> Response (400 Bad Request)

---
Buscar produtos
GET
```json
http://localhost:8080/products/products?page=0&size=2
```
> Response (200)
```json
{
    "totalElements": 3,
    "totalPages": 2,
    "pageable": {
        "pageNumber": 0,
        "pageSize": 2,
        "sort": {
            "sorted": false,
            "empty": true,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "size": 2,
    "content": [
        {
            "id": 1,
            "name": "Soja",
            "price": 12.0,
            "description": "Soja enlatada",
            "validity": "02/02/2023"
        },
        {
            "id": 2,
            "name": "Milho",
            "price": 22.0,
            "description": "Milho enlatado",
            "validity": "02/02/2023"
        }
    ],
    "number": 0,
    "sort": {
        "sorted": false,
        "empty": true,
        "unsorted": true
    },
    "numberOfElements": 2,
    "first": true,
    "last": false,
    "empty": false
}
```
OR
> Response (404 Not Found)
```json
{
    "status": "NOT_FOUND",
    "message": "Nenhum produto cadastrado no momento"
}
```

---
Buscar produto por ID
GET
```json
http://localhost:8080/products/{id}
```
> Response (200)
```json

```
OR
> Response (404 Not Found)
```json
{
    "status": "NOT_FOUND",
    "message": "Nenhum produto com este ID"
}
```

---
Atualizar produto por ID
PUT
```json
http://localhost:8080/products/{id}
```
> Body parameters
```json
{
    "name":"Milho",
    "price":22,
    "description":"Milho enlatado",
    "validity":"02/02/2023"
}
```
> Response (200)
```json
{
    "id": 4,
    "name": "Milho",
    "price": 22.0,
    "description": "Milho enlatado",
    "validity": "02/02/2023"
}
```
OR
> Response (404 Not Found)
```json
{
    "status": "NOT_FOUND",
    "message": "Nenhum produto com este ID"
}
```
---
Remove produto por ID
DELETE
```json
http://localhost:8080/products/{id}
```
> Response (200)
```json
{
    "id": 2,
    "name": "Milho",
    "price": 22.0,
    "description": "Milho enlatado",
    "validity": "02/02/2023"
}
```
OR

> Response (404 Not Found)
```json
{
    "status": "NOT_FOUND",
    "message": "Nenhum produto com este ID"
}
```