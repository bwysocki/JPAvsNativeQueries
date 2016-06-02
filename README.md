# JPAvsNativeQueries
Comparison of 4 ways to db layer access: JPA, Spring JDBCTemplate, Spring Data, jOOQ.

1. Batch insert without relations - insert 10.000 records to single table (CRUD->createBatch).

![alt tag](https://raw.githubusercontent.com/bwysocki/JPAvsNativeQueries/img/1.png)