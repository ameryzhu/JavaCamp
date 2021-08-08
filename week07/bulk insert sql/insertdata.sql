drop procedure if exists my_procedure;

delimiter
$$

CREATE procedure my_procedure()
BEGIN
 DECLARE
n int DEFAULT 1;
 WHILE
n < 1001 do
 insert into user(user_name,phone) values("Mason",192929929);
 set
n = n + 1;
end while;
END $$
　




-- drop table if exists foo;
-- create table foo
-- (
-- id int unsigned not null auto_increment primary key,
-- val smallint unsigned not null default 0
-- )
-- engine=innodb;

-- drop procedure if exists load_foo_test_data;

-- delimiter #
-- create procedure load_foo_test_data()
-- begin
-- declare v_max int unsigned default 10000;
-- declare v_counter int unsigned default 0;
--   truncate table foo;
--   start transaction;
--   while v_counter < v_max do
--     insert into foo (val) values ( floor(0 + (rand() * 65535)) );
--     set v_counter=v_counter+1;
--   end while;
--   commit;
-- end
-- delimiter ;

-- call load_foo_test_data();

-- select * from foo order by id;