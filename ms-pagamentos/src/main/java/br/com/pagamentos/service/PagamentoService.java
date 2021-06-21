package br.com.pagamentos.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.pagamentos.entity.Pagamento;
import br.com.pagamentos.entity.Produto;

@Service
public class PagamentoService {

	@Value("${ms-produtos.host}")
	private String ms_produto;
	
	@Autowired
	private RestTemplate restTemplate;

	public Pagamento getPagamento(Long produtoId, Double valorDesconto) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", "" + produtoId);

		Produto produto = restTemplate.getForObject(ms_produto + "/produtos/{id}", Produto.class, uriVariables);
		return new Pagamento(produto.getNome(), produto.getPreco(),valorDesconto);
	}
}
