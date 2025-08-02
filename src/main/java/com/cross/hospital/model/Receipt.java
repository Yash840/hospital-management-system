package com.cross.hospital.model;

public class Receipt extends Document{
    private final double billingAmt;

    private final double TAX_RATE = 5;

    private double calculateTaxAmt(double amt, double rate){ return amt > 20000 ? amt * ( rate / 100 ) : 0 ; }

    private double calculateTotalAmt(double amt){ return amt + calculateTaxAmt(amt, this.TAX_RATE); }

    public Receipt(double _billingAmt, String _issuedBy, String _issuedTo){
        super(_issuedBy, _issuedTo);
        this.billingAmt = _billingAmt;
    }

    public String read(){
        return String.format("\n====== RECEIPT %s ======\nFor : %s\nAmount Paid (In INR)\n\t-Billing Amount --> %.2f\n\t-Tax Amount --> %.2f\n-------\nTotal Amount : %.2f\n\nIssued By : %s\n%s\n",super.documentId(), super.issuedTo(), this.billingAmt, this.calculateTaxAmt(this.billingAmt,this.TAX_RATE), this.calculateTotalAmt(this.billingAmt), super.createdBy(),super.createdAt());
    }

    @Override
    public String toString(){
        return String.format("\n====== RECEIPT %s ======\nAmount Paid\n\t-Billing Amount --> %.2f\n\t-Tax Amount --> %.2f\n-------\nTotal Amount : %.2f \n\nIssued By : %s\n%s\n",super.documentId(),this.billingAmt, this.calculateTaxAmt(this.billingAmt,this.TAX_RATE), this.calculateTotalAmt(this.billingAmt), super.createdBy(),super.createdAt());
    }
}
