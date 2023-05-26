package domain;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name="product_info2")
public class Product2
{
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column(name="product_id")
    private int produtId;
    @Column(name="product_name")
    private String ProductName;
    @Column(name="product_price")
    private double productPrice;

    public int getProdutIdrodutId() {
        return produtId;
    }

    public void setProdutId(int produtId) {
        this.produtId = produtId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
