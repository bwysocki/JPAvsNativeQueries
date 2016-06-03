# JPAvsNativeQueries
Comparison of 4 ways communication with db layer: JPA, Spring JDBCTemplate, Spring Data, jOOQ.

1. Batch insert without relations - insert 10.000 records to single table (CRUD->createBatch). Database h2 (file). JPA ID -> @GeneratedValue(strategy = GenerationType.AUTO).

![alt tag](https://cloud.githubusercontent.com/assets/344261/15736757/41029164-28a2-11e6-980e-aed96be2fc6d.png)

2. Batch insert without relations - insert 10.000 records to single table (CRUD->createBatch). Database PostgresSQL. JPA ID ->@SequenceGenerator(name = "car_type_id_seq", sequenceName="car_type_id_seq", allocationSize=1).

![alt tag](https://cloud.githubusercontent.com/assets/344261/15776275/e9ba429a-2986-11e6-8931-3d13c9b6677b.png)