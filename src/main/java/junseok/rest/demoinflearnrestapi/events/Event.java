package junseok.rest.demoinflearnrestapi.events;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id")
@Entity
public class Event {

    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location;
    private int basePrice;
    private int maxPrice;
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;
    @Enumerated(EnumType.STRING)    // 기본타입 EnumType.ORDINAL 을 쓰면 순서에 따라 숫자값이 저장 됨. 나중에 혹시라도 Enum의 순서가 바뀌면 데이터가 완전히 꼬일 수 있기 때문에
    private EventStatus eventStatus;
}
