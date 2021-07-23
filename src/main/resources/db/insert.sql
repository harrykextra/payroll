truncate table employee cascade;

insert into employee(id, first_name, last_name, role)
values(12, 'Bobi', 'Wine', 'HR'),
      (13, 'Jane', 'Doe', 'Accountant')