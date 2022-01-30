package join.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Movie extends HotTracks {

    private String director;
    private String actor;
}
