DROP TABLE IF EXISTS autor CASCADE;
DROP TABLE IF EXISTS editora CASCADE;
DROP TABLE IF EXISTS livro CASCADE;

CREATE TABLE autor (
    id bigserial CONSTRAINT autor_pkey PRIMARY KEY,
    nome text
);

CREATE TABLE editora (
    id bigserial CONSTRAINT editora_pkey PRIMARY KEY,
    nome text
);

CREATE TABLE livro (
    id bigserial CONSTRAINT livro_pkey PRIMARY KEY,
    nome text,
    isbn text,
    volume text,
    data date,
    paginas int

);

ALTER TABLE livro ADD CONSTRAINT fk_livro_autor FOREIGN KEY (autor_id) 
      REFERENCES autor (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE livro ADD CONSTRAINT fk_livro_editora FOREIGN KEY (editora_id) 
      REFERENCES editora (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

