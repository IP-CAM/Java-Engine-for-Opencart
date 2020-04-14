
package br.com.fatecmogidascruzes.controle.web.command.impl;

import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import br.com.fatecmogidascruzes.domain.IEntidade;


public class DeleteCommand extends AbstractCommand{

    /**
     *
     * @param entidade
     * @return
     */
    @Override
	public Resultado execute(IEntidade entidade) {
		
		return fachada.delete((EntidadeDominio)entidade);
	}

}
