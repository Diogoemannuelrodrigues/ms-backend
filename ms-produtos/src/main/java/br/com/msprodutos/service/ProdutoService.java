package br.com.msprodutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msprodutos.entity.Produto;
import br.com.msprodutos.repository.ProdutosRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutosRepository prod;
	
	public Produto buscarProduto(Long p) {
		Optional<Produto> produto = prod.findById(p);
		return produto.orElse(null);
	}
	
	public Produto salvarProduto (Produto produto) {
		return prod.save(produto);
	}
	
	public void deletarProduto(Long id) {
		prod.deleteById(id);
	}

	public Produto alterarProduto(Produto produto) {
		Optional<Produto> p = prod.findById(produto.getId()); 
		return prod.save(produto);
	}
	
	public List<Produto> listarProdutos(){
		List<Produto> pro = prod.findAll();
		return pro;
	}

}
