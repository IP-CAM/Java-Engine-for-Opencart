/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_customer")
@NamedQueries({
    @NamedQuery(name = "TableCustomer.findAll", query = "SELECT t FROM TableCustomer t"),    
    @NamedQuery(name = "TableCustomer.findById", query = "SELECT t FROM TableCustomer t WHERE t.userId = :id"),
    @NamedQuery(name = "TableCustomer.findByFullName", query = "SELECT t FROM TableCustomer t WHERE t.fullName = :fullName"),
    @NamedQuery(name = "TableCustomer.findByEmail", query = "SELECT t FROM TableCustomer t WHERE t.email = :email"),
    @NamedQuery(name = "TableCustomer.findByTelephone", query = "SELECT t FROM TableCustomer t WHERE t.telephone = :telephone"),
    @NamedQuery(name = "TableCustomer.findByNewsletter", query = "SELECT t FROM TableCustomer t WHERE t.newsletter = :newsletter"),
    
    @NamedQuery(name = "TableCustomer.findByName",     query = "SELECT t FROM TableCustomer t WHERE t.username = :name"),
    @NamedQuery(name = "TableCustomer.findByUserName", query = "SELECT t FROM TableCustomer t WHERE t.username = :username")
    
})
    // Collection

@PrimaryKeyJoinColumn(name="user_id")
public class TableCustomer extends TableUser { 
	
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull()
    @Size(min = 10, max = 128)
    @Column(name = "fullname")
    private String fullName;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 8, max = 96)
    @Column(name = "email")
    private String email;
        
    @Basic(optional = false)
    @NotNull
    @Size(min = 8, max = 32)
    @Column(name = "telephone")
    private String telephone; 
    
    @Basic(optional = false)
    @Column(name = "cpf", unique = true)
    private long cpf;

    @Basic(optional = false)
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Basic(optional = false)
    @Column(name = "sexo")
    private char sexo;
    
    @Transient
    @NotNull
    @Size(min = 1, max = 80)    
    private String confirmPassword;
    
    @Lob()
    @Size(max = 65535)
    @Column(name = "cart")
    private String cart;
    
    @Lob()
    @Size(max = 65535)
    @Column(name = "wishlist")
    private String wishlist;
    
    @Basic(optional = false)
    @NotNull()
    @Column(name = "newsletter")
    private boolean newsletter;

    @Basic(optional = false)
    @NotNull
    @Column(name = "safe")
    private boolean safe;
    
    @Basic(optional = false)
    @NotNull
    @Lob()
    @Size(min = 1, max = 65535)
    @Column(name = "token")
    private String token;    

    //  Collection -----------------------------------------------------------------------------------------------------------------------

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_group_id", referencedColumnName = "customer_group_id")
    private TableCustomerGroup customerGroup; 
    
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @ManyToOne(cascade = {CascadeType.REFRESH})
    private TableStore store;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<TableCustomerTransaction> tableCustomerTransactionList;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "table_customer_wishlist", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<TableProduct> productWishList;    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<TableReturn> returnList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<TableCouponHistory> tableCouponHistoryList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<TableOrder> orderList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<TableCreditCard> creditcardList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<TableCustomerApproval> tableCustomerApprovalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<TableCustomerOnline> tableCustomerOnlineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<TableCustomerReward> tableCustomerRewardList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<TableCart> tableCartList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<TableCustomerActivity> tableCustomerActivityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<TableCustomerHistory> tableCustomerHistoryList;  
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "customer")
    private List<TableAddress> addressList = new ArrayList<>();;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "customer")
    private List<TableCreditCard> credicardList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerIpId")
    private List<TableCustomerIp> tableCustomerIpList;

    // Constructors ------------------------------------------------------------------------------------------------------------------
    public TableCustomer() {
    }

    public TableCustomer(Integer userId) {
        super(userId);
    }

    public TableCustomer(Integer userId, String username, String password, String salt, String firstname, String lastname, String email, String image, String code, String ip, boolean status, Date dateAdded,       
    String fullName, String telephone, long cpf, char sexo, String confirmPassword, String cart, String wishlist, boolean newsletter, boolean safe, String token, TableCustomerGroup customerGroup, TableStore store) {
        super(userId, username, password, salt, firstname, lastname, email, image, code, ip, status, dateAdded);
        this.fullName = fullName;
        this.telephone = telephone;
        this.cpf = cpf;
        this.sexo = sexo;
        this.confirmPassword = confirmPassword;
        this.cart = cart;
        this.wishlist = wishlist;
        this.newsletter = newsletter;
        this.safe = safe;
        this.token = token;
        this.customerGroup = customerGroup;
        this.store = store;
    }
    
    @Override
    public String getName(){
        return this.username;
    } 
    
    @Override
    public void setName(String name){
        this.username = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

        @Override
    public String getConfirmPassword() {
        return confirmPassword;
    }

        @Override
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public String getWishlist() {
        return wishlist;
    }

    public void setWishlist(String wishlist) {
        this.wishlist = wishlist;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TableCustomerGroup getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(TableCustomerGroup customerGroup) {
        this.customerGroup = customerGroup;
    }

    public List<TableCreditCard> getCreditcardList() {
        return creditcardList;
    }

    public void setCreditcardList(List<TableCreditCard> creditCard) {
        this.creditcardList = creditCard;
    }

    public TableStore getStore() {
        return store;
    }

    public void setStore(TableStore store) {
        this.store = store;
    }

    public List<TableCustomerTransaction> getTableCustomerTransactionList() {
        return tableCustomerTransactionList;
    }

    public void setTableCustomerTransactionList(List<TableCustomerTransaction> tableCustomerTransactionList) {
        this.tableCustomerTransactionList = tableCustomerTransactionList;
    }

    public List<TableProduct> getProductWishList() {
        return productWishList;
    }

    public void setProductWishList(List<TableProduct> productWishList) {
        this.productWishList = productWishList;
    }

    public List<TableReturn> getReturnList() {
        return returnList;
    }

    public void setReturnList(List<TableReturn> returnList) {
        this.returnList = returnList;
    }

    public List<TableCouponHistory> getTableCouponHistoryList() {
        return tableCouponHistoryList;
    }

    public void setTableCouponHistoryList(List<TableCouponHistory> tableCouponHistoryList) {
        this.tableCouponHistoryList = tableCouponHistoryList;
    }

    public List<TableOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<TableOrder> orderList) {
        this.orderList = orderList;
    }

    public List<TableCustomerApproval> getTableCustomerApprovalList() {
        return tableCustomerApprovalList;
    }

    public void setTableCustomerApprovalList(List<TableCustomerApproval> tableCustomerApprovalList) {
        this.tableCustomerApprovalList = tableCustomerApprovalList;
    }

    public List<TableCustomerOnline> getTableCustomerOnlineList() {
        return tableCustomerOnlineList;
    }

    public void setTableCustomerOnlineList(List<TableCustomerOnline> tableCustomerOnlineList) {
        this.tableCustomerOnlineList = tableCustomerOnlineList;
    }

    public List<TableCustomerReward> getTableCustomerRewardList() {
        return tableCustomerRewardList;
    }

    public void setTableCustomerRewardList(List<TableCustomerReward> tableCustomerRewardList) {
        this.tableCustomerRewardList = tableCustomerRewardList;
    }

    public List<TableCart> getTableCartList() {
        return tableCartList;
    }

    public void setTableCartList(List<TableCart> tableCartList) {
        this.tableCartList = tableCartList;
    }

    public List<TableCustomerActivity> getTableCustomerActivityList() {
        return tableCustomerActivityList;
    }

    public void setTableCustomerActivityList(List<TableCustomerActivity> tableCustomerActivityList) {
        this.tableCustomerActivityList = tableCustomerActivityList;
    }

    public List<TableCustomerHistory> getTableCustomerHistoryList() {
        return tableCustomerHistoryList;
    }

    public void setTableCustomerHistoryList(List<TableCustomerHistory> tableCustomerHistoryList) {
        this.tableCustomerHistoryList = tableCustomerHistoryList;
    }

    public List<TableAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<TableAddress> addressList) {
        this.addressList = addressList;
    }

    public List<TableCreditCard> getCredicard() {
        return credicardList;
    }

    public void setCredicard(List<TableCreditCard> credicard) {
        this.credicardList = credicard;
    }

    public List<TableCustomerIp> getTableCustomerIpList() {
        return tableCustomerIpList;
    }

    public void setTableCustomerIpList(List<TableCustomerIp> tableCustomerIpList) {
        this.tableCustomerIpList = tableCustomerIpList;
    }
    
    @Override
    public String getUsername(){
        return username;
    }
}
