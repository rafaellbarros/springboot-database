package br.com.rafaellbarros.service;

import br.com.rafaellbarros.model.Resultado;
import br.com.rafaellbarros.repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleTypes;
import org.hibernate.internal.SessionImpl;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 04/04/2022
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class DevService {

    private final CarroRepository carroRepository;

    private final EntityManager entityManager;

    protected Connection getConnection() {
        return entityManager.unwrap(SessionImpl.class).connection();
    }

    @Transactional
    public List<Resultado> dev(String categoria) throws SQLException {

        final List<Resultado> resultados = new ArrayList<>();

        try (CallableStatement stmt = getConnection().prepareCall("{ ? = call XABLAU.PKG_DEVELOPER" +
                ".FNC_BUSCAR_TODOS_CARROS_POR_CATEGORIA(?) }")) {
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.setString(2, categoria);
            stmt.executeUpdate();
            ResultSet rs = (ResultSet) stmt.getObject(1);


            while (rs.next()) {
                final Resultado resultado = new Resultado();
                resultado.setPlaca(rs.getString("placa"));
                resultado.setChassi(rs.getString("chassi"));
                resultado.setCategoria(rs.getString("categoria"));
                resultados.add(resultado);
            }

        } catch (SQLException e) {
            log.error("Erro executar a function: {}", e.getMessage());
            e.printStackTrace();
        }
        return resultados;
    }
}
