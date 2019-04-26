package com.example.demo.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Document")
public class Document {

    @Id
    private Integer id;
    @Version
    private Integer version;
    private String docNumber;
    private Date docDate;

    public Document() {
    }

    public Document(Integer id, Integer version, String docNumber, Date docDate, User user, DocumentsType documentType) {
        this.id = id;
        this.version = version;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.user = user;
        this.documentType = documentType;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public User getUser() {
        return user;
    }

    public DocumentsType getDocumentType() {
        return documentType;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDocumentType(DocumentsType documentType) {
        this.documentType = documentType;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id")
    private DocumentsType documentType;
}
