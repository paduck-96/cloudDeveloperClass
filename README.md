# kakaocloudschool

카카오 클라우드 스쿨 학습
/- 네트워크에 대한 학습, 아키텍처에 대한 학습

## 프론트엔드 학습

Day-1 : html과 html 태그에 관한 학습
Day-2 : 영역(div/span/iframe)과 css에 관한 학습
Day-3 : 반응형 웹(media query, flex, grid)과

---

## 클라이언트-서버 앱 제작 방법

1. 클라이언트 --요청--> 서버
   서버 --템플릿 엔진으로 뷰 화면 전송-->클라이언트
2. 클라이언트 --요청--> 서버
   서버 --결과--> 클라이언트가 데이터 해석해서 출력
   (서버, 클라이언트 따로 제작)
   \!이 과정에서 상호 간에 규칙이 필요\!
   1. xml
      태그 형태이나 개발자가 해석
      알아보기 쉬우나 용량 큼
   2. json
      자바스크립트 객체 표현법
      알아보기 어려우나 용량 작음

---

## 프로그래밍 언어 실행 방식

1. 컴파일러
   소스 코드 전체 번역 후 실행 => C, JAVA 등
2. 인터프리터
   줄 단위로 번역 후 실행 => JS, Python 등

---

## 데이터의 분류

1. Immutable Data
   변경 불가능한 데이터
   여러 곳에서 사용 / 옵션
2. Mutable Data
   변경 가능한 데이터
3. Scala Data
   1개의 데이터 => 이름이 데이터를 의미
4. Vector Data(List/Map)
   0개 이상의 데이터 => 이름 이외의 별도 추가되는 데이터
5. 정형 데이터
   데이터의 모양 일정 => class, RDBMS 등
6. 비정형 데이터
   데이터의 모양 일정 X => Map, NoSQL 등
7. 반정형 데이터
   비정형이지만 정형으로 만들 수 있음 => xml, json 등

---

## 소스 코드 버전 관리

1. 형상 관리(configuration management)
   변경 사항 관리
   소스 코드 뿐 아니라 문서 등 개발에 사용되는 모든 것 관리
2. 소스 코드 버전 관리
   git => 가장 대중적인 소스 코드 버전 관리
   github => git을 활용하여 소스 코드 버전 관리를 원격 저장소에서 가능하게 할 수 있는 서비스

=> branch : 작은 저장소
commit : 로컬에 반영
push : 서버에 반영
clone : 복제본 가져오기(git clone url)
pull : 변경된 내용 가져오기(git pull branch)

---

## 산술 비트 연산자의 사용

1. ~
   색상 반전 등 그래픽 작업할 때 사용
2. &
   다를 때 0을 반환하기 때문에 삭제 연산에 적용
   그래픽, 데이터 작업에 사용
3. |
   그대로의 값을 반환하기 때문에 복사, 붙여넣기, 저장 등에 적용
   조합기 구축 등 => ctrl, alt 등에 2^n 넣고 눌렸는지 유무에 대해 | 연산
4. ^
   삭제할 때 사용
   그래픽 작업 시, 이미 그린 선 위에 그대로 ^를 통해 선을 다시 그리면 전부 1이 흰색이기 때문에 지워짐

---

## Data 분류

Value 타입 : 변수의 데이터 자체를 보관
Reference 타입 : 변수의 데이터의 참조를 보관
--->
Scala => 변수가 데이터 자체
Vector => 변수가 대표하는 곳의 참조
--->
https://dmitripavlutin.com/value-vs-reference-javascript/

---

## 선언과 저장

<pre>
호출스택(큐) - 운영체제 소유
   [ ]
            스택 - 함수 소유  힙
            [ ]              [ ]
                             [ ]
            리터럴, 상수      [ ]
            함수, 콜백        [ ]
            [ ]              [ ]
            -메모리 해제나    - 인스턴스(여러 개 짜리)
               크기 변경 불가    크기 변경 가능
               (스태틱)          (동적)
</pre>

