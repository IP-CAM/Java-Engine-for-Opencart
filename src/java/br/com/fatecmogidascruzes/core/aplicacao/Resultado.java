package br.com.fatecmogidascruzes.core.aplicacao;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.util.List;

public class Resultado extends EntidadeAplicacao {

    private Integer pageNumber;
    private Integer pageQuantity;
    private Integer itensQuantity;
    private boolean lastPage;
    private String msg;
    private List<EntidadeDominio> entidades;
    
    // Para botões de navegação html
    private Integer initialPage;
    private Integer finalPage;

    /**
     * Método de recuperação do campo msg
     *
     * @return valor do campo msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Valor de msg atribu�do a msg
     *
     * @param msg Atributo da Classe
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Método de recuperação do campo entidades
     *
     * @return valor do campo entidades
     */
    public List<EntidadeDominio> getEntidades() {
        System.out.println("\033[47m >>>>>>>>>>>>Resultado.getEntidades: " + entidades.getClass());
        return entidades;
    }

    /**
     * Valor de entidades atribu�do a entidades
     *
     * @param entidades Atributo da Classe
     */
    public void setEntidades(List<EntidadeDominio> entidades) {
        this.entidades = entidades;
    }
    
    public void setPageQuantity(Integer pageQuantity) {
        this.pageQuantity = pageQuantity;
    }

    public Integer getPageQuantity() {
        return pageQuantity;
    }

    public Integer getItensQuantity() {
        return itensQuantity;
    }

    public void setItensQuantity(Integer itensQuantity) {
        this.itensQuantity = itensQuantity;
    }
    
    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getInitialPage() {
        return initialPage;
    }

    public void setInitialPage(Integer initialPage) {
        this.initialPage = initialPage;
    }

    public Integer getFinalPage() {
        return finalPage;
    }

    public void setFinalPage(Integer finalPage) {
        this.finalPage = finalPage;
    }
    
}
