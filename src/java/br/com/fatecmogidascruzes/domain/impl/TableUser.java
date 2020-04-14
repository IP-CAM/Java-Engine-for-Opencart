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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableUser.findAll", query = "SELECT t FROM TableUser t"),
    @NamedQuery(name = "TableUser.findById", query = "SELECT t FROM TableUser t WHERE t.userId = :id"),
    @NamedQuery(name = "TableUser.findByName", query = "SELECT t FROM TableUser t WHERE t.username = :name"),
    @NamedQuery(name = "TableUser.findByUserName", query = "SELECT t FROM TableUser t WHERE t.username = :username"),
    @NamedQuery(name = "TableUser.findByImage", query = "SELECT t FROM TableUser t WHERE t.image = :image"),
    @NamedQuery(name = "TableUser.findByCode", query = "SELECT t FROM TableUser t WHERE t.code = :code"),
    @NamedQuery(name = "TableUser.findByIp", query = "SELECT t FROM TableUser t WHERE t.ip = :ip"),
    @NamedQuery(name = "TableUser.findByStatus", query = "SELECT t FROM TableUser t WHERE t.status = :status"),
    @NamedQuery(name = "TableUser.findByDateAdded", query = "SELECT t FROM TableUser t WHERE t.dateAdded = :dateAdded")})

@Inheritance(strategy = InheritanceType.JOINED)
public class TableUser extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    protected String username;
    
    @JsonIgnore
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "password")
    private String password;
    
    @Transient
    @NotNull
    @Size(min = 1, max = 80)    
    private String confirmPassword;
    
    @JsonIgnore
    @Basic(optional = false)
    @Size(min = 1, max = 9)
    @Column(name = "salt")
    private String salt;
    
    @Column(name = "image")
    private String image;
    
    @Basic(optional = false)    
    @Size(min = 1, max = 40)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    
    @Size(min = 1, max = 40)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    
    @Basic(optional = false)
    @Column(name = "date_added", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;   
    
    // Collections --------------------------------------------------------------------------------------------------------------
   
    // Definirá o nivel de privilégios de acesso.    
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_group_id", referencedColumnName = "user_group_id")
    private TableUserGroup userGroup;

    // Constructors ------------------------------------------------------------------------------------------------------------------
    public TableUser() {
    }

    public TableUser(Integer userId) {
        this.userId = userId;
    }

    public TableUser(Integer userId, String username, String password, String salt, String firstname, String lastname, String email, String image, String code, String ip, boolean status, Date dateAdded) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.image = image;
        this.code = code;
        this.ip = ip;
        this.status = status;
        this.dateAdded = dateAdded;
    }
    
    // Setters and Getters -----------------------------------------------------------------------------------------------------------
    @Override
    public Integer getId() {
        return userId;
    }

    @Override
    public void setId(Integer userId) {
        this.userId = userId;
    }
    /*
    @Override
    public String getName() {
        return username;
    }    
    
    public void setName(String username) {
        this.username = username;
    }
*/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }   
    

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }    
   
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public TableUserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(TableUserGroup userGroup) {
        this.userGroup = userGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableUser)) {
            return false;
        }
        TableUser other = (TableUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableUser[ userId=" + userId + " ]";
    }
    
}
