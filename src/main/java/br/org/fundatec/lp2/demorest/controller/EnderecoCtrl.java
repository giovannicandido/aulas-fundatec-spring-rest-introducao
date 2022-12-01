package br.org.fundatec.lp2.demorest.controller;

import br.org.fundatec.lp2.demorest.model.Endereco;
import br.org.fundatec.lp2.demorest.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/endereco")
public class EnderecoCtrl {
    private final EnderecoService service;

    public EnderecoCtrl(EnderecoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Endereco> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity createNew(@RequestBody Endereco endereco) {
        service.save(endereco);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/search")
    public List<Endereco> search(@RequestParam("rua") String rua) {
        return service.findByRua(rua);
    }
}
