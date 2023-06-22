package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class ImovelNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public ImovelNaoEncontradoException(String message) {
		super(message);
		
	}
	
	public ImovelNaoEncontradoException(Long id) {
		this(String.format("O imóvel de código %d não existe", id));
	}

	
}
