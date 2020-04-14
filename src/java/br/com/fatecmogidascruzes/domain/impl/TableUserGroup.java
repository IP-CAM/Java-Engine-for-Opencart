/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_user_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableUserGroup.findAll", query = "SELECT t FROM TableUserGroup t"),
    @NamedQuery(name = "TableUserGroup.findByUserGroupId", query = "SELECT t FROM TableUserGroup t WHERE t.userGroupId = :userGroupId"),
    @NamedQuery(name = "TableUserGroup.findByName", query = "SELECT t FROM TableUserGroup t WHERE t.name = :name")})
public class TableUserGroup extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_group_id")
    private Integer userGroupId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    
    @JsonIgnore
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "permission")
    private String permission;
    
    //Collectons
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userGroup")
    private List<TableUser> tableUserList;

    // Constructors
    public TableUserGroup() {
    }

    public TableUserGroup(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public TableUserGroup(Integer userGroupId, String name, String permission) {
        this.userGroupId = userGroupId;
        this.name = name;
        this.permission = permission;
    }

    @Override
    public Integer getId() {
        return userGroupId;
    }

    @Override
    public void setId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
    
    public List<TableUser> getTableUserList() {
        return tableUserList;
    }

    public void setTableUserList(List<TableUser> tableUserList) {
        this.tableUserList = tableUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userGroupId != null ? userGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableUserGroup)) {
            return false;
        }
        TableUserGroup other = (TableUserGroup) object;
        if ((this.userGroupId == null && other.userGroupId != null) || (this.userGroupId != null && !this.userGroupId.equals(other.userGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableUserGroup[ userGroupId=" + userGroupId + " ]";
    }
    
}
