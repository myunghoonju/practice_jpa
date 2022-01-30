package join;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    private String createBy;
    private LocalDateTime createAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;
}
