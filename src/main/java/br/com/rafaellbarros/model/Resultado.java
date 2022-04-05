package br.com.rafaellbarros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 04/04/2022
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resultado {

    private String placa;
    private String chassi;
    private String categoria;
}
