package br.com.fatecmogidascruzes.core.impl.negocio;


import br.com.fatecmogidascruzes.core.impl.IStrategy;
import br.com.fatecmogidascruzes.domain.IEntidade;
// import br.com.fatecmogidascruzes.domain.impl.Fornecedor;



public class ValidadorCnpj implements IStrategy {

	@Override
	public String processar(IEntidade entidade) {
	/*	
		if(entidade instanceof Fornecedor){
			Fornecedor fornecedor = (Fornecedor)entidade;
			
                        String cnpj = String.valueOf(fornecedor.getCnpj());
			if(cnpj.length() < 14){
				return "CNPJ deve conter 14 digitos!";
			}
			
		}else{
			return "CNPJ não pode ser validado, pois entidade não é um fornecedor!";
		}
		
	*/	
		return null;
	}

}
