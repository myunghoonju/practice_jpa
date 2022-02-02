package shop.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private Address address;
    private DeliveryStatus status;
    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;
}
