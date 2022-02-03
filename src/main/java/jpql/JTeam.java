package jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class JTeam {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team")
    private List<JMember> members = new ArrayList<>();

    @Override
    public String toString() {
        return "JTeam{" +
                "name='" + name + '\'' +
                '}';
    }
}
