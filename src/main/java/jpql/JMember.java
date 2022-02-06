package jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Getter
@Setter
@Entity
@NamedQuery(name = "JMember.findByUsername",
            query = "select m from JMember as m where m.username = :username")
public class JMember {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private JTeam team;

    public void changeTeam(JTeam team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
