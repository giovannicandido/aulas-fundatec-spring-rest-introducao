package br.org.fundatec.lp2.demorest.controller;

import br.org.fundatec.lp2.demorest.model.Pessoa;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PessoaCtrlTest {

    @Test
    @Disabled
    void procurarPeloId() {
        PessoaCtrl pessoaCtrl = new PessoaCtrl();
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Giovanni");
        pessoaCtrl.criarPessoa(pessoa);

//        Optional<PessoaIndex> pessoaIndex = pessoaCtrl.procurarPorId(0L);
//        assertThat(pessoaIndex).isEmpty();
    }

    @Test
    @Disabled
    void procurarPeloIdExiste() {
//        PessoaCtrl pessoaCtrl = new PessoaCtrl(pessoaRepository);
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Giovanni");
//        pessoaCtrl.criarPessoa(pessoa);

//        Optional<PessoaIndex> pessoaIndex = pessoaCtrl.procurarPeloId(1L);
//        assertThat(pessoaIndex).isNotEmpty();
//        assertThat(pessoaIndex.get().getIndex()).isEqualTo(0);
//        assertThat(pessoaIndex.get().getPessoa().getNome()).isEqualTo("Giovanni")
    }
}