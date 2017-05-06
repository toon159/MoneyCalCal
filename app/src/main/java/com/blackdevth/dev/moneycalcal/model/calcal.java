package com.blackdevth.dev.moneycalcal.model;

/**
 * Created by Toon on 6/5/2560.
 */

public class calcal {
    private int priceInput;
    private int vat;
    private int serviceCharge;
    private int priceWithTax;
    private int priceWithTaxAndServiceCharge;

    public int getPriceInput() {
        return priceInput;
    }

    public void setPriceInput(int priceInput) {
        this.priceInput = priceInput;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public int getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(int serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public int getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(int priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    public int getPriceWithTaxAndServiceCharge() {
        return priceWithTaxAndServiceCharge;
    }

    public void setPriceWithTaxAndServiceCharge(int priceWithTaxAndServiceCharge) {
        this.priceWithTaxAndServiceCharge = priceWithTaxAndServiceCharge;
    }
}
