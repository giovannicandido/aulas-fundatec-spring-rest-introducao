package br.org.fundatec.lp2.demorest.repository;

import br.org.fundatec.lp2.demorest.model.Pessoa;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Primary
public interface PessoaRepositorySpring extends JpaRepository<Pessoa, Long>, PessoaRepository {
    @Override
    default List<Pessoa> listAll() {
        return findAll();
    }

    @Override
    default void create(Pessoa pessoa) {
        save(pessoa);
    }

    @Override
    default void edit(Long id, Pessoa pessoa) {
        pessoa.setId(id);
        save(pessoa);
    }

    @Override
    default Pessoa findWithId(Long id) {
        return getReferenceById(id);
    }

    @Override
    default void deleteWithId(Long id) {
       deleteById(id);
    }
}
