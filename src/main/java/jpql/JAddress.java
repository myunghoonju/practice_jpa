package jpql;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JAddress {

    @Column(length = 100)
    private String city;
    @Column(length = 100)
    private String street;
    @Column(length = 100)
    private String zipcode;
}
