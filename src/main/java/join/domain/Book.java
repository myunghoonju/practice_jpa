package join.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Book extends HotTracks {

    private String author;
    private String isbn;
}
