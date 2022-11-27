package br.org.fundatec.lp2.demorest.service;

import br.org.fundatec.lp2.demorest.model.Pessoa;
import br.org.fundatec.lp2.demorest.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listAll() {
        return pessoaRepository.listAll();
    }

    public void create(Pessoa pessoa) {
        pessoaRepository.create(pessoa);
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findWithId(id);
    }

    public void edit(Long id, Pessoa pessoa) {
       pessoaRepository.edit(id, pessoa);
    }

    public void deleteById(Long id) {
        pessoaRepository.deleteWithId(id);
    }
}
