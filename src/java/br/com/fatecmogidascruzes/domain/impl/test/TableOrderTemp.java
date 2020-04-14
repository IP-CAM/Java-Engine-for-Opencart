/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl.test;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_order_temp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOrderTemp.findByDate", query = "SELECT t FROM TableOrderTemp t WHERE t.dateAdded BETWEEN :startDate AND :endDate ORDER BY t.dateAdded"),
    @NamedQuery(name = "TableOrderTemp.findByDateModified", query = "SELECT t FROM TableOrderTemp t WHERE t.dateModified = :dateModified")})
public class TableOrderTemp extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "invoice_no")
    private Integer invoiceNo;
    @Size(max = 26)
    @Column(name = "invoice_prefix")
    private String invoicePrefix;
    @Column(name = "store_id")
    private Integer storeId;
    @Size(max = 64)
    @Column(name = "store_name")
    private String storeName;
    @Size(max = 255)
    @Column(name = "store_url")
    private String storeUrl;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "customer_group_id")
    private Integer customerGroupId;
    @Size(max = 80)
    @Column(name = "fullname")
    private String fullname;
    @Size(max = 32)
    @Column(name = "username")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 96)
    @Column(name = "email")
    private String email;
    @Size(max = 32)
    @Column(name = "telephone")
    private String telephone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Formato de telefone/fax inválido, deve ser xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 32)
    @Column(name = "fax")
    private String fax;
    @Size(max = 32)
    @Column(name = "payment_fullname")
    private String paymentFullname;
    @Size(max = 32)
    @Column(name = "payment_username")
    private String paymentUsername;
    @Size(max = 60)
    @Column(name = "payment_company")
    private String paymentCompany;
    @Size(max = 128)
    @Column(name = "payment_address_1")
    private String paymentAddress1;
    @Size(max = 128)
    @Column(name = "payment_address_2")
    private String paymentAddress2;
    @Size(max = 128)
    @Column(name = "payment_city")
    private String paymentCity;
    @Size(max = 10)
    @Column(name = "payment_postcode")
    private String paymentPostcode;
    @Size(max = 128)
    @Column(name = "payment_country")
    private String paymentCountry;
    @Column(name = "payment_country_id")
    private Integer paymentCountryId;
    @Size(max = 128)
    @Column(name = "payment_zone")
    private String paymentZone;
    @Column(name = "payment_zone_id")
    private Integer paymentZoneId;
    @Lob
    @Size(max = 65535)
    @Column(name = "payment_address_format")
    private String paymentAddressFormat;
    @Size(max = 128)
    @Column(name = "payment_method")
    private String paymentMethod;
    @Size(max = 128)
    @Column(name = "payment_code")
    private String paymentCode;
    @Size(max = 32)
    @Column(name = "shipping_username")
    private String shippingUsername;
    @Size(max = 32)
    @Column(name = "shipping_fullname")
    private String shippingFullname;
    @Size(max = 40)
    @Column(name = "shipping_company")
    private String shippingCompany;
    @Size(max = 128)
    @Column(name = "shipping_address_1")
    private String shippingAddress1;
    @Size(max = 128)
    @Column(name = "shipping_address_2")
    private String shippingAddress2;
    @Size(max = 128)
    @Column(name = "shipping_city")
    private String shippingCity;
    @Size(max = 10)
    @Column(name = "shipping_postcode")
    private String shippingPostcode;
    @Size(max = 128)
    @Column(name = "shipping_country")
    private String shippingCountry;
    @Column(name = "shipping_country_id")
    private Integer shippingCountryId;
    @Size(max = 128)
    @Column(name = "shipping_zone")
    private String shippingZone;
    @Column(name = "shipping_zone_id")
    private Integer shippingZoneId;
    @Lob
    @Size(max = 65535)
    @Column(name = "shipping_address_format")
    private String shippingAddressFormat;
    @Size(max = 128)
    @Column(name = "shipping_method")
    private String shippingMethod;
    @Size(max = 128)
    @Column(name = "shipping_code")
    private String shippingCode;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "order_status_id")
    private Integer orderStatusId;
    @Column(name = "affiliate_id")
    private Integer affiliateId;
    @Column(name = "commission")
    private BigDecimal commission;
    @Column(name = "marketing_id")
    private Integer marketingId;
    @Size(max = 64)
    @Column(name = "tracking")
    private String tracking;
    @Column(name = "language_id")
    private Integer languageId;
    @Column(name = "currency_id")
    private Integer currencyId;
    @Size(max = 3)
    @Column(name = "currency_code")
    private String currencyCode;
    @Column(name = "currency_value")
    private BigDecimal currencyValue;
    @Size(max = 40)
    @Column(name = "ip")
    private String ip;
    @Size(max = 40)
    @Column(name = "forwarded_ip")
    private String forwardedIp;
    @Size(max = 255)
    @Column(name = "user_agent")
    private String userAgent;
    @Size(max = 255)
    @Column(name = "accept_language")
    private String acceptLanguage;
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    public TableOrderTemp() {
    }

    public TableOrderTemp(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public Integer getId() {
        return orderId;
    }

    @Override
    public void setId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(Integer invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoicePrefix() {
        return invoicePrefix;
    }

    public void setInvoicePrefix(String invoicePrefix) {
        this.invoicePrefix = invoicePrefix;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(Integer customerGroupId) {
        this.customerGroupId = customerGroupId;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPaymentFullname() {
        return paymentFullname;
    }

    public void setPaymentFullname(String paymentFullname) {
        this.paymentFullname = paymentFullname;
    }

    public String getPaymentUsername() {
        return paymentUsername;
    }

    public void setPaymentUsername(String paymentUsername) {
        this.paymentUsername = paymentUsername;
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

    public Integer getPaymentCountryId() {
        return paymentCountryId;
    }

    public void setPaymentCountryId(Integer paymentCountryId) {
        this.paymentCountryId = paymentCountryId;
    }

    public String getPaymentZone() {
        return paymentZone;
    }

    public void setPaymentZone(String paymentZone) {
        this.paymentZone = paymentZone;
    }

    public Integer getPaymentZoneId() {
        return paymentZoneId;
    }

    public void setPaymentZoneId(Integer paymentZoneId) {
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

    public void setShippingUsername(String shippingUsername) {
        this.shippingUsername = shippingUsername;
    }

    public String getShippingFullname() {
        return shippingFullname;
    }

    public void setShippingFullname(String shippingFullname) {
        this.shippingFullname = shippingFullname;
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

    public Integer getShippingCountryId() {
        return shippingCountryId;
    }

    public void setShippingCountryId(Integer shippingCountryId) {
        this.shippingCountryId = shippingCountryId;
    }

    public String getShippingZone() {
        return shippingZone;
    }

    public void setShippingZone(String shippingZone) {
        this.shippingZone = shippingZone;
    }

    public Integer getShippingZoneId() {
        return shippingZoneId;
    }

    public void setShippingZoneId(Integer shippingZoneId) {
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

    public Integer getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public Integer getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(Integer affiliateId) {
        this.affiliateId = affiliateId;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Integer getMarketingId() {
        return marketingId;
    }

    public void setMarketingId(Integer marketingId) {
        this.marketingId = marketingId;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableOrderTemp)) {
            return false;
        }
        TableOrderTemp other = (TableOrderTemp) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.test.TableOrderTemp[ orderId=" + orderId + " ]";
    }
    
}
