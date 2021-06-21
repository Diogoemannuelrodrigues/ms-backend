package br.com.msprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msprodutos.entity.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Long>{

}
