package domain;

import org.hibernate.cfg.Configuration;

import javax.persistence.*;

@Entity
@Table(name="product_info1")
public class Product1
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prodcut_id")
    private int prooductId;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_price")
    private double ProductPrice;

    public int getProoductId() {
        return prooductId;
    }

    public void setProoductId(int prooductId) {
        this.prooductId = prooductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }
}
