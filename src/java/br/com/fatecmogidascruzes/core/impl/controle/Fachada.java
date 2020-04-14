package br.com.fatecmogidascruzes.core.impl.controle;

import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.core.impl.IFachada;
import br.com.fatecmogidascruzes.core.impl.IStrategy;
import br.com.fatecmogidascruzes.core.impl.negocio.ValidadorCpf;
import br.com.fatecmogidascruzes.core.impl.negocio.ValidadorDataNascimento;
import br.com.fatecmogidascruzes.core.impl.negocio.ValidadorEmail;
import br.com.fatecmogidascruzes.core.impl.negocio.ValidadorSenha;
import br.com.fatecmogidascruzes.dao.AbstractDAO;

import br.com.fatecmogidascruzes.dao.IDAO;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import br.com.fatecmogidascruzes.domain.impl.FindByColumn;
import br.com.fatecmogidascruzes.domain.impl.Pagination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fachada implements IFachada {

    /**
     * Mapa para conter as regras de negócio de todas operaçõeses por entidade;
     * O valor é um mapa de regras de negécio indexado pela operação
     */
    private Map<String, Map<String, List<IStrategy>>> rns;
    private Resultado resultado;

    public Fachada() {
        
        /* Intanciando o Map de Regras de Negócio */
        rns = new HashMap<>();

        /* Criando instâncias dos DAOs a serem utilizados */
        /* e adicionando cada dao no MAP indexando pelo nome da classe */

  

        /* Criando instâncias de regras de neg�cio a serem utilizados*/
        //ValidadorDadosObrigatoriosFornecedor vrDadosObrigatoriosFornecedor = new ValidadorDadosObrigatoriosFornecedor();
        ///ValidadorCnpj vCnpj = new ValidadorCnpj();
        ///ComplementarDtCadastro cDtCadastro = new ComplementarDtCadastro();
        /* Criando uma lista para conter as regras de neg�cio de fornencedor
         * quando a opera��o for create
         */
        List<IStrategy> rnsSalvarFornecedor = new ArrayList<>();
        /* Adicionando as regras a serem utilizadas na operação create do fornecedor*/
        ///rnsSalvarFornecedor.add(vrDadosObrigatoriosFornecedor);
        ///rnsSalvarFornecedor.add(vCnpj);
        ///rnsSalvarFornecedor.add(cDtCadastro);
        /* Cria o mapa que poder� conter todas as listas de regras de neg�cio espec�fica 
         * por opera��o  do fornecedor
         */
        Map<String, List<IStrategy>> rnsFornecedor = new HashMap<>();
        /*
         * Adiciona a listra de regras na opera��o create no mapa do fornecedor (lista criada na linha 70)
         */
        rnsFornecedor.put("create", rnsSalvarFornecedor);
        /* Adiciona o mapa(criado na linha 79) com as regras indexadas pelas opera��es no mapa geral indexado 
         * pelo nome da entidade
         */
        // rns.put(Fornecedor.class.getName(), rnsFornecedor);
        /* Criando uma lista para conter as regras de neg�cio de cliente
         * quando a operação for create
         */
        List<IStrategy> rnsCreateCustomer = new ArrayList<>();
        /* Adicionando as regras a serem utilizadas na operação create do cliente */
        // rnsCreateCustomer.add(cDtCadastro);		
        rnsCreateCustomer.add(new ValidadorCpf());
        rnsCreateCustomer.add(new ValidadorEmail());
        rnsCreateCustomer.add(new ValidadorSenha());
        rnsCreateCustomer.add(new ValidadorDataNascimento());
        /* Cria o mapa que poder� conter todas as listas de regras de neg�cio espec�fica 
         * por opera��o do cliente
         */
        Map<String, List<IStrategy>> rnsCustomer = new HashMap<>();
        /*
         * Adiciona a listra de regras na opera��o create no mapa do cliente (lista criada na linha 93)
         */
        rnsCustomer.put("create", rnsCreateCustomer);
        /* Adiciona o mapa(criado na linha 143) com as regras indexadas pelas opera��es no mapa geral indexado 
         * pelo nome da entidade. Observe que este mapa (rns) � o mesmo utilizado na linha 88.
         */
        // rns.put(Cliente.class.getName(), rnsCustomer);
        /* Criando uma lista para conter as regras de negócio de produto
         * quando a operação for create
         */
        List<IStrategy> rnsSalvarProduto = new ArrayList<>();
        /* Adicionando as regras a serem utilizadas na operação create do produto */
        // rnsSalvarProduto.add(cDtCadastro);		
        ///rnsSalvarProduto.add(vQtd);
        /* Criando uma lista para conter as regras de neg�cio de produto
         * quando a opera��o for update
         */
		///List<IStrategy> rnsAlterarProduto = new ArrayList<IStrategy>();
		/* Adicionando as regras a serem utilizadas na opera��o update do produto */
		///rnsAlterarProduto.add(vQtd);
        /* Cria o mapa que poder� conter todas as listas de regras de neg�cio espec�fica 
         * por opera��o do produto
         */
		///Map<String, List<IStrategy>> rnsProduto = new HashMap<String, List<IStrategy>>();
		/*
         * Adiciona a listra de regras na opera��o create no mapa do produto (lista criada na linha 114)
         */
		///rnsProduto.put("SALVAR", rnsSalvarProduto);
		/*
         * Adiciona a listra de regras na opera��o update no mapa do produto (lista criada na linha 122)
         */
		///rnsProduto.put("ALTERAR", rnsAlterarProduto);
        /* Adiciona o mapa(criado na linha 129) com as regras indexadas pelas opera��es no mapa geral indexado 
         * pelo nome da entidade. Observe que este mapa (rns) � o mesmo utilizado na linha 88.
         */
        ///rns.put(Produto.class.getName(), rnsProduto);
    }

    @Override
    public Resultado create(EntidadeDominio entidade) {
        resultado = new Resultado();

        String msg = executarRegras(entidade, "create");

        if (msg == null) {
            IDAO dao = new AbstractDAO(entidade);
            List<EntidadeDominio> entidades = new ArrayList<>();
            entidades.add(dao.create(entidade)); 
            resultado.setEntidades(entidades);
           return resultado;
        } else {
            resultado.setMsg(msg);
        }
        return resultado;
    }

    @Override
    public Resultado findAll(EntidadeDominio entidade) {

        resultado = new Resultado();
        String msg = executarRegras(entidade, "delete");

        if (msg == null) {
            IDAO dao = new AbstractDAO(entidade);
            resultado.setEntidades(dao.findAll());
        } else {
            resultado.setMsg(msg);
        }
        return resultado;

    }

    @Override
    public Resultado findByPage(EntidadeDominio entidadeDominio) {

        Pagination pagination = (Pagination) entidadeDominio;
        EntidadeDominio entidade = pagination.getEntity();
        resultado = new Resultado();        
        
        String msg = executarRegras(entidade, "findByPage");

        if (msg == null) {
            IDAO dao = new AbstractDAO(entidade);
            
            return dao.findByPage(
                pagination.getFindBy(),
                pagination.getSearchValue(),
                pagination.getPage(),
                pagination.getLinesPerPage(),
                pagination.getOrderBy(),
                pagination.getDirection());
        } else {
            resultado.setMsg(msg);
        }
        return resultado;
    }
    
    @Override
    public Resultado findByDate(EntidadeDominio entidadeDominio) {
        
        resultado = new Resultado();
        String msg = executarRegras(entidadeDominio, "findByDate");        

        if (msg == null) {
            IDAO dao = new AbstractDAO(entidadeDominio);
            resultado = dao.findByDate(entidadeDominio);
            
        } else {
            resultado.setMsg(msg);
        }
        return resultado;
        
    }
    
    @Override
    public Resultado findAllPage(EntidadeDominio entidadeDominio) {

        Pagination pagination = (Pagination) entidadeDominio;
        EntidadeDominio entidade = pagination.getEntity();
        resultado = new Resultado();
        
        String msg = executarRegras(entidade, "findAllPage");

        if (msg == null) {
            IDAO dao = new AbstractDAO(entidade);            
            return dao.findAllPage(
                pagination.getPage(),
                pagination.getLinesPerPage(),
                pagination.getOrderBy(),
                pagination.getDirection());
        } else {
            resultado.setMsg(msg);
        }
        return resultado;
    }


    @Override
    public Resultado findOneById(EntidadeDominio entidade) {
        resultado = new Resultado();
        
        String msg = executarRegras(entidade, "findOneById");

        if (msg == null) {
            IDAO dao = new AbstractDAO(entidade);          
            List<EntidadeDominio> list;
            list = new ArrayList<>();
            list.add(dao.findOneById(entidade.getId()));
            resultado.setEntidades(list);
        } else {
            resultado.setMsg(msg);
        }
        return resultado;
    }    
    
    @Override
    public Resultado findByName (EntidadeDominio entidade) {
        resultado = new Resultado(); 
        String msg = executarRegras(entidade, "findOneByName");
        
        if (msg == null) {
            IDAO dao = new AbstractDAO(entidade);            
            resultado.setEntidades(dao.findByName(entidade.getName()));
        } else {
            resultado.setMsg(msg);
        }
        return resultado;
        
    }    
    
    @Override
    public Resultado findByColumn(EntidadeDominio entidade) {

        FindByColumn findByColumn = (FindByColumn)entidade;
        EntidadeDominio entity = findByColumn.getEntity();
        resultado = new Resultado();
        String msg = executarRegras(entity, "findByColumn");
        if (msg == null) {
            IDAO dao = new AbstractDAO(entidade);
            resultado.setEntidades(dao.findByColumn(findByColumn.getFindBy(),findByColumn.getSearchValue()));
        } else {
            resultado.setMsg(msg);
        }
        return resultado;
    }
    
    @Override
    public Resultado visualizar(EntidadeDominio entidade) {

        resultado = new Resultado();
        resultado.setEntidades(new ArrayList<>(1));
        resultado.getEntidades().add(entidade);
        return resultado;

    }

    @Override
    public Resultado update(EntidadeDominio entidade) {
        resultado = new Resultado();
        String msg = executarRegras(entidade, "update");

        if (msg == null) {
            IDAO dao = new AbstractDAO(entidade);
            try {
                List<EntidadeDominio> entidades = new ArrayList<>();
                entidades.add(dao.update(entidade));
                resultado.setEntidades(entidades);
            } catch (Exception e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível editar o registro! Erro: " + e);
            }
        } else {
            resultado.setMsg(msg);
        }

        return resultado;

    }

    /**
     * DELETE
     * *******************************************************************************************************
     *
     * @param entidade
     * @return
     */
    @Override
    public Resultado delete(EntidadeDominio entidade) {
        resultado = new Resultado();
        String msg = executarRegras(entidade, "delete");

        if (msg == null) {

            IDAO dao = new AbstractDAO(entidade);         
            dao.delete(entidade.getId());
            List<EntidadeDominio> entidades = new ArrayList<>();
            resultado.setEntidades(entidades);

        } else {
            resultado.setMsg(msg);

        }

        return resultado;

    } 

    private String executarRegras(EntidadeDominio entidade, String operacao) {
        String nmClasse = entidade.getClass().getName();
        StringBuilder msg = new StringBuilder();

        Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);

        if (regrasOperacao != null) {
            List<IStrategy> regras = regrasOperacao.get(operacao);

            if (regras != null) {
                for (IStrategy s : regras) {
                    String m = s.processar(entidade);

                    if (m != null) {
                        msg.append(m);
                        msg.append("\n");
                    }
                }
            }

        }

        if (msg.length() > 0) {
            return msg.toString();
        } else {
            return null;
        }
    }

}
