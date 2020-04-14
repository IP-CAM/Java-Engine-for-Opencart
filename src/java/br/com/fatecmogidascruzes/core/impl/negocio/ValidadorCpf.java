package br.com.fatecmogidascruzes.core.impl.negocio;

import br.com.fatecmogidascruzes.core.impl.IStrategy;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.IEntidade;

public class ValidadorCpf implements IStrategy {

    @Override
    public String processar(IEntidade entidade) {

        if (entidade instanceof TableCustomer) {
            
            TableCustomer customer = (TableCustomer) entidade;
            
            String customerCpf = String.valueOf(customer.getCpf());
            // Verifica se tem dígitos à mais:
            if(customerCpf.length() <= 11){
                //Converte número Long para String e preencher com zeros à esquerda:

                while (customerCpf.length() < 11){
                    customerCpf = '0' + customerCpf;                
                }

                // Valida primeiro digito	
                int add = 0;

                for (int i = 0; i < 9; i++) {
                    add += ((int)customerCpf.charAt(i) - 48) * (10 - i); // Obtém cada caracter e calcula o peso ponderado
                }
                int rev = 11 - (add % 11); // Se o módulo for 10 ou 11 o dígito verificador deve ser 0 (zero).
                if (rev == 10 || rev == 11) {
                    rev = 0;
                }
                // Verifica se o resultado é igual ao primeiro dígito verificador.
                if (rev == ((int)customerCpf.charAt(9) - 48)) {                     
                
                    // Agora validar segundo digito	
                    add = 0;
                    for (int i = 0; i < 10; i++) {
                        add += ((int)customerCpf.charAt(i) - 48) * (11 - i);
                    }
                    rev = 11 - (add % 11);
                    if (rev == 10 || rev == 11) {
                        rev = 0;
                    }
                    // Verifica se o resultado é igual ao segundo dígito verificador.
                    if (rev == ((int)customerCpf.charAt(10) - 48)) {
                         return null;
                    }
                }
               
                return "CPF inválido!";
                
            }

        }else{
            return "Não é possível verificar CPF de não usuário!";
        }
        return null;
    }

}
