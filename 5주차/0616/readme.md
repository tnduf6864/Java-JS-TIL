+ 서브쿼리~
  - Subquery:    WHERE절
  - Inlineview:  FROM절
  - ScalarQuery: SELECT절

  단일행 서브쿼리: 메인쿼리와 일반비교연산 ( = > < >= <= <> )
  여러행 서브쿼리: 메인쿼리와 특수비교연산 ( IN ANY ALL)
  EX) 부서별 최대 급여


        SELECT last_name
        FROM employees
        WHERE salary IN (
            SELECT  MAX(salary)
            FROM employees
            GROUP BY department_id
        );

    WHERE 여러 개 매치해줘야됨

        SELECT department_id, employee_id, first_name, salary
        FROM employees
        WHERE (department_id, salary) IN
            (SELECT department_id, MAX(salary)
            FROM employees
            GROUP BY department_id);

  -ANY(OR), ALL(AND)
  -InlineView


  --입사일자가 '07/01/01'이후 입사한 사원의 정보를 출력하시오

        SELECT rownum, employee_id, hire_date, salary
        FROM
            (SELECT employee_id, hire_date, salary
            FROM employees
            WHERE hire_date >= '07/01/01'
            ORDER BY salary)
        WHERE rownum <= 5;


      - rownum between 6 and 10으로 하면 아무것도 안나와 (where에서 조건에 맞지않아서  rownum이 안됨)

            SELECT rn, employee_id, hire_date, salary
            FROM
                (SELECT rownum AS rn, employee_id, hire_date, salary
                 FROM
                    (SELECT employee_id, hire_date, salary
                    FROM employees
                    WHERE hire_date >= '07/01/01'
                    ORDER BY salary))        
            WHERE rn between 6 AND 10;


      - FROM에 이름달기


            --입사일자가 '07/01/01'이후 입사한 사원의 정보를 출력하시오
            SELECT *
            FROM
                (SELECT rownum AS rn, a.*
                 FROM (
                    SELECT employee_id, hire_date, salary
                    FROM employees
                    WHERE hire_date >= '07/01/01'
                    ORDER BY salary) a
                )        
            WHERE rn BETWEEN 6 AND 10;


- Scalar Subquery
    -- 사원의 사번, 이름, 부서번호, 부서명을 출력하시오
  
      SELECT employee_id, first_name, d.department_id, department_name
      FROM employee e JOIN departments d ON (e.department_id = d.department_id)

      SELECT employee_id, first_name, department_id,
          (SELECT department_name
          FROM departments
          WHERE department_id = employees.department_id)
      FROM employees;

//SELECT

- DDL
- 무결성 제약조건
  1. NOT NULL
  2. UNIQUE
  3. PRIMARY KEY: NOT NULL + UNIQUE
  4. CHECK (특정 값의 범위)
  5. FOREIGN KEY
 
  (1) 테이블 레벨로 설정
  
          CREATE TABLE t_a(c_a number(5) default 0,
            c_b varchar2(10),
            constraint c_a_pk PRIMARY KEY(c_a),
            constarint c_b_ck CHECK (c_b IN ('남', '여'))
          );


  (2) 컬럼 레벨로 설정

          CREATE TABLE t_a(c_a number(5) default 0 constraint c_a_pk PRIMARY KEY,
                          c_b varchar2(10) constraint c_b_ck CHECK (c_b IN ('남', '여'))
          );

  (3) 테이블 레벨로 추가

          ALTER TABLE product
          ADD CONSTRAINT prod_no_pk PRIMARY KEY(prod_no);
  
  (4) 컬럼 레벨로 추가
  
          ALTER TABLE product
          MODIFY prod_name CONSTRAINT prod_name_nn NOT NULL;        
    
