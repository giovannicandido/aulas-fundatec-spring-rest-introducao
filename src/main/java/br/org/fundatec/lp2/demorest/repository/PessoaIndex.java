package br.org.fundatec.lp2.demorest.repository;

import br.org.fundatec.lp2.demorest.model.Pessoa;

public class PessoaIndex {
    private final int index;
    private final Pessoa pessoa;

    public PessoaIndex(int index, Pessoa pessoa) {
        this.index = index;
        this.pessoa = pessoa;
    }

    public int getIndex() {
        return index;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}
