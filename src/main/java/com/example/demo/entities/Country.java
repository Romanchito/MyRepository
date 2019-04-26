package com.example.demo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Country")
public class Country {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", sequenceName="ID_GENERATE_SEQ", allocationSize=1)
    private Integer id;
    @Version
    private Integer version;
    private String name;

    public Country() {
    }

    public Country(Integer version, String name, Set<User> users) {
        this.version = version;
        this.name = name;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToMany(mappedBy = "countries")
    private Set<User> users;

    public Set<User> getUsers(){

        if(users == null){
            users = new HashSet<>();
        }
        return users;
    }
}
