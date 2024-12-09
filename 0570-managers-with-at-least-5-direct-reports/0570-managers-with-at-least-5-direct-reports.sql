# Write your MySQL query statement below
SELECT A.name
from Employee A
JOIN Employee B ON A.id = B.managerId
GROUP BY B . managerId
HAVING COUNT(*)>= 5 ;