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
  
