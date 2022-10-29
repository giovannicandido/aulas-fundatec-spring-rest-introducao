package br.org.fundatec.lp2.demorest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pessoa {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public long getIdade() {
        if (this.dataNascimento == null) {
            return 0;
        }
        LocalDate now = LocalDate.now();
        long idade = ChronoUnit.YEARS.between(this.dataNascimento, now);
        return idade;
    }
}
