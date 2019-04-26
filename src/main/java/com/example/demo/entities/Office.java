package com.example.demo.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Office")
public class Office {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", sequenceName="ID_GENERATE_SEQ", allocationSize=1)
    private Integer id;
    @Version
    private Integer version;
    private String name;
    private String address;
    private String phone;
    private Boolean isActive;

    public Office() {
    }

    public Office(Integer version, String name, String address, String phone, Boolean isActive, Organisation organisation, Set<User> users) {
        this.version = version;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
        this.organisation = organisation;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id")
    private Organisation organisation;


    @OneToMany(cascade = CascadeType.ALL , mappedBy = "office" , orphanRemoval = true)
    private Set<User> users;
}