- 함수를 하나 선언할 경우
  스택에 함수가 올라가고
  호출스택은 함수의 주소를 가지고 있음
- 추가적인 작업 진행을 위해 다시 돌아가야 하는데
  이 명령어가 return
  - 호출스택(메모리)는 함수라면 참조를 기억하기 때문에
    하나만 기억하면 되기 때문에 return 하나 반환
- 추가적으로 함수를 선언하면 스택이 계속 쌓임
  마찬가지로 해당 주소를 가지고 있음

--->
js에서는 함수(정적 영역)와 데이터(동적 영역)가 따로 저장됨
그렇기 때문에 보이기에는 객체 안에 묶여있으나 this 없이 호출할 수 없음
eg) var obj = {"name":"adam", "getName:func(){}}
obj는 스택 / name과 getName은 힙 영역 / getName은 리터럴 영역을 참조
따라서 this 없이 사용하면 리터럴 영역에서만 속성을 찾기 때문에 찾을 수 없음
--->
함수와 메서드의 차이는 호출자 여부
=>결국 메서드는 보이지 않지만, 객체의 참조가 매개변수의 첫 자리

---

## String 활용의 중요점

<pre>
         (Front End)                                              (Back End)
            client                             connect server    application server         data server
                                                   (연결)              (일)                    (저장)

USER ==>   Browser            =request=>        (B/A)Web server
         Application         <=response=        (A)Socket server                                          
   (인스톨/다운로드의 문제)  <=traffic(비용)=>
   (플러그인을 통해 가능하게끔)                                                            |-File Server
   (etc electron)                                                                         |-Data Server -RDBMS
                                                                                               -NoSQL
                                                                                               -분산파일시스템(하둡)
</pre>

결국, 검증은 클라이언트와 서버 모두에서 이루어져야 한다.
그러나, 비용 발생의 문제가 있기 때문에 클라이언트 측에서 검증 작업이 경제적으로 이득이다.
입력이 가능한 것은 문자와 파일 밖에 없고, 파일의 내용물을 검사(전체 읽기)는 비효율적
파일 => 존재여부, 크기, 종류 등...
문자 => String, RegExp로 검증

---

##

List  
데이터를 연속적으로 저장

Linked List  
논리적으로 연속  
다음 주소만 기억하면 중간 끊어질 경우 연결 손실  
그 앞도 기억하는 Double Linked List  
이 상황에서 시작과 끝점을 기억하기 위해  
H(bof)와 T(eof)가 있다

Array(배열)  
입력한 순서대로 연속해서 저장  
크기가 고정

Array list(Vector)  
크기가 변할 수 있는 배열  
Capacity 와 size가 있음

Queue(FIFO)  
처음에 데이터를 추가하고  
처음에 삽입한 데이터를 제거

Deck  
양 쪽에서 삽입 삭제

---

## MSA

Data center의 1원화 => 단일 장애화 발생 가능성 증대  
이를 해결하기 위한 분산 => 마이크로 서비스  
이 과정을 그리드, destribution  
초창기에는 이렇게 분산된 데이터를 모으고 프로세싱 진행  
시간 소요 굉장히 증대  
현재는 마이크로 서비스에서 처리까지 진행하고  
결과를 모은다

---

## 비동기

1. ajax  
   비동기적으로 서버의 데이터를 받아오는 자바스크립트 기술

2. Fetch API  
    ajax의 단점을 보완하기 위해서 등장한 비동기 자바스크립트 기술

   - axios  
     Promise나 async/await을 적용해서 Fetch API를 사용하기 쉽도록 해주는  
     자바스크립트 라이브러리

3. Web Push  
   클라이언트의 요청이 없어도 서버에서 클라이언트로 데이터 전송하는 기술

   - 서버에서 클라이언트 쪽으로 일방적 전송

4. Web Socket  
   연결형 서비스

---

## 프로젝트 파일 디렉토리

1. SRC  
   컴파일 되어야 하는 소스 파일

2. RESOURCES  
   컴파일 할 필요가 없는 파일

---

## Canvas 와 SVG의 비교

- Canvas

  - 이미지 처리 방식  
    Bitmap(Pixel 단위)
  - DOM  
    존재(JavaScript 사용 가능)
  - 성능  
    높은 해상도 이미지 사용시 성능 저하
  - 애니메이션  
    애니메이션 없음
  - 외부 이미지로 저장  
    저장 가능
  - 적합한 서비스  
    게임

- SVG
  - 이미지 처리 방식  
    벡터 그래픽(선 이나 도형 단위)
  - DOM  
    존재하지 않음
  - 성능  
    이미지가 복잡해지면 Mark Up이 복잡
  - 애니메이션  
    애니메이션 가능
  - 외부 이미지로 저장  
    저장 불가능
  - 적합한 서비스  
    세밀한 해상도를 지원하는 UI(Graph)

---

## Memory Leak

용도가 끝났는데도 자원을 모으고 있어서 메모라 낭비가 발생

- 입출력 작업을 수행하거나 타이머 같은 자원을 사용할 때 주로 발생  
  타이머는 사용 끝나면 해제, 입출력 작업은 스트림 close()

---

## 데이터의 저장 과 가져오기 그리고 삭제

1. 데이터를 저장하는 것에 있어서  
   같은 키 값으로 2번 저장했을 때  
   **중복되면 삭제되는지**  
   **하나 더 만들어지는지** 가 중요

2. 데이터를 가져오는 것에 있어서  
   **존재하지 않는 값**을 가져올 때  
   리턴 값이 어떤 것인지

3. 데이터를 삭제하는 것에 있어서
   삭제할 때  
   **무엇을 리턴하는가**

---

## 과거와 지금의 자바스크립트

`예전에는 클라이언트는 작업 후 서버가 랜더링 한 뷰를 출력하는 역할만 수행`

- 자바스크립트로 작업을 수행하는 것은 매우 특별한 경우

---

## 프로젝트 진행

기획 > 분석 > 설계 > 구현(개발) > 테스트 > 배포 > 유지보수(운영)

> 일반적으로 쓰는 console 로깅은 개발 과정 상에서만 작성  
> 차후 발생되는 문제는 파일 이나 DB 에 기록 후 수정
> 이행 에는 문제가 생길 수 있기 때문에 다양한 방법 (클라우드 등) 이용  
> 높은 CI/CD

---

## 프로그램 실행 과정 **잤음**

소스 코드 > 컴파일(번역) > 소스 코드로 이해할 수 있는 코드 변경 및 문법 체크)

