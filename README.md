### 테크스펙 작성
https://www.notion.so/API-2e3750bfa48b4454998bb7b93f71c6b7

## 동작 방식
### 회원가입
http://localhost:8080/users/join

body :

{
"userId": "sads",
"userPhoneNumber" : "01011112222",
"businessNumber" : "4145212333",
"businessPhoneNumber" : "01033334444",
"password" : "fnkasdiasdss2@",
"checkedPassword" : "fnkasdiasdss2@"
}

### 로그인
http://localhost:8080/users/login

request body :

{
"id": "sads",
"password" : "fnkasdiasdss2@"
}

* 로그인을 하면 응답 값으로 jwt 토큰이 발급되고 주문 리스트 조회와 주문지 변경시 사용 필요

### 주문지 변경
http://localhost:8080/orders/update/address?id=2&baseAddress=청와대로 142&detailAddress=1층
* header에 Authorization 토큰 추가 필요 - Bearer [토큰 값]

### 주문리스트 조회
http://localhost:8080/orders/?page=0&size=10
* header에 Authorization 토큰 추가 필요 - Bearer [토큰 값]

### 추가로 작업이 필요한 내용

1. 다양한 테스트 케이스 성공 , 실패 케이스 적용  + API 문서화
    1. security 및 jwt 토큰이 적용 전까지는 redoc, swagger 문서화 발급이 되고 있으나
       적용 이후부터는 테스트 실패로 인해 문서화가 안되는 상태
    2. 다양한 성공, 실패 사례의 테스트 코드 작성
2. 예외케이스 응답 코드 정리
    1. 각 상황에 맞는 응답 코드 내역을 정리하여 메시지의 결과 값을 알 수 있도록 함.
3. refresh 토큰 적용
    1. 현재는 access 토큰만 사용하고 있는 상태