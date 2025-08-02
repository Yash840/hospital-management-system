package com.cross.hospital.model;

public class Report extends Document{
    private String subject;
    private String remarks;
    private String verdict;
    private String diagnosedBy;

    public Report(String _subject, String _remarks, String _verdict, String _diagnosedBy, String _issuedTo){
        super(_diagnosedBy, _issuedTo);
        this.subject = _subject;
        this.remarks = _remarks;
        this.verdict = _verdict;
        this.diagnosedBy = _diagnosedBy;
    }

    public String read(){
        return String.format("\n====== REPORT %s ======\nFor : %s\nSubject : %s\nRemarks : %s\nVerdict : %s\n\nDiagnosis : %s\n%s",super.documentId(), super.issuedTo(), this.subject, this.remarks, this.verdict, this.diagnosedBy, super.createdAt());
    }

    @Override
    public String toString(){
        return String.format("\n====== REPORT %s ======\nSubject : %s\nRemarks : %s\nVerdict : %s\n\nDiagnosis : %s\n%s",super.documentId(), this.subject, this.remarks, this.verdict, this.diagnosedBy, super.createdAt());
    }
}
