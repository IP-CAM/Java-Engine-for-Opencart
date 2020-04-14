
package br.com.fatecmogidascruzes.controle.web.command.impl;

import br.com.fatecmogidascruzes.controle.web.command.IComando;
import br.com.fatecmogidascruzes.core.impl.IFachada;
import br.com.fatecmogidascruzes.core.impl.controle.Fachada;


public abstract class AbstractCommand implements IComando {

	protected IFachada fachada = new Fachada();

}
