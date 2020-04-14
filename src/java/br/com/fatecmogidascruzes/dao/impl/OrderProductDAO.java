package br.com.fatecmogidascruzes.dao.impl;
import br.com.fatecmogidascruzes.dao.AbstractDAO;
import br.com.fatecmogidascruzes.dao.EntityManagerProvider;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import br.com.fatecmogidascruzes.domain.impl.TableOrderProduct;
import br.com.fatecmogidascruzes.domain.impl.TableProduct;
import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class  OrderProductDAO  extends AbstractDAO {
    public  OrderProductDAO() {
        super(new  TableOrderProduct());
    }
    
    @Override
    public EntidadeDominio create(EntidadeDominio entity) {
        
        TableOrderProduct orderProduct = (TableOrderProduct)entity;
        TableProduct product = new TableProduct();
        AbstractDAO dao = new AbstractDAO(product);
        product = (TableProduct) dao.findOneById(orderProduct.getProductId());       
        orderProduct.setName(product.getName());
        orderProduct.setModel(product.getModel());
        orderProduct.setPrice(product.getPrice());
        orderProduct.setTotal(product.getPrice().multiply(new BigDecimal(orderProduct.getQuantity())));
        orderProduct.setTax(new BigDecimal(0.0)); // Não esquecer de atualizar este atributo quando a taxação for implementada.
        Session session = EntityManagerProvider.getSession(); 
        Transaction transaction = session.beginTransaction();        
        session.save(orderProduct);
        transaction.commit();
        return entity;        
    }
    
}
