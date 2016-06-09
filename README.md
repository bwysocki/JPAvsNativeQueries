# JPAvsNativeQueries
Comparison of 4 ways communication with db layer: JPA, Spring JDBCTemplate, Spring Data, jOOQ.

- Batch insert without relations - insert 10.000 records to single table (CRUD->createBatch). Database h2 (file). JPA ID -> @GeneratedValue(strategy = GenerationType.AUTO).

![alt tag](https://cloud.githubusercontent.com/assets/344261/15736757/41029164-28a2-11e6-980e-aed96be2fc6d.png)

- Batch insert without relations - insert 10.000 records to single table (CRUD->createBatch). Database PostgresSQL. JPA ID ->@SequenceGenerator(name = "car_type_id_seq", sequenceName="car_type_id_seq", allocationSize=1).

![alt tag](https://cloud.githubusercontent.com/assets/344261/15776275/e9ba429a-2986-11e6-8931-3d13c9b6677b.png)

- Batch insert to normal nad unlogged table (JDBC)

![alt tag](https://cloud.githubusercontent.com/assets/344261/15929675/ad52092e-2e4e-11e6-8ecd-c98150a8f4b5.png)

- Select with many to many and many to one relations.

![alt tag](https://cloud.githubusercontent.com/assets/344261/15846955/1d56dc96-2c82-11e6-902a-478471ebea2f.png)

- The same select as above but triggered as stored procedure (Postgres function). Used jooq version doesn't support stored procedures for Postgres.

![alt tag](https://cloud.githubusercontent.com/assets/344261/15857249/a69502b6-2cba-11e6-9a2f-977987585850.png)

- SQL operations (JDBC) on Postgres with different size of sharred_buffers parameter (1024MB vs 128MB).

![alt tag](https://cloud.githubusercontent.com/assets/344261/15920240/85c6cc2c-2e18-11e6-980c-a13e8aa44f1e.png)

- SQL JOIN operation with sorting on Postgres with different size of work_mem parameter.

SQL:
```sql
SELECT cl.name, cl.surname, c.id, c.registration_nr, c.production_year, ct.doors, ct.model, ct.available_year
FROM jpavsnative.car c INNER JOIN jpavsnative.car_type ct ON c.car_type = ct.id
INNER JOIN jpavsnative.car_client cc ON c.id = cc.car_id 
INNER JOIN jpavsnative.client cl ON cc.client_id = cl.id 
WHERE LOWER(c.registration_nr) LIKE '%25%' AND cl.surname LIKE '%23%'
ORDER BY name;
```

![alt tag](https://cloud.githubusercontent.com/assets/344261/15922523/650e8334-2e28-11e6-93c7-4d8a117bd2f0.png)

