package com.codefour.uee.Products;

public class Product {
    private String proName,proId,proCategeory ,proLocation,proImgUrl;
    private int proQuantity,proPrice,proAlertQty,id;

    public String getProName() {
        return proName;
    }

    public String getProImgUrl() {
        return proImgUrl;
    }

    public String getProId() {
        return proId;
    }

    public String getProCategeory() {
        return proCategeory;
    }

    public String getProLocation() {
        return proLocation;
    }

    public String getProQuantity() {
        return String.valueOf(proQuantity);
    }

    public String getProPrice() {
        return String.valueOf(proPrice);
    }

    public String getProAlertQty() {
        return String.valueOf(proAlertQty);
    }

    public int getId() {
        return id;
    }

    public Product(String proName, String proId, String proCategeory, String proLocation, String proImgUrl, int proQuantity, int proPrice, int proAlertQty, int id) {
        this.proName = proName;
        this.proId = proId;
        this.proCategeory = proCategeory;
        this.proLocation = proLocation;
        this.proImgUrl = proImgUrl;
        this.proQuantity = proQuantity;
        this.proPrice = proPrice;
        this.proAlertQty = proAlertQty;
        this.id = id;
    }
}
