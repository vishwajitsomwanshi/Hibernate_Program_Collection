package domain;

import javax.persistence.*;

@Entity
@Table(name="order")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ord_id")
    private int ordId;
    @Column(name = "ord_no")
    private  String ordNo;
    @ManyToOne(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="cust_ref")
    private Customer custRef;

    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    public String getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(String ordNo) {
        this.ordNo = ordNo;
    }

    public Customer getCustRef() {
        return custRef;
    }

    public void setCustRef(Customer custRef) {
        this.custRef = custRef;
    }
}
