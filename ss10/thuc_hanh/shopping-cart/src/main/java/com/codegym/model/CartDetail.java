package com.codegym.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_detail")
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardDeatailID;

    private int quantity;
    @ManyToOne
    @JoinColumn(name = "cartID")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;

    public CartDetail() {
    }

    public CartDetail(int cardDeatailID, int quantity, Cart cart, Product product) {
        this.cardDeatailID = cardDeatailID;
        this.quantity = quantity;
        this.cart = cart;
        this.product = product;
    }

    public int getCardDeatailID() {
        return cardDeatailID;
    }

    public void setCardDeatailID(int cardDeatailID) {
        this.cardDeatailID = cardDeatailID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
