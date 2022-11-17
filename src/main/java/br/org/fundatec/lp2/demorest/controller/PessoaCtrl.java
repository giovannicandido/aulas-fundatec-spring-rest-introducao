package br.org.fundatec.lp2.demorest.controller;

import br.org.fundatec.lp2.demorest.model.Pessoa;
import br.org.fundatec.lp2.demorest.repository.PessoaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller // Instrui o spring a criar um controlador
@RequestMapping("/api/pessoa") // URL base para o controlador
public class PessoaCtrl {

    private final PessoaRepository pessoaRepository;

    public PessoaCtrl() {
        this.pessoaRepository = new PessoaRepository();
    }

    /**
     * Retorna todas as pessoas
     * Navegador envia um GET na url /api/pessoa
     * @return Lista de pessoas em JSON (@ResponseBody)
     */
    @RequestMapping(method = RequestMethod.GET) // Instrui o spring para cair nesse method nessa URL + Verbo
    @ResponseBody
    public List<Pessoa> buscaPessoas() {
        return pessoaRepository.listAll();
    }

    /**
     * Cria uma pessoa no banco
     * @param pessoa Pessoa em JSON no corpo da requisição (@RequestBody)
     * @return OK se criou com sucesso (CODIGO 200)
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity criarPessoa(@RequestBody Pessoa pessoa) {
        pessoaRepository.create(pessoa);
        return ResponseEntity.ok().build();
    }

    /**
     * Deleta uma pessoa pelo seu ID
     * @param id ID enviado na URL (@PathVariable)
     * @return OK se deletou a pessoa com sucesso. NOTFOUND (404) se não achou a pessoa
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deletetarPessoa(@PathVariable("id") Long id) {

        Pessoa pessoa = pessoaRepository.findById(id);
        if(pessoa != null) {
            pessoaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Editar uma pessoa pelo id se achar, caso pessoa não exister retorna NOT_FOUND
     * @param id Id da pessoa na URL (@PathVariable)
     * @param pessoa Pessoa para ser editata (JSON com @RequestBody)
     * @return OK ou NOT_FOUND
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity editarPessoa(@PathVariable("id") Long id,
                                       @RequestBody Pessoa pessoa) {
        Pessoa pessoaExiste = pessoaRepository.findById(id);
        if(pessoaExiste != null) {
            pessoaRepository.edit(id, pessoa);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Procura uma pessoa pelo seu id passado na URL
     * @param id ID passado na URL
     * @return OK ou NOT_FOUND
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity procurarPorId(@PathVariable("id") Long id) {
        Pessoa pessoa = pessoaRepository.findById(id);
        if(pessoa != null) {
            return ResponseEntity.ok(pessoa);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
