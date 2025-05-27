package br.edu.uftpr.cp.espjava.crud_cidades.cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CidadeRepository extends JpaRepository<CidadeEntidade, Long> {

    public Optional<CidadeEntidade> findByNomeAndEstado(String nome, String estado);
}
