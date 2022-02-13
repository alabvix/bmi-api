DROP TABLE IF EXISTS bmi;

CREATE TABLE bmi (
   id UUID NOT NULL,
   user_id UUID NOT NULL,
   date DATE NOT NULL,
   value NUMERIC(10,2),
   rate VARCHAR(10)
);

DROP TABLE IF EXISTS user;

CREATE TABLE user (
   id UUID NOT NULL,
   name VARCHAR(50) NOT NULL,
   email VARCHAR(20) NOT NULL,
   height NUMERIC(10,2),
   weight NUMERIC(10,2),
   age SMALLINT
);

INSERT INTO USER (id, name, email, height, weight, age) VALUES
  ('3930f3f2-8b36-11ec-a8a3-0242ac120002', 'user1', 'user1@test.com', 1.70, 80.00, 27),
  ('5ad40044-8b36-11ec-a8a3-0242ac120002', 'user2', 'user2@test.com', 1.65, 65.00, 12);