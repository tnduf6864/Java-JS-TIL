
![image](https://github.com/tnduf6864/TIL/assets/66365553/8aaec866-38e7-4fbd-af9f-72edfe73ebc9)

RDBMS - 테이블끼리 관계를 맺고있는 관계형DBMS

![image](https://github.com/tnduf6864/TIL/assets/66365553/600191a7-d5c0-4ce9-abcc-9b2b6885154d)

[외래키]
부모 엔터티: 자료가 저장되어 있는 곳
자식 엔터티: 자료를 참조하는 곳

![image](https://github.com/tnduf6864/TIL/assets/66365553/c52be49d-0679-4aa9-9b48-e16b485c417b)

![image](https://github.com/tnduf6864/TIL/assets/66365553/3d5dd2bf-602f-4cf1-9006-92275e5da1a5)

- 선택참여: 관계가 맺어져있지만 없을 수도 있음 (Point가 없을 때) (동그라미 표시) (1대다일때: 0 or M,)
- 필수참여: 무조건 있어야함.


![image](https://github.com/tnduf6864/TIL/assets/66365553/9c0e419a-97f9-4e88-b256-d642241222e8)


![image](https://github.com/tnduf6864/TIL/assets/66365553/8617c729-f1fd-403d-bd84-98cfe6c2e210)


![image](https://github.com/tnduf6864/TIL/assets/66365553/7361b687-2c5c-4ab4-8d53-a50e8f7dcc86)
![image](https://github.com/tnduf6864/TIL/assets/66365553/5bf04c41-eed9-4809-a979-71e4d2fc62f0)


+별칭 정할 때
- 소문자 or 띄어쓰기 쓰고싶음 " " 안에 이름넣어 
- AS 이름으로 가능
![image](https://github.com/tnduf6864/TIL/assets/66365553/99efaac7-484b-4e39-88d8-4c63de92fc71)

null 은 비교연산자 =, <>에 포함되지않음
![image](https://github.com/tnduf6864/TIL/assets/66365553/41d0fbca-99d6-4ead-bd07-da12ae2ba13b)

SELECT employee_id    AS 사번, 
       salary         AS 급여,
       department_id  AS 부서번호 
FROM employees 
WHERE (salary between 10000 AND 20000) AND department_id  In (10, 50, 90);

-in, between을 써서 하는 것이 처리속도방면에서 효율적일 수 있다.

- ORDER BY 별칭; 가능
- ORDER BY (3); 3번째 속성기준으로 (index사용)
- 출력하지 않는 컬럼을 정렬대상으로도 설정 가능

