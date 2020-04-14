package br.com.fatecmogidascruzes.core.impl.negocio;

import br.com.fatecmogidascruzes.core.impl.IStrategy;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableProduct;

public class ValidadorQtdEstoque implements IStrategy {

    @Override
    public String processar(IEntidade entidade) {

        if (entidade instanceof TableProduct) {
            TableProduct product = (TableProduct) entidade;

            if (product.getQuantity() < 1) {
                return "Quantidade deve ser no minimo 1!";
            }

        } else {
            return "Quantidade não pode ser validado, pois entidade não é um produto!";
        }

        return null;
    }

}
