package br.com.fatecmogidascruzes.core.impl;

import br.com.fatecmogidascruzes.domain.IEntidade;

public interface IStrategy {

    public String processar(IEntidade entidade);

}
