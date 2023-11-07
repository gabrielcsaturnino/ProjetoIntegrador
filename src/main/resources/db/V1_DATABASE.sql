/* Lógico_1: */

CREATE TABLE FUNCIONARIO (
                             CARGO VARCHAR,
                             CPF VARCHAR PRIMARY KEY,
                             NOME VARCHAR,
                             CONTRATO VARCHAR,
                             DATA_ADMISSAO DATE,
                             RG VARCHAR,
                             DEPARTAMENTO VARCHAR,
                             SALARIO_HORA VARCHAR
);

CREATE TABLE FOLHA_PONTO (
                             DATA DATE,
                             HORA_ENTRADA TIME,
                             HORA_SAIDA TIME,
                             TOTAL_HORAS_TRABALHADAS INTEGER,
                             HORA_EXTRA INTEGER,
                             FALTAS INTEGER,
                             FK_FUNCIONARIO_CPF VARCHAR
);

CREATE TABLE BENEFICIO (
                           CUSTO FLOAT,
                           NOME VARCHAR,
                           TIPO VARCHAR,
                           DATA_TERMINO DATE,
                           COD NUMERIC PRIMARY KEY,
                           STATUS VARCHAR,
                           FK_FUNCIONARIO_CPF VARCHAR
);

CREATE TABLE AVALIACAO_DESEMPENHO (
                                      DESCRICAO VARCHAR,
                                      DATA DATE,
                                      ID NUMERIC PRIMARY KEY,
                                      PONTUACAO INTEGER,
                                      FK_FUNCIONARIO_CPF VARCHAR
);

CREATE TABLE TREINAMENTO (
                             NOME VARCHAR,
                             TIPO VARCHAR,
                             PRIORIDADE VARCHAR,
                             ID NUMERIC PRIMARY KEY
);

CREATE TABLE LICENCA (
                         DATA_VALIDADE DATE,
                         DATA_EMISSAO DATE,
                         TIPO VARCHAR,
                         STATUS VARCHAR,
                         ID NUMERIC PRIMARY KEY,
                         FK_FUNCIONARIO_CPF VARCHAR
);

CREATE TABLE AVALIACAO_DESEMPENHO_TREINAMENTO (
    FK_AVALIACAO_DESEMPENHO_ID NUMERIC
);

ALTER TABLE FOLHA_PONTO ADD CONSTRAINT FK_FOLHA_PONTO_1
    FOREIGN KEY (FK_FUNCIONARIO_CPF)
        REFERENCES FUNCIONARIO (CPF)
        ON DELETE CASCADE;

ALTER TABLE BENEFICIO ADD CONSTRAINT FK_BENEFICIO_2
    FOREIGN KEY (FK_FUNCIONARIO_CPF)
        REFERENCES FUNCIONARIO (CPF)
        ON DELETE CASCADE;

ALTER TABLE AVALIACAO_DESEMPENHO ADD CONSTRAINT FK_AVALIACAO_DESEMPENHO_2
    FOREIGN KEY (FK_FUNCIONARIO_CPF)
        REFERENCES FUNCIONARIO (CPF)
        ON DELETE CASCADE;

ALTER TABLE LICENCA ADD CONSTRAINT FK_LICENCA_2
    FOREIGN KEY (FK_FUNCIONARIO_CPF)
        REFERENCES FUNCIONARIO (CPF)
        ON DELETE CASCADE;

ALTER TABLE AVALIACAO_DESEMPENHO_TREINAMENTO ADD CONSTRAINT FK_AVALIACAO_DESEMPENHO_TREINAMENTO_1
    FOREIGN KEY (FK_AVALIACAO_DESEMPENHO_ID)
        REFERENCES AVALIACAO_DESEMPENHO (ID)
        ON DELETE RESTRICT;