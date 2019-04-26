package com.example.demo.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Organisation")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", sequenceName="ID_GENERATE_SEQ", allocationSize=1)
    private Integer id;
    @Version
    private Integer version;
    private String firstName;
    private String secondName;
    private String middleName;
    private String userPosition;
    private String phone;
    private Boolean isActive;



    public User() {
    }

    public User(Integer version) {
        this.version = version;
    }

    public User(Integer version, String firstName, String secondName, String middleName, String userPosition, String phone, Boolean isActive, Office office, Set<Country> countries, Document document) {
        this.version = version;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.userPosition = userPosition;
        this.phone = phone;
        this.isActive = isActive;
        this.office = office;
        this.countries = countries;
        this.document = document;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getUserPosition() {
        return userPosition;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Office getOffice() {
        return office;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;

    @ManyToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    @JoinTable(name = "User_Country" , joinColumns = @JoinColumn(name = "user_id") ,
    inverseJoinColumns = @JoinColumn(name = "country_id"))
    private Set<Country> countries;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Document document;

    public void addCountry(Country country){
        countries.add(country);
        country.getUsers().add(this);
    }

    public void removeCountry(Country country){
        countries.remove(country);
        country.getUsers().remove(this);
    }
}
