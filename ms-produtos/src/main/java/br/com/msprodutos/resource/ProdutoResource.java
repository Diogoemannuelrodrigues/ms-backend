package br.com.msprodutos.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.msprodutos.entity.Produto;
import br.com.msprodutos.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtosService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> produtos = produtosService.listarProdutos();
		return ResponseEntity.ok(produtos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto produto = produtosService.buscarProduto(id);
		return ResponseEntity.ok(produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> createProduto(@RequestBody Produto prod){
		Produto produto = produtosService.salvarProduto(prod);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(produto.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	

}
