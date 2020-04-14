package br.com.fatecmogidascruzes.controle.web.json;

import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface  IJsonService {
	
    public IEntidade getEntidade(HttpServletRequest request);
 
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException;

}
