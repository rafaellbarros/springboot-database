--------------------------------------------------------
--  DDL for Table tb_carro
--------------------------------------------------------

CREATE TABLE xablau.tb_carro
(
    id NUMBER GENERATED BY DEFAULT AS IDENTITY,
    chassi VARCHAR(17) NOT NULL,
    cor VARCHAR(100) NOT NULL,
    placa VARCHAR(7) NOT NULL,
    id_modelo INT NOT NULL CONSTRAINT fk_modelo_carro REFERENCES xablau.tb_modelo(id),
    PRIMARY KEY (id)
);

COMMENT ON TABLE xablau.tb_carro IS 'Registros de carros';
COMMENT ON COLUMN xablau.tb_carro.id IS 'Id de identificacão do carro';
COMMENT ON COLUMN xablau.tb_carro.chassi IS 'Chassi do carro';
COMMENT ON COLUMN xablau.tb_carro.cor IS 'Cor do carro';
COMMENT ON COLUMN xablau.tb_carro.placa IS 'Placa do carro';
COMMENT ON COLUMN xablau.tb_carro.id_modelo IS 'Id de identificacão do modelo, chave estrangeira para xablau.tb_modelo';

--------------------------------------------------------
--  DML for Table tb_carro
--------------------------------------------------------

INSERT INTO xablau.tb_carro VALUES (1, '7j8K68AkVe1dA0443','Prata','PAQ4I81', 3);
INSERT INTO xablau.tb_carro VALUES (2, '8306wdLBnVAYH7844','Branco', 'PAQ4I82', 3);
INSERT INTO xablau.tb_carro VALUES (3, '4zyA1sG80D2K43691','Preto', 'PAQ4I83', 3);
INSERT INTO xablau.tb_carro VALUES (4, '78A3Ny9srAa9T0619','Prata', 'PAQ4I84', 3);
INSERT INTO xablau.tb_carro VALUES (5, '7Kz0zgLUP08r12656','Branco', 'PAQ4I85', 3);