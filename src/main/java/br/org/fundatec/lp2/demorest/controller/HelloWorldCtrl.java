package br.org.fundatec.lp2.demorest.controller;

import br.org.fundatec.lp2.demorest.model.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller // Instrui o spring a criar um controlador
@RequestMapping("/api")
public class HelloWorldCtrl {
    private List<Pessoa> pessoas = new ArrayList();

    @PostConstruct
    private void init() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Giovanni");
        pessoa.setSobrenome("Silva");
        pessoa.setCpf("000000");
        pessoa.setDataNascimento(LocalDate.of(1988, 3, 7));
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setId(2L);
        pessoa2.setNome("Fulano");
        pessoa2.setSobrenome("Sobrenome");
        pessoa2.setCpf("000000");
        pessoa2.setDataNascimento(LocalDate.of(1990, 3, 7));

        pessoas.add(pessoa);
        pessoas.add(pessoa2);
    }


    @RequestMapping(path = "/", method = RequestMethod.GET) // Mapeia uma Url para cair no metodo abaixo
    @ResponseBody // o retorno do metodo vai ser serializado para o corpo da resposta http
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping(path = "/hello/{nome}", method = RequestMethod.GET)
    @ResponseBody
    public String sayHelloName(@PathVariable(name = "nome") String name) {
        return "Hello World " + name;
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHelloNameSobrenome(@RequestParam(name = "nome") String name,
                               @RequestParam("sobrenome") String sobrenome) {
        return "Hello World " + name + " / " + sobrenome;
    }

    @RequestMapping(path = "/pessoa", method = RequestMethod.GET)
    @ResponseBody
    public List<Pessoa> buscaPessoas() {
        return pessoas;
    }

    @RequestMapping(path = "/pessoa", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity salvarPessoa(@RequestBody Pessoa pessoa) {
        pessoa.setId(this.pessoas.stream().count() + 1);
        pessoas.add(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(path = "/pessoa/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        pessoas.stream().filter(p -> p.getId().equals(id)).findFirst()
                .ifPresent(p -> {
                    p.setCpf(pessoa.getCpf());
                    p.setNome(pessoa.getNome());
                    p.setSobrenome(pessoa.getSobrenome());
                    p.setDataNascimento(pessoa.getDataNascimento());
                });
        boolean exists = pessoas.stream().anyMatch(p -> p.getId().equals(id));
        if (exists) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(path = "/pessoa/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deletePessoa(@PathVariable Long id) {
        int index = -1;
        for(int iter = 0; iter < pessoas.size(); iter++) {
            Pessoa p = pessoas.get(iter);
            if(p.getId().equals(id)) {
                index = iter;
                break;
            }
        }
        if(index != -1) {
            pessoas.remove(index);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Exemplo de retorno para arquivo html de template
     * É necessário ter um template engine configurado. No arquivo pom.xml configuramos o thymeleaf como engine
     * @return O nome do arquivo a ser carregado na pasta resources/templates
     */
    @RequestMapping(path = "/html", method = RequestMethod.GET)
    public String getTestHtml() {
        return "test";
    }
}
