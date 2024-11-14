# 📄 API 명세서

## 📅 일정
|기능|Method|URL|HTTP 응답 상태 코드 (성공)|HTTP 상태 코드 (실패)|
|:---|:---:|:---|:---|:---|
|일정 등록|POST|/schedules|201 Created|400 Bad Request|
|일정 단건 조회|GET|/schedules/{id}|200 OK|404 Not Found|
|일정 전체 조회|GET|/schedules|200 OK|빈 배열로 응답하되 상태 코드는 200 OK|
|일정 수정|PATCH|/schedules/{id}|200 OK|400 Bad Request, 404 Not Found|
|일정 삭제|DELETE|/schedules/{id}|204 No Content|404 Not Found|

|이름|타입|설명|요청 필수 여부|
|:---|:---|:---|:---:|
|id|long|일정 식별자|N|
|userId|long|유저 식별자|Y|
|title|string|할일 제목|Y|
|contents|string|할일 내용|Y|
|createdDate|timestamp|작성일|N|
|modifiedDate|timestamp|수정일|N|

### 1️⃣ 일정 등록
#### Request
```
POST /schedules HTTP/1.1
Content-Type: application/json

{
 "userId": 1,
 "title": "강의",
 "contents": "3 주차 강의까지 듣기"
}
```
#### Success Response
```
HTTP/1.1 201 Created
Content-Type: application/json
Location: /schedules/1

{
 "id": 1,
 "userId": 1,
 "title": "강의",
 "contents": "3 주차 강의까지 듣기",
 "createdDate": "2024-10-30T17:22:33.123+00:00",
 "modifiedDate": "2024-10-30T17:22:33.123+00:00"
}
```
#### Error Response
```
{
 "timestamp": "2024-10-30T17:22:33.123+00:00"
 "status": 400
 "error": Bad Request
 "path": /schedules
}
```

### 2️⃣ 일정 단건 조회
#### Request
```
GET /schedules/1 HTTP/1.1
Host: localhost:8080
```
#### Success Response
```
HTTP/1.1 200 OK
Content-Type: application/json

{
 "id": 1,
 "userId": 1,
 "title": "강의",
 "contents": "3 주차 강의까지 듣기",
 "createdDate": "2024-10-30T17:22:33.123+00:00",
 "modifiedDate": "2024-10-30T17:22:33.123+00:00"
}
```
#### Error Response
```
{
 "timestamp": "2024-10-30T17:22:33.123+00:00"
 "status": 404
 "error": Not Found
 "path": /schedules/1
}
```

### 3️⃣ 일정 전체 조회
#### Request
```
GET /schedules HTTP/1.1
Host: localhost:8080
```
#### Success Response
```
HTTP/1.1 200 OK
Content-Type: application/json

[
 {
  "id": 1,
  "userId": 1,
  "title": "강의",
  "contents": "3 주차 강의까지 듣기",
  "createdDate": "2024-10-30T17:22:33.123+00:00",
  "modifiedDate": "2024-10-30T17:22:33.123+00:00"
 },
 {
  "id": 2,
  "userId": 2,
  "title": "과제",
  "contents": "API 명세서 작성하기",
  "createdDate": "2024-11-01T18:10:33.123+00:00",
  "modifiedDate": "2024-11-01T18:10:33.123+00:00"
 }
]
```
#### Error Response
```
{
 "timestamp": "2024-11-01T18:30:33.123+00:00"
 "status": 404
 "error": Not Found
 "path": /schedules
}
```

### 4️⃣ 일정 수정
#### Request
```
PATCH /schedules/2 HTTP/1.1
Content-Type: application/json

{
  "title": "금일 목표",
  "contents": "API 명세서 피드백 받기"
}
```
#### Success Response
```
HTTP/1.1 200 OK
Content-Type: application/json
Location: /schedules/2

{
  "id": 2,
  "userId": 2,
  "title": "금일 목표",
  "contents": "API 명세서 피드백 받기"
  "createdDate": "2024-11-01T18:10:33.123+00:00",
  "modifiedDate": "2024-11-01T18:50:33.123+00:00"
}
```
#### Error Response
```
{
 "timestamp": "2024-11-01T19:22:33.123+00:00"
 "status": 400
 "error": Bad Request
 "path": /schedules/2
}
```

