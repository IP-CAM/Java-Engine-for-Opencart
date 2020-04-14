package br.com.fatecmogidascruzes.controle.web.vh;

import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public interface  IViewHelper {
	
    public IEntidade getEntidade(HttpServletRequest request);

    /**
     *
     * @param resultado
     * @param request
     * @param response
     * @throws ServletException
     */
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)throws ServletException;

    

}
