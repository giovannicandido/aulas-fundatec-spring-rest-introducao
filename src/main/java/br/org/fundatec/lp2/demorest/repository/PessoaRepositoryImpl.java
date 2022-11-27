package br.org.fundatec.lp2.demorest.repository;

import br.org.fundatec.lp2.demorest.model.Pessoa;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository {

    // Nosso banco é uma lista simples em memória
    private List<Pessoa> pessoas = new ArrayList<>();

    @Override
    public List<Pessoa> listAll() {
        return pessoas;
    }

    @Override
    public void create(Pessoa pessoa) {
        pessoa.setId(Long.valueOf(pessoas.size() + 1));
        pessoas.add(pessoa);
    }

    @Override
    public Pessoa findWithId(Long id) {
        Optional<PessoaIndex> pessoaIndex = procurarPeloId(id);
        if(pessoaIndex.isEmpty()) {
            return null;
        }else {
            return pessoaIndex.get().getPessoa();
        }
    }

    @Override
    public void edit(Long id, Pessoa pessoa) {
        int index = -1;
        for(int iter = 0;iter < pessoas.size();iter++) {
            Pessoa encontrou = pessoas.get(iter);
            if(id.equals(encontrou.getId())) {
                index = iter;
                break;
            }
        }

        if(index != -1) {
            Pessoa achada = pessoas.get(index);
            pessoa.setId(achada.getId());
            pessoas.set(index, pessoa);

        }
    }

    @Override
    public void deleteWithId(Long id) {
        // TODO refatorar para usar o metodo privado procurarPeloId
        int index = -1;
        for(int iter = 0;iter < pessoas.size();iter++) {
            Pessoa encontrou = pessoas.get(iter);
            if(id.equals(encontrou.getId())) {
                index = iter;
                break;
            }
        }


        if(index > -1) {
            pessoas.remove(index);
        }
    }

    /**
     * Função auxilixar parar procurar uma pessoa na lista
     * @param id Id da pessoa a procurar
     * @return Um opcional contendo a pessoa e o indice de onde está na lista
     */
    private Optional<PessoaIndex> procurarPeloId(Long id) {
        int index = -1;
        for(int iter = 0;iter < pessoas.size();iter++) {
            Pessoa encontrou = pessoas.get(iter);
            if(id.equals(encontrou.getId())) {
                index = iter;
                break;
            }
        }

        if(index != -1) {
            return Optional.of(new PessoaIndex(index, pessoas.get(index)));
        }else {
            return Optional.empty();
        }
    }
}
