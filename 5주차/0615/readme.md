- HAVING - GROUP BY로 묶은 것들의 조건문,
- GROUP BY에서 사용한 컬럼만 여러행 함수로 SELECT에서 사용 가능
- ANSI JOIN

        SELECT employee_id, department_name
        FROM employees JOIN departments ON (Employees.manager_id = Departments.manager_id);