- 실행 가능한 코드로 변경  
  start up 코드를 삽입하고 모듈 사이에 관계 설정
  Build
  실행이 가능한 코드로 변경

  - 스타트업 코드를 삽입하고 모듈 서이의 관계 설정
    실행

  -소스 코드가 변경되면 컴파일 에서 문제가 재발상 될 수 있음

---

## Module, Package, Program, Process, Thread

1. Module  
   독자적으로 실행가능한 단위(파일)

- 함수 || 클래스

2. Package  
   1개 이상의 파일로 구성된 `배포 단위`

   - 실행 과는 무관

3. Program  
   유사한 기능들을 묶어서 `실행 가능하도록` 만든 파일의 집합

4. Process  
   실행 중인 프로그램

5. Thread  
   독자적으로는 실행할 수 없는 `Process 내의 작업 단위`

---

## Server

1. Web Server  
   다른 곳에서 URL을 이용해서 사용할 수 있도록 해주는 서버
2. Web Application Server  
   URL과 작업을 매핑해서 URL을 호출하면 작업을 수행하도록 해주는 서버
   - express 모듈, tomcat 등
3. Application Server  
   작업을 해주는 서버

---

## Forwarding 과 Redirect

서버에서 화면을 만들 때만 의미를 갖는 작업 `API Server를 만들 때는 해당 사항이 없음`

- Forwarding  
   현재 흐름을 유지한 채 이동하는 것

  - Url 변경 없음
  - node 에서 html 출력할 때 기본

  `조회 작업에 이용`
  `새로 고침 시 작업 다시 진행`

