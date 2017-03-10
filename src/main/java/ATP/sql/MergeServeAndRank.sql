alter table top100 alter column Ranking int;

select * from top100 t inner join servestats s
on s.Player = t.Player
order by t.Ranking asc