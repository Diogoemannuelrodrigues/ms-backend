package br.com.pagamentos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pagamentos.entity.Pagamento;
import br.com.pagamentos.service.PagamentoService;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoResource {

	@Autowired
	private PagamentoService pagService;

	@GetMapping(value = "/{produtoId}/valor/{valor}")
	public ResponseEntity<Pagamento> getPagamento(@PathVariable Long produtoId, @PathVariable Double valor) {
		Pagamento pagamento = pagService.getPagamento(produtoId, valor);
		return ResponseEntity.ok(pagamento);
	}

}
