select Distinct b.contest_id, round(count(b.contest_id)*100/ (select count(distinct user_id) from Users ), 2) as percentage from Register b right join Users a on a.user_id = b.user_id 
where b.contest_id is not null
group by b.contest_id
order by percentage desc , b.contest_id