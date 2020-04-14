
package br.com.fatecmogidascruzes.controle.web.command;

import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;


public interface IComando {

    public Resultado execute(IEntidade entidade);
	
}
