package br.org.fundatec.lp2.demorest.service;

import br.org.fundatec.lp2.demorest.model.Endereco;
import br.org.fundatec.lp2.demorest.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public List<Endereco> findAll() {
        return repository.findAll();
    }

    public void save(Endereco endereco) {
        repository.save(endereco);
    }

    public Optional<Endereco> findById(Long id) {
        return repository.findById(id);
    }
    public List<Endereco> findByRua(String rua) {
        return repository.findByRuaLike(rua);
    }
}
