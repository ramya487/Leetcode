-- Write your PostgreSQL query statement below
WITH temp as (SELECT product_id, MIN(year) as first_year FROM Sales GROUP BY product_id)

SELECT s.product_id,s.year as first_year, s.quantity,s.price 
FROM Sales s 
WHERE (s.product_id,s.year) IN (SELECT product_id,first_year FROM temp)