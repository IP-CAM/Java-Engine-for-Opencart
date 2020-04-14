/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_return")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableReturn.findAll", query = "SELECT t FROM TableReturn t"),
    @NamedQuery(name = "TableReturn.findByReturnId", query = "SELECT t FROM TableReturn t WHERE t.returnId = :returnId"),
    @NamedQuery(name = "TableReturn.findByFullname", query = "SELECT t FROM TableReturn t WHERE t.fullname = :fullname"),
    @NamedQuery(name = "TableReturn.findByEmail", query = "SELECT t FROM TableReturn t WHERE t.email = :email"),
    @NamedQuery(name = "TableReturn.findByTelephone", query = "SELECT t FROM TableReturn t WHERE t.telephone = :telephone"),
    @NamedQuery(name = "TableReturn.findByProduct", query = "SELECT t FROM TableReturn t WHERE t.product = :product"),
    @NamedQuery(name = "TableReturn.findByModel", query = "SELECT t FROM TableReturn t WHERE t.model = :model"),
    @NamedQuery(name = "TableReturn.findByQuantity", query = "SELECT t FROM TableReturn t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TableReturn.findByOpened", query = "SELECT t FROM TableReturn t WHERE t.opened = :opened"),
    @NamedQuery(name = "TableReturn.findByDateOrdered", query = "SELECT t FROM TableReturn t WHERE t.dateOrdered = :dateOrdered"),
    @NamedQuery(name = "TableReturn.findByDateAdded", query = "SELECT t FROM TableReturn t WHERE t.dateAdded = :dateAdded"),
    @NamedQuery(name = "TableReturn.findByDateModified", query = "SELECT t FROM TableReturn t WHERE t.dateModified = :dateModified")})
public class TableReturn extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "return_id")
    private Integer returnId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fullname")
    private String fullname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 96)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "product")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "opened")
    private boolean opened;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_ordered")
    @Temporal(TemporalType.DATE)
    private Date dateOrdered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
    
    // Collections -----------------------------------------------------------------------------------------------
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private TableCustomer customer;
    
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = true)
    private TableOrder order;
    
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(optional = false)
    private TableProduct product;
    
    @JoinColumn(name = "return_action_id", referencedColumnName = "return_action_id")
    @ManyToOne(optional = false)
    private TableReturnAction returnAction;
    
    @JoinColumn(name = "return_reason_id", referencedColumnName = "return_reason_id")
    @ManyToOne(optional = false)
    private TableReturnReason returnReason;
    
    @JoinColumn(name = "return_status_id", referencedColumnName = "return_status_id")
    @ManyToOne(optional = false)
    private TableReturnStatus returnStatus;

    // Constructors ------------------------------------------------------------------------------------------------------------------
    public TableReturn() {
    }

    public TableReturn(Integer returnId) {
        this.returnId = returnId;
    }

    public TableReturn(Integer returnId, String fullname, String email, String telephone, String product, String model, int quantity, boolean opened, Date dateOrdered, Date dateAdded, Date dateModified) {
        this.returnId = returnId;
        this.fullname = fullname;
        this.email = email;
        this.telephone = telephone;
        this.productName = product;
        this.model = model;
        this.quantity = quantity;
        this.opened = opened;
        this.dateOrdered = dateOrdered;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    @Override
    public Integer getId() {
        return returnId;
    }

    @Override
    public void setId(Integer returnId) {
        this.returnId = returnId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProduct() {
        return productName;
    }

    public void setProduct(String product) {
        this.productName = product;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public TableCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TableCustomer customer) {
        this.customer = customer;
    }

    public TableOrder getOrderId() {
        return order;
    }

    public void setOrderId(TableOrder orderId) {
        this.order = orderId;
    }

    public TableProduct getProductId() {
        return product;
    }

    public void setProductId(TableProduct productId) {
        this.product = productId;
    }

    public TableReturnAction getReturnActionId() {
        return returnAction;
    }

    public void setReturnActionId(TableReturnAction returnActionId) {
        this.returnAction = returnActionId;
    }

    public TableReturnReason getReturnReasonId() {
        return returnReason;
    }

    public void setReturnReasonId(TableReturnReason returnReasonId) {
        this.returnReason = returnReasonId;
    }

    public TableReturnStatus getReturnStatusId() {
        return returnStatus;
    }

    public void setReturnStatusId(TableReturnStatus returnStatusId) {
        this.returnStatus = returnStatusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (returnId != null ? returnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableReturn)) {
            return false;
        }
        TableReturn other = (TableReturn) object;
        if ((this.returnId == null && other.returnId != null) || (this.returnId != null && !this.returnId.equals(other.returnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableReturn[ returnId=" + returnId + " ]";
    }
    
}
