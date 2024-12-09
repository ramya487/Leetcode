# Write your MySQL query statement below
SELECT product_id, year first_year, quantity, price
FROM SALES
WHERE (PRODUCT_ID, YEAR) IN 
    (SELECT PRODUCT_ID, MIN(YEAR) FROM SALES GROUP BY 1);