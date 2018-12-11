package com.example.hahma.freshafoodstart.Model;

public class Order {

    private String ProductId;
    private String ProdcutName;
    private String Quantity;
    private String Price;
    private String Discount;

    public Order()
    {

    }

    public Order(String productId, String prodcutName, String quantity, String price, String discount) {
        ProductId = productId;
        ProdcutName = prodcutName;
        Quantity = quantity;
        Price = price;
        Discount = discount;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProdcutName() {
        return ProdcutName;
    }

    public void setProdcutName(String prodcutName) {
        ProdcutName = prodcutName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }
}
