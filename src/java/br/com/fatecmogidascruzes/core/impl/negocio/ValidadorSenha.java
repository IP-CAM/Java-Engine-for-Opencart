/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.core.impl.negocio;

import br.com.fatecmogidascruzes.core.impl.IStrategy;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.IEntidade;


/* 
* Fonte: https://www.ibm.com/support/knowledgecenter/pt-br/SSV2LR/com.ibm.wbpm.imuc.doc/topics/rsec_characters.html
* 
* Caracteres minúsculos {a-z}
* Caracteres maiúsculos {A-Z}
* Números {0-9}
* Ponto de exclamação {!}
* Parêntese de abertura {(}
* Parêntese de fechamento {)}
* Traço {-}; esse caractere não é suportado como caractere inicial no ID do usuário ou senha
* Ponto {.}; esse caractere não é suportado como caractere inicial no ID do usuário ou senha
* Ponto de interrogação {?}
* Colchete de abertura {[}
* Colchete de fechamento {]}
* Sublinhado {_}; este é o único caractere especial suportado no IBM i
* Acento grave {`}
* Til {~}
* Ponto e vírgula {;}
* Dois pontos {:}
* Ponto de exclamação {!}
* Arroba {@} (esse caractere não é suportado ao criar o administrador do IBM Business Process Manager durante a instalação)
* Sinal de número {#}
* Símbolo de dólar {$}
* Sinal de porcentagem {%}
* Acento circunflexo {^}
* E comercial {&}
* Asterisco {*}
* Sinal de mais {+}
* Sinal de igual {=}
*/ 

/**
 *
 * @author Josias Wattrelos
 */
public class ValidadorSenha implements IStrategy {

    /**
     *
     * @param entidade
     * @return
     */
    @Override
    public String processar(IEntidade entidade) {
        String mensagem = null;
        String senha = "";
        String confirmacaoSenha = "";
        if(entidade instanceof TableCustomer ){
            senha = ((TableCustomer) entidade).getPassword();
            confirmacaoSenha = ((TableCustomer) entidade).getConfirmPassword();
        }
        if(!senha.endsWith(confirmacaoSenha)){
             return "\nA confirmação de senha deve ser igual a senha!";
        }
        // Verifica o número mínimo de caracteres:
        if(senha.length() > 8){
            boolean contemCaixaAlta = false;
            boolean contemCaixaBaixa = false;
            boolean contemNumeros = false;
            boolean contemCaracteres = false;
            for(char letra: senha.toCharArray()){
                if((int)letra >= 65 && (int)letra <= 90) contemCaixaAlta = true; // Verificar se contém alguma letra maiúscula
                else if((int)letra >= 97 && (int)letra <= 122) contemCaixaBaixa = true; // Verificar se contém alguma letra minúscula.
                else if((int)letra >= 48 && (int)letra <= 57) contemNumeros = true; // Verificar se contém algum número.                
                else { // Verifica se é algum caracter de sinais gráficos imprimíveis...
                    String caracteresGraficosImprimiveis = "!()-.?[]_`~;:!@#$%^&*+=";
                    for(char caracter: caracteresGraficosImprimiveis.toCharArray()){
                        if(letra == caracter){
                            contemCaracteres = true;
                        }
                    }
                }
            }
            if(!contemCaixaAlta)    mensagem = "\nA senha precisa conter alguma letra MAIÚSCULA!";
            if(!contemCaixaBaixa)   mensagem = "\nA senha precisa conter alguma letra MINÚSCULA!";
            if(!contemNumeros)      mensagem = "\nA senha precisa conter algum NÚMERO!";
            if(!contemCaracteres)   mensagem = "\nA senha precisa conter alguma caracter gráfico! Caracteres válidos: '!()-.?[]_`~;:!@#$%^&*+='"; 
            
        } else {
            return "\nA senha precisa de ter ao menos 8 caracteres contendo letras números e simbolos!";
        }        
        return mensagem;
    }
    
}
