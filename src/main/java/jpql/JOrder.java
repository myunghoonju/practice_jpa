package jpql;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JOrder {

    @Id
    @GeneratedValue
    private Long id;
    private int orderAmount;
    @Embedded
    private JAddress address;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private JProduct product;
}
