-- create package with function
CREATE OR REPLACE EDITIONABLE PACKAGE "XABLAU"."PKG_DEVELOPER" IS TYPE TCURSOR IS REF CURSOR;

   FUNCTION FNC_BUSCAR_TOTAL_CARROS_POR_CATEGORIA(P_CATEGORIA IN VARCHAR2) RETURN NUMBER;

   FUNCTION FNC_BUSCAR_TODOS_CARROS_POR_CATEGORIA(P_CATEGORIA IN VARCHAR2) RETURN TCURSOR;

END PKG_DEVELOPER;

CREATE OR REPLACE EDITIONABLE PACKAGE BODY "XABLAU"."PKG_DEVELOPER" IS

    FUNCTION FNC_BUSCAR_TOTAL_CARROS_POR_CATEGORIA(P_CATEGORIA IN VARCHAR2) RETURN NUMBER
    IS TOTAL_CARROS_CATEGORIA NUMBER (11,2);
    BEGIN
        SELECT COUNT(*) INTO TOTAL_CARROS_CATEGORIA
            FROM XABLAU.TB_CARRO tc INNER JOIN XABLAU.TB_MODELO tm
        ON tc.ID_MODELO  = tm.ID WHERE tm.CATEGORIA = P_CATEGORIA;
        RETURN(TOTAL_CARROS_CATEGORIA);
    END FNC_BUSCAR_TOTAL_CARROS_POR_CATEGORIA;

    FUNCTION FNC_BUSCAR_TODOS_CARROS_POR_CATEGORIA(P_CATEGORIA IN VARCHAR2) RETURN TCURSOR
    IS RETORNO TCURSOR;
    BEGIN
        OPEN RETORNO FOR
        SELECT tc.PLACA, tc.CHASSI, tm.CATEGORIA
            FROM XABLAU.TB_CARRO tc INNER JOIN XABLAU.TB_MODELO tm
        ON tc.ID_MODELO  = tm.ID WHERE tm.CATEGORIA = P_CATEGORIA;
        RETURN(RETORNO);
    END FNC_BUSCAR_TODOS_CARROS_POR_CATEGORIA;

END PKG_DEVELOPER;

-- EXECUTE FUNCTION EXAMPLE
SELECT XABLAU.PKG_DEVELOPER.FNC_BUSCAR_TOTAL_CARROS_POR_CATEGORIA('HATCH_MEDIO') FROM DUAL;

SET SERVEROUTPUT ON;
DECLARE
    result number;
BEGIN
	result := XABLAU.PKG_DEVELOPER.FNC_BUSCAR_TOTAL_CARROS_POR_CATEGORIA('HATCH_MEDIO');
    DBMS_OUTPUT.put_line (result);
END;


