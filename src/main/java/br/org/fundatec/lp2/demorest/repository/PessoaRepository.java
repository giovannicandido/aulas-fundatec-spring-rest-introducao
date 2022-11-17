package br.org.fundatec.lp2.demorest.repository;

import br.org.fundatec.lp2.demorest.controller.PessoaIndex;
import br.org.fundatec.lp2.demorest.model.Pessoa;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaRepository {

    // Nosso banco é uma lista simples em memória
    private List<Pessoa> pessoas = new ArrayList<>();

    public List<Pessoa> listAll() {
        return pessoas;
    }

    public void create(Pessoa pessoa) {
        pessoa.setId(Long.valueOf(pessoas.size() + 1));
        pessoas.add(pessoa);
    }

    public Pessoa findById(Long id) {
        Optional<PessoaIndex> pessoaIndex = procurarPeloId(id);
        if(pessoaIndex.isEmpty()) {
            return null;
        }else {
            return pessoaIndex.get().getPessoa();
        }
    }

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

    public void deleteById(Long id) {
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
