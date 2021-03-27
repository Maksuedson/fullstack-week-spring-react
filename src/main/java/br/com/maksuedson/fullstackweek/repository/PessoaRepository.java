package br.com.maksuedson.fullstackweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maksuedson.fullstackweek.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
