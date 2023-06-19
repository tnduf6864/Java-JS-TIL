+ 무결성 제약조건
  -테이블 레벨: CREATE문으로 테이블을 설정 후 CONSTRAINT 제약조건 설정
  -컬럼 레벨: CREATE문으로 컬럼을 생성하면서 제약조건 설정
  -ALTER (ADD, MODIFY, DROP) CONSTRAINTS...
  
+ UPDATE문
  - UPDATE product SET prod_name = '광어' WHERE prod_no <= 'A15%';
  - 

- eXERD


- 시퀀스 생성
    CREATE SEQUENCE order_seq
    START WITH 5
    INCREMENT BY 2
    MAXVALUE 20
    MINVALUE 1
    CYCLE     --값 순환
    NOCACHE   
    
- 일련번호값 얻기
  SELECT order_seq.NEXTVAL FROM dual;
  
- 일련번호값 조회
  SELECT order_seq.CURRVAL FROM dual;
  
- 시퀀스 삭제
  DROP SEQUENCE
  
- 프로젝트 권장 사항
    
- 고객입장
  가입/로그인/로그아웃
  
  주문자 아이디에 해당하는 주문전체조회
  주문자 아이디에 해당하는 주문번호에 해당 주문내역

- 관리자 입장
  로그인/로그아웃
  주문전체 조회(주문번호, 일자, 주문자아이디, 상품번호, 수량)
  
- 
