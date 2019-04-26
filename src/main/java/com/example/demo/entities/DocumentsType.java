package com.example.demo.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Documents_types")
public class DocumentsType {
    @Id
    private Integer code;
    @Version
    private Integer version;
    private String name;

    public DocumentsType() {
    }

    public DocumentsType(Integer version) {
        this.version = version;
    }

    public DocumentsType(Integer code, Integer version, String name, Set<Document> documents) {
        this.code = code;
        this.version = version;
        this.name = name;
        this.documents = documents;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "documentType" , orphanRemoval = true)
    private Set<Document> documents;
}
