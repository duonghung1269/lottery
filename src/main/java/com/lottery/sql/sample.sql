-- check winner (check full line)
select ticket_id, count(*) 
from lottery.ticket_numbers
where number_row1 in (2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,15, 16, 17, 18, 19, 20, 21, 22, 23)
	  or number_row1 in (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,15, 16, 17, 18, 19, 20, 21, 22, 23)
group by ticket_id
having count(*) = 8

-- check generated line is duplicated in database or not
select count(*)
from ticket
where first_line = "1 4 7 10 13 16 19 22" or second_line = "1 4 7 10 13 16 19 22" or third_line = "1 4 7 10 13 16 19 22"