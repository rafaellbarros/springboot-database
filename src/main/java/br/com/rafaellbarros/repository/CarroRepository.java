package br.com.rafaellbarros.repository;

import br.com.rafaellbarros.model.Resultado;
import br.com.rafaellbarros.model.entity.Carro;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 04/04/2022
 */

public interface CarroRepository extends CrudRepository<Carro, Long> {

    @Query(nativeQuery = true, value = "SELECT XABLAU.PKG_DEVELOPER.FNC_BUSCAR_TODOS_CARROS_POR_CATEGORIA(:categoria) FROM DUAL")
    Object buscarTodosOsCarrosPorcategoria(@Param("categoria") String categoria);

    @Modifying
    @Query(value ="CALL XABLAU.PKG_DEVELOPER.FNC_BUSCAR_TODOS_CARROS_POR_CATEGORIA(:categoria);", nativeQuery = true)
    List<Object[]> buscarTodos(@Param("categoria") String categoria);
}
