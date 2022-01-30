package join.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Album extends HotTracks {

    private String artist;
    private String etc;
}