- Redirect  
   현재 흐름을 끊어 버리는 것

  - Url 변경

  `나머지 작업에는 redirect`
  `새로 고침 시 결과만 새로 고침`

대부분의 경우 조회는 forwarding을 하지만 트래픽을 줄이고자 redirect 하는 경우도 있으나  
삽입, 삭제, 갱신의 작업에서는 반드시 redirect 진행

---

## 프로젝트 진행

프로젝트 내의 파일은 2가지로 분류
하나는 소스 코드이고, 하나는 소스 코드 이외의 자원이다

자원을 읽어서 사용하는 것이 소스 코드 실행 코드

- 소스 코드 > 컴파일해서 운영체제나 VM이 이해할 수 있는 코드로 변경(오류 나면 문법) >  
  컴파일 끝나고 나면 번역된 파일 실행 작업(build / 에러 발생 시 구조 오류) > 실행
  - 컴파일  
    소스 코드 상의 문법적 오류
  - 빌드  
    미들웨어 등의 코드를 동작 함수(app.get) 등에 포함

실제 배포를 할 때는 소스 코드가 아닌 빌드된 내용을 배포
소스 코드를 수정하면 컴파일 과 빌드 다시 해야 함

`업데이트를 하거나 환경을 변경하는 것이 가능하도록 프로그램 제작하는 것이 바람직`
이로 인해 DevOps 나 CI/CD 를 공부

---

## 클라이언트 <-> 서버 프로그래밍

클라이언트가 요청을 보내면 서버가 처리를 하고 결과 또는 화면을 클라이언트에게 전송  
클라이언트에서 서버에게 적절하게 요청을 하면 서버가 그 요청을 받는데 이 때 클라이언트가 데이터를 같이 보내는 경우  
서버는 그 데이터를 읽어서 작업을 수행

- 비지니스 로직을 처리
- 데이터를 영구적으로 저장하고 읽어오는 것

하고 결과 나 화면을 만들어서 전송

---

## AOP(Aspect of Programming)

Business Logic(업무처리)

- 수행 코드
  - 개발자는 알지 못하는 것

Common Concern(공통 관심사항)

- 설정 등의 공통사항

> 공통 관심사항 과 비즈니스 로직 과의 분리를 통해 수정이 용이하다

경제적 측면 상에서 굉장히 효율적이다

---

## SSR, CSR

### 1. 서버 > 소스, 실행, DATA 저장소 내재

파일 사용 중 삭제가 안되는 것처럼 서버 내에서도 작업 도중 락이 걸릴 수 있음 + 속도 하락

- 소스 코드  
  따로 쓰고, 빌드된(배포) 코드만 서버로 전송
- DATA 저장소  
  따로 쓰고, 세세하게 쪼개놔야 속도 향상 가능
  - data만 저장
  - file만 저장

**실행 코드만 내재되는 것이 결국 Application Server**

- Application server
  - service  
    file server만 연결
    - 데이터 처리와는 무관하게
  - repository  
    data server만 연결
  - controller

`마찬가지로 쪼개 놓아야 함`

---

## 데이터베이스 사용

### 로컬 데이터베이스

- 임시 저장

### 외부 데이터베이스

- 서버

SQLite 나 Access 는 **로컬에 설치**해서 사용

- 데이터를 빠르게 사용하기 위하여
- Offline 상태에서 사용하기 위하여

대부분의 경우 외부에 설치해서 애플리케이션 서버를 통해서 사용  
직접 사용(DBA 나 Operator)

---

## Application server 에서 db 사용

Database &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<-- SQL --> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Application Server

Select name as 이름  
From 테이블이름;

- app server 로 넘어갈 때  
  이름 구조로 넘어감

### 개발자와 DBA 와의 차이

`함수 사용을 어느 시점에서 사용 하느냐`가 주요 차이

---

## Null

### 프로그래밍 언어에서...

null 저장할 때 0L 을 참조하는 참조 코드로 저장하는데,  
실제 null 은 공집합 이므로 진짜 0과 혼돈되는 경우 발생

### DB에서...

