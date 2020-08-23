package com.wells.fsd.pms.entity;

import java.time.LocalDate;

public class KitDetails {
    private int prodid;
    private String prodname;
    private String prodDesc;
    private static double dblprodprice;
    private int iQuantity;
    private double dblTotalCost;
    
    public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public static double getDblprodprice() {
		return dblprodprice;
	}
	public void setDblprodprice(double dblprodprice) {
		this.dblprodprice = dblprodprice;
	}
	public int getiQuantity() {
		return iQuantity;
	}
	public void setiQuantity(int iQuantity) {
		this.iQuantity = iQuantity;
	}
	public double getDblTotalCost() {
		return dblTotalCost;
	}
	public void setDblTotalCost(double dblTotalCost) {
		this.dblTotalCost = dblTotalCost;
	}
	
     
    
}