### 5️⃣ 일정 삭제
#### Request
```
DELETE /schedules/1 HTTP/1.1
Host: localhost:8080
```
#### Success Response
```
HTTP/1.1 204 No Content
```
#### Error Response
```
{
 "timestamp": "2024-11-01T19:45:33.123+00:00"
 "status": 404
 "error": Not Found
 "path": /schedules/1
}
```

---------------------

## 👩 유저
|기능|Method|URL|HTTP 응답 상태 코드 (성공)|HTTP 상태 코드 (실패)|
|:---|:---:|:---|:---|:---|
|유저 등록|POST|/users|201 Created|400 Bad Request|
|유저 단건 조회|GET|/users/{userId}|200 OK|404 Not Found|
|유저 전체 조회|GET|/users|200 OK|빈 배열로 응답하되 상태 코드는 200 OK|
|유저 비밀번호 수정|PATCH|/users/{userId}|200 OK|401 Unauthorized, 404 Not Found|
|유저 삭제|DELETE|/users/{userId}|204 No Content|404 Not Found|

|이름|타입| 설명     |요청 필수 여부|
|:---|:---|:-------|:---:|
|userId|long| 유저 식별자 |N|
|name|string| 이름     |Y|
|email|string| 이메일    |Y|
|password|string| 비밀번호   |Y|
|createdDate|timestamp| 등록일    |N|
|modifiedDate|timestamp| 수정일    |N|

### 1️⃣ 유저 등록
#### Request
```
POST /users HTTP/1.1
Content-Type: application/json

{
 "name": "김자바",
 "email": "java@naver.com",
 "password": "1234"
}
```
#### Success Response
```
HTTP/1.1 201 Created
Content-Type: application/json
Location: /users/1

{
 "userId": 1,
 "name": "김자바",
 "email": "java@naver.com",
 "password": "1234",
 "createdDate": "2024-10-29T17:22:33.123+00:00",
 "modifiedDate": "2024-10-29T17:22:33.123+00:00"
}
```
#### Error Response
```
{
 "timestamp": "2024-10-29T17:22:33.123+00:00"
 "status": 400
 "error": Bad Request
 "path": /users
}
```

### 2️⃣ 유저 단건 조회
#### Request
```
GET /users/1 HTTP/1.1
Host: localhost:8080
```
#### Success Response
```
HTTP/1.1 200 OK
Content-Type: application/json

{
 "userId": 1,
 "name": "김자바",
 "email": "java@naver.com",
 "createdDate": "2024-10-29T17:22:33.123+00:00",
 "modifiedDate": "2024-10-29T17:22:33.123+00:00"
}
```
#### Error Response
```
{
 "timestamp": "2024-10-29T18:22:33.123+00:00"
 "status": 404
 "error": Not Found
 "path": /users/1
}
```

### 3️⃣ 유저 전체 조회
#### Request
```
GET /users HTTP/1.1
Host: localhost:8080
```
#### Success Response
```
HTTP/1.1 200 OK
Content-Type: application/json

[
 {
  "userId": 1,
  "name": "김자바",
  "email": "java@naver.com",
  "createdDate": "2024-10-29T17:22:33.123+00:00",
  "modifiedDate": "2024-10-29T17:22:33.123+00:00"
 }
]
```
#### Error Response
```
{
 "timestamp": "2024-11-01T10:30:33.123+00:00"
 "status": 404
 "error": Not Found
 "path": /users
}
```

### 4️⃣ 유저 비밀번호 수정
#### Request
```
PATCH /users/1 HTTP/1.1
Content-Type: application/json

{
  "oldPassword": "1234",
  "newPassword": "java1234"
}
```
#### Success Response
```
HTTP/1.1 200 OK
```
#### Error Response
```
{
 "timestamp": "2024-11-01T11:22:33.123+00:00"
 "status": 401
 "error": Unauthorized
 "path": /users/1
}
```

### 5️⃣ 유저 삭제
#### Request
```
DELETE /users/1 HTTP/1.1
Host: localhost:8080
```
#### Success Response
```
HTTP/1.1 204 No Content
```
#### Error Response
```
{
 "timestamp": "2024-11-01T12:45:33.123+00:00"
 "status": 404
 "error": Not Found
 "path": /users/1
}
```

---------------------------------

# ☁ ERD
- user 테이블에 등록된 유저만 일정 등록을 할 수 있음
<img src="https://github.com/user-attachments/assets/92d989a0-764d-4322-92ec-976caf613c62"/>