컬럼의 NOT NULL 유무에 따라 다른데,  
NULL이 가능한 속성은 아닌 것에 비해 한 칸 더 자리를 차지하게 된다

- 따라서 비교할 때 역시 = NULL 이 아닌  
  IS NULL, IS NOT NULL 로 앞 칸의 NULL 유무를 확인
  - Wrapping 이라고도 함
- 따라서 수정이 아닌 `테이블 구조 변경` 취급

---

## 개발자의 대해서

검색 기능을 구현할 때 보더라도...
특정 문자열을 검색했을 때

1. 소문자 대문자
2. 주변 공백 유무
3. 복합 문자열일 때 각기 검색 등...

---

## DB 사용

DB 는 일반적으로 Internal(내부), External(외부) 에 생성

- 외부 접속
  - 종류 파악
    - 전송 / 응답 방법 결정
  - 위치 파악
    - 도메인
    - IP:PORT
  - 계정
    - OS Authentication 유무에 따라  
      계정 유무 필요

### DB 접속 방법

DB Server가 제공하는 Tool > Local

- 주로 관리자 사용

기타 Tool > DBeaver, Toad 등

- 주로 개발자 사용

개발자가 만든 App

- 주로 사용자 사용

### 접속의 과정

어떤 DB인지?  
DB를 어떻게 접속하는지?

- 도메인이 있는지?
- IP나 포트 번호가 무엇인지?
  - localhost(127.0.0.1)인지? 기본 포트인지?

---

## 데이터 분산 처리 방식

1. 데이터를 모은 후

   - 예전 방식

2. 데이터를 처리한 후 결과 모으기
   - 속도 빠른 경우 대다수

---

## 파일을 데이터베이스에 저장하는 방법

### 파일의 경로 저장

- 파일을 별도로 저장하고 그 경로를 저장

### 파일의 내용 저장

- 파일 별도 저장하지 않고 데이터베이스에 바로 저장
- BLOB 방식

---

## 서버 점검

외부 접속이 불가능해 환경 설정 파일에서 bind-ip 부분을 수정하여  
외부 접속 허용

- local ip로 변경

**서버 종료**가 아니라  
차후 서비스를 개발할 때 설정 파일 하나를 지정해  
ip 나열을 해놓은 white list를 만들어서 해당 ip만 허용

---

## 정적 파일

웹에서 소스 코드를 제외하고 서버의 데이터를 출력하는 용도가 아닌 파일

- HTML(예외), CSS, JS, 이미지, 사운드, 동영상 등

---

## 클라이언트 와 서버 간의 데이터 교환 시 고려할 내용

실시간 데이터 변화량이 많을 경우에 매번 받아오기

- 클라이언트가 접속할 때마다 서버에서 데이터 받아오는 경우

거의 데이터의 변화가 없거나 오프라인 상태에서도 앺 사용할 경우

- 서버의 데이터를 로컬에 저장해, 로컬 데이터 유무에 따라 다운로드
  - 서버 데이터의 변화가 있을 경우 그 부분만 가져오기
- 데이터 변경된 경우 `기본키 값을 비교`하여 서버와 클라이언트의 데이터를 비교해 **가져오거나 삭제**한다

---

## SQL 과 ORM 성능

기본적으로

### Application Server 와 RDBMS 는 SQL로 요청하고 결과가 응답되는 구조

### 구조적으로 관계로 지정하기 때문에, 테이블 간의 JOIN 이 빈번

그에 반해

### ORM은 In memory DB 방식으로 진행되기 때문에 성능 우수

### FK의 내용을 전부 참조하고 있기 때문에 JOIN X

---

## DB 에서의 관계

### 1. 일 대 일 관계

내가 너와 연결되거나 아니거나(반대도 마찬가지)  
`양쪽의 기본키를 상대방의 외래키로 설정`

- 하나의 테이블에 컬럼이 너무 많아 성능이 저하될 때 테이블 컬럼 단위로 분할
  - 입력항목이 10개라면 가중치로 나누거나
  - 무언가를 저장할 때 너무 큰 것보다는 중간 사이즈에 나누는 것처럼

