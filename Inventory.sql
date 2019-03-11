
create table inventory (itemID int, itemName varchar(20), itemCompany varchar(20), itemCategory varchar(20), itemPrice long);

insert into inventory values(1, 'Galaxy S9', 'Samsung', 'Smartphones', 1000);
insert into inventory values(2, 'Galaxy Fold', 'Samsung', 'Smartphones', 2000);
insert into inventory values(3, '27 ES FHD', 'HP', 'Monitors', 300);
insert into inventory values(4, 'iPhone XS', 'Apple', 'Smartphones', 1800);
insert into inventory values(5, 'Charge 4', 'JBL', 'Speakers', 200);
insert into inventory values(6, 'Infinity Display 65', 'LG', 'Monitors', 5000);
insert into inventory values(7, 'Mate 20 Pro', 'Huawei', 'Smartphones', 1500);
insert into inventory values(8, 'Megaboom', 'Ultimate Ears', 'Speakers', 300);
insert into inventory values(9, 'SoundSport Wireless', 'Bose', 'Earphones', 140);
insert into inventory values(10, 'All-in-One PC', 'Dell', 'Desktops', 800);
insert into inventory values(11, 'Macbook Pro', 'Apple', 'Laptops', 3000);
insert into inventory values(12, '44 Quad HD', 'Asus', 'Monitors', 500);

select * from inventory;

select count(itemName) from inventory group by itemCompany;
select * from inventory where itemCategory = 'Speakers';



