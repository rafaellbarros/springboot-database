package br.com.rafaellbarros.controller;

import br.com.rafaellbarros.service.DevService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 04/04/2022
 */
@RestController
@RequestMapping("dev")
@RequiredArgsConstructor
public class DevController {

    private final DevService service;

    @GetMapping("/{categoria}")
    public ResponseEntity<?> dev(@PathVariable final String categoria) throws SQLException {
        return ResponseEntity.ok(service.dev(categoria));
    }

}
