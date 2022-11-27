package br.org.fundatec.lp2.demorest.repository;

import br.org.fundatec.lp2.demorest.model.Pessoa;

import java.util.List;

public interface PessoaRepository {
    List<Pessoa> listAll();

    void create(Pessoa pessoa);

    Pessoa findWithId(Long id);

    void edit(Long id, Pessoa pessoa);

    void deleteWithId(Long id);
}
