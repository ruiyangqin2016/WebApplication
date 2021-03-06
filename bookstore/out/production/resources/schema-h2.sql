CREATE TABLE public.bookstore_user(
  id       INTEGER PRIMARY KEY,
  username CHARACTER VARYING,
  password CHARACTER VARYING,
  is_admin BOOLEAN
);

DROP SEQUENCE public.bookstore_user_id_seq;

CREATE SEQUENCE public.bookstore_user_id_seq
INCREMENT BY 100
   MINVALUE 1
   MAXVALUE 928398324798324
START 1
CACHE 100;




CREATE TABLE public.book(
  book_id INTEGER PRIMARY KEY,
  title CHARACTER VARYING,
  isbn CHARACTER VARYING,
  author CHARACTER VARYING,
  date_published TIMESTAMP,
  genre CHARACTER VARYING,
  price DOUBLE
);

DROP SEQUENCE public.book_id_seq;

CREATE SEQUENCE public.book_id_seq
INCREMENT BY 100
  MINVALUE 1
  MAXVALUE 928398324798324
START 1
CACHE 100;