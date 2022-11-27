package br.org.fundatec.lp2.demorest.repository;

import br.org.fundatec.lp2.demorest.model.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaRepositoryImplSring  implements PessoaRepository{
    private final PessoaRepositorySpring pessoaRepositorySpring;

    public PessoaRepositoryImplSring(PessoaRepositorySpring pessoaRepositorySpring) {
        this.pessoaRepositorySpring = pessoaRepositorySpring;
    }

    @Override
    public List<Pessoa> listAll() {
        return (List<Pessoa>) pessoaRepositorySpring.findAll();
    }

    @Override
    public void create(Pessoa pessoa) {
        pessoaRepositorySpring.save(pessoa);
    }

    @Override
    public Pessoa findWithId(Long id) {
        return pessoaRepositorySpring.getReferenceById(id);
    }

    @Override
    public void edit(Long id, Pessoa pessoa) {
        pessoa.setId(id);
        pessoaRepositorySpring.save(pessoa);
    }

    @Override
    public void deleteWithId(Long id) {
        pessoaRepositorySpring.deleteById(id);
    }
}
