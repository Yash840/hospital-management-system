package com.cross.hospital.model;

import com.cross.hospital.utils.Auth;

import java.time.LocalDate;

public class Document {
    private static int DOC_SERIAL = 0;

    private String documentId;
    private LocalDate createdAt;
    private String createdBy;
    private String issuedTo;

    public Document(String _createdBy, String _issuedTo){
        this.documentId = Auth.generateId("DOC", DOC_SERIAL);
        this.createdAt = LocalDate.now();
        this.createdBy = _createdBy;
        this.issuedTo = _issuedTo;

        DOC_SERIAL++;
    }

    public String issuedTo() { return this.issuedTo; }
    public String documentId() { return this.documentId; }
    public String createdAt() { return this.createdAt.toString(); }
    public String createdBy() { return this.createdBy; }

    @Override
    public String toString(){
        return String.format("%s on %s by %s\n", this.documentId, this.createdAt.toString(), this.createdBy);
    }
}