### 2. 일 대 다 관계

내가 너 혹은 너희들과 연결 되거나 안되거나(반대는 나 혹은 없거나)  
`1개의 기본키를 N 쪽의 외래키로 설정`

> 근래에는 UK를 만들어서 외래키로 설정하기도 함

- 이러한 상황에서 주로 이용
  - 유저가 쓰는 여러가지 글, 그렇지만 그 글은 유저의 소유
  - 게시글에는 여러 댓글이 달리지만, 각 댓글은 해당 게시글에만 소속
  - Sequelize의 static associate 메서드

### 3. 다 대 다 관계

내가 너 혹은 너희들과 연결되거나(반대도 마찬가지)  
`양쪽의 기본키를 외래키로 갖는 별도 테이블 생성`

- 해당 테이블 기본키를 FK로 하는 새 테이블 생성
- 기본키를 따로 설정하거나, 이 테이블 자체를 기본키로 하거나

- 이러한 상황에서 주로 이용
  - 학생이 듣는 여러 과목, 그 과목을 듣는 많은 학생들

---

## 관계형 DB 데이터 설계

생성되는 **테이블을 기준**으로  
소속되는 **속성** 들을 **키 값 기준**으로 `관계 파악`

- 일 대 일 관계끼리만 하나의 테이블

- 일 대 다 의 관계일 경우 테이블에서 제외
  - `기준이 되었던 키와 같이 나가야 함`
  - 기준 키(기본키)가 다시 기본키가 될 수 없어 외래키 참조
    - 테이블 내에서 키 값을 다시 찾아야 함
      - 관계 파악을 통해 가지치기
      - 불가능할 경우 유니크 값 추가 후 다시 관계 지정

---

## Node 와 Spring

### Routing

- 사용자의 요청이 온 경우 필요한 로직을 호출하고 결과를 전송(json) / 출력(render)

`공통된 설정과 부가적인 설정을 하는 것에 차이를 두기 위해서 사용`

### Service

사용자 요청에 따른 **작업**

- 비지니스 로직
  - 로직(Service)
  - Persistency Store / Repository
- 공통 관심 사항
  - 로그인 여부 등
    - middleware, Filter, AOP 등

---

## Free 와 Premium 구분

### boolean

true 와 false를 이용해서 구분 가능

- 3개 비교 불가

### int

0 과 1 또는 1 과 2 형태로 구분 가능

- 0보다 클 경우의 수들은 다 정수로 비교 어려움

### string

문자열로 저장해서 구분

### ENUM(Enum)

정해진 데이터만 삽입 가능

```sql
-- DB에서 ENUM 역할
type varchar(100) (check type in ("free", "premium"))
```

---

## JS 논리 연산

Boolean 이외의 데이터도 논리 연산 가능  
0이 아닌 숫자 나 **null** 이나 **undefined** 가 아니면 TRUE  
연산의 결과는 boolean 이 아닌 `연산하는 데이터의 자료형`

---

## 관계

### is a 상속

상위 클래스의 인스턴스 > 하위 클래스의 인스턴스

- 하위 클래스에서는 상위 클래스에 대한 포인터 존재
  - super

### has a 포함

하나의 인스턴스 안에 다른 인스턴스 생성

- 외부 인스턴스 안에서 내부 인스턴스 생성되어 외부>내부 사용 쉬움
- 내부 인스턴스가 외부 인스턴스 사용은 어려움
  - 생성 시 외부 인스턴스의 참조 전달

---

## Web에서의 페이지 이동

### Forwarding

요청(request) 객체를 유지하면서 이동  
새로고침을 하면 요청이 다시 이루어지는데 서버에서 처리하는 로직이 있다면 재수행

- 조회에 이용

### Redirect

요청 객체를 소멸시키면서 이동  
새로 고침을 하면 요청이 이루어지지 않고 보여지고 있는 결과를 재출력

- 삽입, 삭제, 갱신 에 이용

`새로고침 시 작업 수행 여부에 따라 페이지 이동 방식 정의`
