package br.com.fatecmogidascruzes.core.impl;

import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;


public interface IFachada {

	public Resultado create(EntidadeDominio entidade);
        public Resultado findOneById(EntidadeDominio entidade);
        public Resultado findByName(EntidadeDominio entidade);
        public Resultado findByColumn(EntidadeDominio entidade);
        
        public Resultado findByPage(EntidadeDominio entidade);
        public Resultado findByDate(EntidadeDominio entidade);
        public Resultado findAllPage(EntidadeDominio entidade);
        public Resultado findAll(EntidadeDominio entidade);
	public Resultado visualizar(EntidadeDominio entidade);
	public Resultado update(EntidadeDominio entidade);
	public Resultado delete(EntidadeDominio entidade);
	
	
	
}