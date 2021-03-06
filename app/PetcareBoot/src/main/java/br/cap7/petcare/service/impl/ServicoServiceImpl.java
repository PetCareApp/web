package br.cap7.petcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cap7.petcare.model.Servico;
import br.cap7.petcare.model.TipoServico;
import br.cap7.petcare.repository.ServicoRepository;
import br.cap7.petcare.repository.TipoServicoRepository;
import br.cap7.petcare.service.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService {
	
	@Autowired
	private TipoServicoRepository tipoServicoRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;

	@Override
	public List<TipoServico> getAllTipoServico() {
		return tipoServicoRepository.findAll();
	}

	@Override
	public void cadastrar(TipoServico tipoServico) {
		if (tipoServicoRepository.findByNomeIgnoreCase(tipoServico.getNome()) == null) {
			tipoServicoRepository.save(tipoServico);
		}
	}

	@Override
	public void cadastrar(Servico servico) {
		servicoRepository.save(servico);
	}

	@Override
	public void excluir(TipoServico tipoServico) {
		tipoServicoRepository.delete(tipoServico);
	}

	@Override
	public void excluir(Servico servico) {
		servicoRepository.delete(servico);
	}

	@Override
	public void atualizar(Servico servico) {
		servicoRepository.save(servico);
	}

}
