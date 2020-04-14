/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOrder.findAll", query = "SELECT t FROM TableOrder t"),
    @NamedQuery(name = "TableOrder.findById", query = "SELECT t FROM TableOrder t WHERE t.orderId = :id"),
    @NamedQuery(name = "TableOrder.findByInvoiceNo", query = "SELECT t FROM TableOrder t WHERE t.invoiceNo = :invoiceNo"),
    @NamedQuery(name = "TableOrder.findByInvoicePrefix", query = "SELECT t FROM TableOrder t WHERE t.invoicePrefix = :invoicePrefix"),
    @NamedQuery(name = "TableOrder.findByStoreName", query = "SELECT t FROM TableOrder t WHERE t.storeName = :storeName"),
    @NamedQuery(name = "TableOrder.findByStoreUrl", query = "SELECT t FROM TableOrder t WHERE t.storeUrl = :storeUrl"),
    @NamedQuery(name = "TableOrder.findByName", query = "SELECT t FROM TableOrder t WHERE t.username = :name"),
    @NamedQuery(name = "TableOrder.findByEmail", query = "SELECT t FROM TableOrder t WHERE t.email = :email"),
    @NamedQuery(name = "TableOrder.findByTelephone", query = "SELECT t FROM TableOrder t WHERE t.telephone = :telephone"),
    @NamedQuery(name = "TableOrder.findByPaymentFullname", query = "SELECT t FROM TableOrder t WHERE t.paymentFullname = :paymentFullname"),
    @NamedQuery(name = "TableOrder.findByPaymentUsername", query = "SELECT t FROM TableOrder t WHERE t.paymentUsername = :paymentUsername"),
    @NamedQuery(name = "TableOrder.findByPaymentCompany", query = "SELECT t FROM TableOrder t WHERE t.paymentCompany = :paymentCompany"),
    @NamedQuery(name = "TableOrder.findByPaymentAddress1", query = "SELECT t FROM TableOrder t WHERE t.paymentAddress1 = :paymentAddress1"),
    @NamedQuery(name = "TableOrder.findByPaymentAddress2", query = "SELECT t FROM TableOrder t WHERE t.paymentAddress2 = :paymentAddress2"),
    @NamedQuery(name = "TableOrder.findByPaymentCity", query = "SELECT t FROM TableOrder t WHERE t.paymentCity = :paymentCity"),
    @NamedQuery(name = "TableOrder.findByPaymentPostcode", query = "SELECT t FROM TableOrder t WHERE t.paymentPostcode = :paymentPostcode"),
    @NamedQuery(name = "TableOrder.findByPaymentCountry", query = "SELECT t FROM TableOrder t WHERE t.paymentCountry = :paymentCountry"),
    @NamedQuery(name = "TableOrder.findByPaymentCountryId", query = "SELECT t FROM TableOrder t WHERE t.paymentCountryId = :paymentCountryId"),
    @NamedQuery(name = "TableOrder.findByPaymentZone", query = "SELECT t FROM TableOrder t WHERE t.paymentZone = :paymentZone"),
    @NamedQuery(name = "TableOrder.findByPaymentZoneId", query = "SELECT t FROM TableOrder t WHERE t.paymentZoneId = :paymentZoneId"),
    @NamedQuery(name = "TableOrder.findByPaymentMethod", query = "SELECT t FROM TableOrder t WHERE t.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "TableOrder.findByPaymentCode", query = "SELECT t FROM TableOrder t WHERE t.paymentCode = :paymentCode"),
    @NamedQuery(name = "TableOrder.findByShippingFullname", query = "SELECT t FROM TableOrder t WHERE t.shippingFullname = :shippingFullname"),
    @NamedQuery(name = "TableOrder.findByShippingUsername", query = "SELECT t FROM TableOrder t WHERE t.shippingUsername = :shippingUsername"),
    @NamedQuery(name = "TableOrder.findByShippingCompany", query = "SELECT t FROM TableOrder t WHERE t.shippingCompany = :shippingCompany"),
    @NamedQuery(name = "TableOrder.findByShippingAddress1", query = "SELECT t FROM TableOrder t WHERE t.shippingAddress1 = :shippingAddress1"),
    @NamedQuery(name = "TableOrder.findByShippingAddress2", query = "SELECT t FROM TableOrder t WHERE t.shippingAddress2 = :shippingAddress2"),
    @NamedQuery(name = "TableOrder.findByShippingCity", query = "SELECT t FROM TableOrder t WHERE t.shippingCity = :shippingCity"),
    @NamedQuery(name = "TableOrder.findByShippingPostcode", query = "SELECT t FROM TableOrder t WHERE t.shippingPostcode = :shippingPostcode"),
    @NamedQuery(name = "TableOrder.findByShippingCountry", query = "SELECT t FROM TableOrder t WHERE t.shippingCountry = :shippingCountry"),
    @NamedQuery(name = "TableOrder.findByShippingCountryId", query = "SELECT t FROM TableOrder t WHERE t.shippingCountryId = :shippingCountryId"),
    @NamedQuery(name = "TableOrder.findByShippingZone", query = "SELECT t FROM TableOrder t WHERE t.shippingZone = :shippingZone"),
    @NamedQuery(name = "TableOrder.findByShippingZoneId", query = "SELECT t FROM TableOrder t WHERE t.shippingZoneId = :shippingZoneId"),
    @NamedQuery(name = "TableOrder.findByShippingMethod", query = "SELECT t FROM TableOrder t WHERE t.shippingMethod = :shippingMethod"),
    @NamedQuery(name = "TableOrder.findByShippingCode", query = "SELECT t FROM TableOrder t WHERE t.shippingCode = :shippingCode"),
    @NamedQuery(name = "TableOrder.findByTotal", query = "SELECT t FROM TableOrder t WHERE t.total = :total"),
    @NamedQuery(name = "TableOrder.findByAffiliateId", query = "SELECT t FROM TableOrder t WHERE t.affiliateId = :affiliateId"),
    @NamedQuery(name = "TableOrder.findByCommission", query = "SELECT t FROM TableOrder t WHERE t.commission = :commission"),
    @NamedQuery(name = "TableOrder.findByTracking", query = "SELECT t FROM TableOrder t WHERE t.tracking = :tracking"),
    @NamedQuery(name = "TableOrder.findByLanguageId", query = "SELECT t FROM TableOrder t WHERE t.languageId = :languageId"),
    @NamedQuery(name = "TableOrder.findByCurrencyCode", query = "SELECT t FROM TableOrder t WHERE t.currencyCode = :currencyCode"),
    @NamedQuery(name = "TableOrder.findByCurrencyValue", query = "SELECT t FROM TableOrder t WHERE t.currencyValue = :currencyValue"),
    @NamedQuery(name = "TableOrder.findByIp", query = "SELECT t FROM TableOrder t WHERE t.ip = :ip"),
    @NamedQuery(name = "TableOrder.findByForwardedIp", query = "SELECT t FROM TableOrder t WHERE t.forwardedIp = :forwardedIp"),
    @NamedQuery(name = "TableOrder.findByUserAgent", query = "SELECT t FROM TableOrder t WHERE t.userAgent = :userAgent"),
    @NamedQuery(name = "TableOrder.findByAcceptLanguage", query = "SELECT t FROM TableOrder t WHERE t.acceptLanguage = :acceptLanguage"),
    @NamedQuery(name = "TableOrder.findByDateAdded", query = "SELECT t FROM TableOrder t WHERE t.dateAdded = :dateAdded"),
    @NamedQuery(name = "TableOrder.findByDateModified", query = "SELECT t FROM TableOrder t WHERE t.dateModified = :dateModified"),
    @NamedQuery(name = "TableOrder.findByDate", query = "SELECT t FROM TableOrder t WHERE t.dateAdded BETWEEN :startDate AND :endDate ORDER BY t.dateAdded"),
})
public class TableOrder extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    
    @Basic(optional = false)
    @Column(name = "invoice_no")
    private int invoiceNo;
    
    @Basic(optional = false)
    // @Size(min = 1, max = 26)
    @Column(name = "invoice_prefix")
    private String invoicePrefix;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "store_name")
    private String storeName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "store_url")
    private String storeUrl;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fullname")
    private String fullname;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "username")
    private String username;
    
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
    
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Formato de telefone/fax inválido, deve ser xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "payment_username")
    private String paymentUsername;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "payment_fullname")
    private String paymentFullname;
    
    @Basic(optional = true)
    @Column(name = "payment_company")
    private String paymentCompany;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "payment_address_1")
    private String paymentAddress1;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "payment_address_2")
    private String paymentAddress2;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "payment_city")
    private String paymentCity;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "payment_postcode")
    private String paymentPostcode;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "payment_country")
    private String paymentCountry;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_country_id")
    private int paymentCountryId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "payment_zone")
    private String paymentZone;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_zone_id")
    private int paymentZoneId;
    
    @Basic(optional = true)    
    @Lob()    
    @Column(name = "payment_address_format")
    private String paymentAddressFormat;  
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "payment_method")
    private String paymentMethod;
    
    @Basic(optional = true)
    @Column(name = "payment_code")
    private String paymentCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "shipping_username")
    private String shippingUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "shipping_fullname")
    private String shippingFullname;
    
    @Basic(optional = true)    
    @Column(name = "shipping_company")
    private String shippingCompany;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "shipping_address_1")
    private String shippingAddress1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "shipping_address_2")
    private String shippingAddress2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "shipping_city")
    private String shippingCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "shipping_postcode")
    private String shippingPostcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "shipping_country")
    private String shippingCountry;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipping_country_id")
    private int shippingCountryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "shipping_zone")
    private String shippingZone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipping_zone_id")
    private int shippingZoneId;
    @Basic(optional = false)
    @NotNull
    @Lob()
    @Size(min = 1, max = 65535)
    @Column(name = "shipping_address_format")
    private String shippingAddressFormat;    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "shipping_method")
    private String shippingMethod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "shipping_code")
    private String shippingCode;
    @Basic(optional = false)
    @NotNull
    @Lob()
    @Size(min = 1, max = 65535)
    @Column(name = "comment")
    private String comment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = true)
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "affiliate_id")
    private int affiliateId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "commission")
    private BigDecimal commission;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "tracking")
    private String tracking;
    @Basic(optional = false)
    @NotNull
    @Column(name = "language_id")
    private int languageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "currency_code")
    private String currencyCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currency_value")
    private BigDecimal currencyValue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "forwarded_ip")
    private String forwardedIp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_agent")
    private String userAgent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "accept_language")
    private String acceptLanguage;
        
    @Basic(optional = false)
    @Column(name = "date_added", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded; 
    
    @Basic(optional = false)
    @Column(name = "date_modified", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
    
    // Collection --------------------------------------------------------------------------------------------------------------------
    @OneToMany(cascade = CascadeType.ALL, mappedBy="order")
    private List<TableReturn> returnList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="order")
    private List<TableCustomerTransaction> customerTransactionList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="order")
    private List<TableOrderTotal> orderTotalList;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="order")
    private List<TableCouponHistory> couponHistoryList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="order")
    private List<TableOrderOption> orderOptionList;    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="order")
    private List<TableOrderHistory> orderHistoryList;
       
    @OneToMany(cascade = CascadeType.ALL, mappedBy="order")
    private List<TableCustomerReward> customerRewardList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="order")
    private List<TableOrderProduct> orderProductList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="order")
    private List<TableOrderRecurring> orderRecurringList;
    
    @JoinColumn(name = "currency_id", referencedColumnName = "currency_id")
    @ManyToOne(optional = false)
    private TableCurrency currencyId;
    
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private TableCustomer customer;
    
    @JoinColumn(name = "customer_group_id", referencedColumnName = "customer_group_id")
    @ManyToOne(optional = false)
    private TableCustomerGroup customerGroup;
    
    @JoinColumn(name = "marketing_id", referencedColumnName = "marketing_id")
    @ManyToOne(optional = true)
    private TableMarketing marketing;
    
    @JoinColumn(name = "order_status_id", referencedColumnName = "order_status_id")
    @ManyToOne(optional = false)
    private TableOrderStatus orderStatus;
    
    @JsonIgnore
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @ManyToOne(optional = false)
    private TableStore store; 

    // Constructors ------------------------------------------------------------------------------------------------------------------
    public TableOrder() {
    }

    public TableOrder(Integer orderId) {
        this.orderId = orderId;
    }

    public TableOrder(Integer orderId, int invoiceNo, String invoicePrefix, String storeName, String storeUrl, String fullname, String lastname, String email, String telephone, String paymentFullname, String paymentUsername, String paymentCompany, String paymentAddress1, String paymentAddress2, String paymentCity, String paymentPostcode, String paymentCountry, int paymentCountryId, String paymentZone, int paymentZoneId, String paymentAddressFormat, String paymentMethod, String paymentCode, String shippingFullname, String shippingUsername, String shippingCompany, String shippingAddress1, String shippingAddress2, String shippingCity, String shippingPostcode, String shippingCountry, int shippingCountryId, String shippingZone, int shippingZoneId, String shippingAddressFormat, String shippingMethod, String shippingCode, String comment, BigDecimal total, int affiliateId, BigDecimal commission, String tracking, int languageId, String currencyCode, BigDecimal currencyValue, String ip, String forwardedIp, String userAgent, String acceptLanguage, Date dateAdded, Date dateModified) {
        this.orderId = orderId;
        this.invoiceNo = invoiceNo;
        this.invoicePrefix = invoicePrefix;
        this.storeName = storeName;
        this.storeUrl = storeUrl;
        this.fullname = fullname;
        this.username = lastname;
        this.email = email;
        this.telephone = telephone;
        this.paymentUsername = paymentFullname;
        this.paymentFullname = paymentUsername;
        this.paymentCompany = paymentCompany;
        this.paymentAddress1 = paymentAddress1;
        this.paymentAddress2 = paymentAddress2;
        this.paymentCity = paymentCity;
        this.paymentPostcode = paymentPostcode;
        this.paymentCountry = paymentCountry;
        this.paymentCountryId = paymentCountryId;
        this.paymentZone = paymentZone;
        this.paymentZoneId = paymentZoneId;
        this.paymentAddressFormat = paymentAddressFormat;
        this.paymentMethod = paymentMethod;
        this.paymentCode = paymentCode;
        this.shippingUsername = shippingFullname;
        this.shippingFullname = shippingUsername;
        this.shippingCompany = shippingCompany;
        this.shippingAddress1 = shippingAddress1;
        this.shippingAddress2 = shippingAddress2;
        this.shippingCity = shippingCity;
        this.shippingPostcode = shippingPostcode;
        this.shippingCountry = shippingCountry;
        this.shippingCountryId = shippingCountryId;
        this.shippingZone = shippingZone;
        this.shippingZoneId = shippingZoneId;
        this.shippingAddressFormat = shippingAddressFormat;
        this.shippingMethod = shippingMethod;
        this.shippingCode = shippingCode;
        this.comment = comment;
        this.total = total;
        this.affiliateId = affiliateId;
        this.commission = commission;
        this.tracking = tracking;
        this.languageId = languageId;
        this.currencyCode = currencyCode;
        this.currencyValue = currencyValue;
        this.ip = ip;
        this.forwardedIp = forwardedIp;
        this.userAgent = userAgent;
        this.acceptLanguage = acceptLanguage;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    @Override
    public Integer getId() {
        return orderId;
    }

    @Override
    public void setId(Integer orderId) {
        this.orderId = orderId;
    }
    
    @Override
    public String getName() {
        return username;
    }
    
    public void setName(String username) {
        this.username = username;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoicePrefix() {
        return invoicePrefix;
    }

    public void setInvoicePrefix(String invoicePrefix) {
        this.invoicePrefix = invoicePrefix;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }

    public String getPaymentUsername() {
        return paymentUsername;
    }

    public void setPaymentUsername(String paymentFullname) {
        this.paymentUsername = paymentFullname;
    }

    public String getPaymentFullname() {
        return paymentFullname;
    }

    public void setPaymentFullname(String paymentUsername) {
        this.paymentFullname = paymentUsername;
    }

    public String getPaymentCompany() {
        return paymentCompany;
    }

    public void setPaymentCompany(String paymentCompany) {
        this.paymentCompany = paymentCompany;
    }

    public String getPaymentAddress1() {
        return paymentAddress1;
    }

    public void setPaymentAddress1(String paymentAddress1) {
        this.paymentAddress1 = paymentAddress1;
    }

    public String getPaymentAddress2() {
        return paymentAddress2;
    }

    public void setPaymentAddress2(String paymentAddress2) {
        this.paymentAddress2 = paymentAddress2;
    }

    public String getPaymentCity() {
        return paymentCity;
    }

    public void setPaymentCity(String paymentCity) {
        this.paymentCity = paymentCity;
    }

    public String getPaymentPostcode() {
        return paymentPostcode;
    }

    public void setPaymentPostcode(String paymentPostcode) {
        this.paymentPostcode = paymentPostcode;
    }

    public String getPaymentCountry() {
        return paymentCountry;
    }

    public void setPaymentCountry(String paymentCountry) {
        this.paymentCountry = paymentCountry;
    }

    public int getPaymentCountryId() {
        return paymentCountryId;
    }

    public void setPaymentCountryId(int paymentCountryId) {
        this.paymentCountryId = paymentCountryId;
    }

    public String getPaymentZone() {
        return paymentZone;
    }

    public void setPaymentZone(String paymentZone) {
        this.paymentZone = paymentZone;
    }

    public int getPaymentZoneId() {
        return paymentZoneId;
    }

    public void setPaymentZoneId(int paymentZoneId) {
        this.paymentZoneId = paymentZoneId;
    }

    public String getPaymentAddressFormat() {
        return paymentAddressFormat;
    }

    public void setPaymentAddressFormat(String paymentAddressFormat) {
        this.paymentAddressFormat = paymentAddressFormat;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getShippingUsername() {
        return shippingUsername;
    }

    public void setShippingUsername(String shippingFullname) {
        this.shippingUsername = shippingFullname;
    }

    public String getShippingFullname() {
        return shippingFullname;
    }

    public void setShippingFullname(String shippingUsername) {
        this.shippingFullname = shippingUsername;
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public String getShippingAddress1() {
        return shippingAddress1;
    }

    public void setShippingAddress1(String shippingAddress1) {
        this.shippingAddress1 = shippingAddress1;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public void setShippingAddress2(String shippingAddress2) {
        this.shippingAddress2 = shippingAddress2;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingPostcode() {
        return shippingPostcode;
    }

    public void setShippingPostcode(String shippingPostcode) {
        this.shippingPostcode = shippingPostcode;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public int getShippingCountryId() {
        return shippingCountryId;
    }

    public void setShippingCountryId(int shippingCountryId) {
        this.shippingCountryId = shippingCountryId;
    }

    public String getShippingZone() {
        return shippingZone;
    }

    public void setShippingZone(String shippingZone) {
        this.shippingZone = shippingZone;
    }

    public int getShippingZoneId() {
        return shippingZoneId;
    }

    public void setShippingZoneId(int shippingZoneId) {
        this.shippingZoneId = shippingZoneId;
    }

    public String getShippingAddressFormat() {
        return shippingAddressFormat;
    }

    public void setShippingAddressFormat(String shippingAddressFormat) {
        this.shippingAddressFormat = shippingAddressFormat;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }


    public int getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(int affiliateId) {
        this.affiliateId = affiliateId;
    }


    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(BigDecimal currencyValue) {
        this.currencyValue = currencyValue;
    }


    public String getForwardedIp() {
        return forwardedIp;
    }

    public void setForwardedIp(String forwardedIp) {
        this.forwardedIp = forwardedIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
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
    
    public List<TableCustomerTransaction> getCustomerTransactionList() {
        return customerTransactionList;
    }

    public void setCustomerTransactionList(List<TableCustomerTransaction> tableCustomerTransactionList) {
        this.customerTransactionList = tableCustomerTransactionList;
    }
    
    public List<TableOrderTotal> getOrderTotalList() {
        return orderTotalList;
    }

    public void setOrderTotalList(List<TableOrderTotal> tableOrderTotalList) {
        this.orderTotalList = tableOrderTotalList;
    }
    
    public List<TableCouponHistory> getCouponHistoryList() {
        return couponHistoryList;
    }

    public void setCouponHistoryList(List<TableCouponHistory> tableCouponHistoryList) {
        this.couponHistoryList = tableCouponHistoryList;
    }
    
    public List<TableOrderOption> getOrderOptionList() {
        return orderOptionList;
    }

    public void setOrderOptionList(List<TableOrderOption> tableOrderOptionList) {
        this.orderOptionList = tableOrderOptionList;
    }

    public TableCurrency getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(TableCurrency currencyId) {
        this.currencyId = currencyId;
    }

    public TableCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TableCustomer customer) {
        this.customer = customer;
    }

    public TableCustomerGroup getCustomerGroupId() {
        return customerGroup;
    }

    public void setCustomerGroupId(TableCustomerGroup customerGroupId) {
        this.customerGroup = customerGroupId;
    }

    public TableMarketing getMarketingId() {
        return marketing;
    }

    public void setMarketingId(TableMarketing marketingId) {
        this.marketing = marketingId;
    }

    public TableOrderStatus getOrderStatusId() {
        return orderStatus;
    }

    public void setOrderStatusId(TableOrderStatus orderStatusId) {
        this.orderStatus = orderStatusId;
    }

    public TableStore getStoreId() {
        return store;
    }

    public void setStoreId(TableStore storeId) {
        this.store = storeId;
    }
    
    public List<TableOrderHistory> getOrderHistoryList() {
        return orderHistoryList;
    }

    public void setOrderHistoryList(List<TableOrderHistory> tableOrderHistoryList) {
        this.orderHistoryList = tableOrderHistoryList;
    }
    
    public List<TableCustomerReward> getCustomerRewardList() {
        return customerRewardList;
    }

    public void setCustomerRewardList(List<TableCustomerReward> tableCustomerRewardList) {
        this.customerRewardList = tableCustomerRewardList;
    }
    
    public List<TableOrderProduct> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<TableOrderProduct> tableOrderProductList) {
        this.orderProductList = tableOrderProductList;
    }
    
    public List<TableOrderRecurring> getOrderRecurringList() {
        return orderRecurringList;
    }

    public void setOrderRecurringList(List<TableOrderRecurring> tableOrderRecurringList) {
        this.orderRecurringList = tableOrderRecurringList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableOrder)) {
            return false;
        }
        TableOrder other = (TableOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableOrder[ orderId=" + orderId + " ]";
    }
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }  


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }   

    @XmlTransient
    public List<TableReturn> getReturnList() {
        return returnList;
    }

    public void setReturnList(List<TableReturn> tableReturnList) {
        this.returnList = tableReturnList;
    }
    
}
