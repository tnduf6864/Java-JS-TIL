#네트워크 마무리
![image](https://github.com/tnduf6864/TIL/assets/66365553/5aaa385a-1804-4cc9-b381-22794f4fc31d)

- ver2 양방향 통신 (서버가 받은 메세지를 clinet에게도 재전송) -에코
- ver3 쓰레드 이용해 다중접속
- ver4 모든 사용자에게 메세지 전송 (채팅프로그램)
- 

![image](https://github.com/tnduf6864/TIL/assets/66365553/41a16606-22bb-4b0d-9f41-e039c65af89d)

# DB 접속하는 법
- jdbc드라이버를 이용해 자바개발자들이 데이터베이스에 접근할 수 있도록 도와줌
- SQLPLUS(소프트웨어) 
- SQL 데이터접근할 수 있는 표준언어
- 


# sqlPlus
1. System계정 접속
  - system/kosta

2. HR계정 unlock
  - system계정에서 실행합니다.
  SQL> alter user hr account unlock;
  
3. HR계정 비번설정하기
  - system계정에서 실행합니다.
  - alter user hr identified by hr;

4. HR계정에 접속하기
SQL> conn hr/hr

5. show User로 계정 변경 된 것 확인


+ DB 계정 = 스키마
- 스키마: 데이터베이스 구조와 제약조건에 대한 명세를 기술한 것.
- 오라클에는 단 하나의 스키마만 존재함

+ 속성 타입
- NUMBER(8, 2) -> XXXXXX.XX (6+2, 2)
- CHAR와 VARCHAR차이
  - CHAR은 공백이 있어도 그 크기만큼 공간할당 "___A"
  - VARCHAR은 입력받은만큼 공간할당
- 
