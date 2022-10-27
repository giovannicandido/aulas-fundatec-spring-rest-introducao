package br.org.fundatec.lp2.demorest.controller;

import br.org.fundatec.lp2.demorest.model.Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller // Instrui o spring a criar um controlador
public class HelloWorldCtrl {

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
        List pessoas = new ArrayList();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Giovanni");
        pessoa.setSobrenome("Silva");
        pessoa.setCpf("000000");
        pessoa.setDataNascimento(LocalDate.of(1988, 3, 7));
        pessoas.add(pessoa);
        return pessoas;
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
