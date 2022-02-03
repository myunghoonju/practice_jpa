package jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class JProduct {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;
    private String name;
    private int price;
    private int stockAmount;
}
