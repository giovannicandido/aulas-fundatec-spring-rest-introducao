package br.org.fundatec.lp2.demorest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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
