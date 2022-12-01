package br.org.fundatec.lp2.demorest.repository;

import br.org.fundatec.lp2.demorest.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("select e from Endereco e where e.rua like :rua")
    List<Endereco> findByRuaLike(@Param("rua") String rua);
}
