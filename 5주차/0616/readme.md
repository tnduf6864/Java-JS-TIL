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
    
    SELECT department_id, employee_id, first_name, salary
    FROM employees
    WHERE (department_id, salary) IN
            (SELECT department_id, MAX(salary)
            FROM employees
            GROUP BY department_id);

  
