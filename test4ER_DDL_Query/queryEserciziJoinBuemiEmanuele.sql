USE ql;

-- ESERCIZI QUERY CON LE JOIN - "EMANUELE BUEMI"

-- Scrivi una query per trovare nome, cognome, lavoro, iD reparto dei dipendenti che lavorano a Londra ed estrarre 
-- anche il nome del reparto
SELECT e.first_name, e.last_name, e.department_id, j.job_title, l.city, d.department_name
FROM jobs j 
INNER JOIN employees e ON j.job_id = e.job_id
INNER JOIN departments d ON e.department_id = d.department_id
INNER JOIN locations l ON d.location_id = l.location_id
WHERE  l.city = 'London';

-- Scrivi una query per trovare l'id dipendente , il cognome (last_name) insieme al manager_id e al cognome (last_name)
SELECT e.employee_id, e.last_name AS cognome_dipendente, m.employee_id, m.last_name AS cognome_manager
FROM employees e
INNER JOIN employees m ON e.manager_id = m.employee_id;

-- Scrivi una query per visualizzare nome, cognome, data di assunzione, stipendio del manager per tutti i manager 
-- con esperienza superiore a 15 anni
SELECT e.first_name, e.last_name, e.hire_date, e.salary
FROM departments d 
INNER JOIN employees e ON d.manager_id = e.employee_id
WHERE datediff(curdate(), hire_date)/365>15;

-- Scrivi una query per trovare gli indirizzi (location_id, street_address, city, state_province, country-name) 
-- di tutti i dipartimenti.
SELECT l.location_id, l.street_address, l.city, l.state_province, c.country_name
FROM locations l
INNER JOIN countries c ON l.country_id = c.country_id;

-- Scrivi una query per visualizzare la cronologia del lavoro che è stata eseguita da qualsiasi dipendente 
-- che attualmente sta prelevando più di 10000 di stipendio
SELECT e.employee_id, e.first_name, e.last_name, e.salary, e.job_id, jh.start_date, jh.end_date
FROM employees e
INNER JOIN job_history jh ON e.employee_id = jh.employee_id
WHERE e.salary > 10000;