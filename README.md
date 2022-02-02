#spring-boot-microservice-2-transaction

## Endpoints

### 1- Get All Transactions
GET /api/transaction HTTP/1.1
Host: localhost:3032
Authorization: Basic basic64(username:password)
Content-Type: application/json
Content-Length: 2

#### 2- Get All Transactions of User
GET /api/transaction/300 HTTP/1.1
Host: localhost:3032
Authorization: Basic basic64(username:password)
Content-Type: application/json
Content-Length: 2
