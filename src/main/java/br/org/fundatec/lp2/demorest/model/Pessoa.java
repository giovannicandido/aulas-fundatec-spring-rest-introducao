package br.org.fundatec.lp2.demorest.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60, name = "nome")
    private String nome;
    private String sobrenome;
    private String cpf;
    private LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;
    public String getNome() {
        return nome;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public long getIdade(LocalDate dataNascimento) {
        if (this.dataNascimento == null) {
            return 0;
        }
        LocalDate now = LocalDate.now();
        long idade = ChronoUnit.YEARS.between(this.dataNascimento, now);
        return idade;
    }
}
