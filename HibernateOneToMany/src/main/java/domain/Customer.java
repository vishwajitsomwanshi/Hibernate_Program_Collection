package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private int custId;
    @Column(name="cust_name")
    private String custName;
    @Column(name="cust_contact")
    private int custContact;
    @OneToMany(mappedBy = "custRef",cascade = CascadeType.ALL)
    private List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getCustContact() {
        return custContact;
    }

    public void setCustContact(int custContact) {
        this.custContact = custContact;
    }
    public void placeOrder(Order ordRef)
    {
        if(orderList==null)
        {
           orderList=new LinkedList<Order>();
        }
        orderList.add(ordRef);
        ordRef.setCustRef(this);
    }
}
