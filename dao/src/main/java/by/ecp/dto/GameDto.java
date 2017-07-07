package by.ecp.dto;

import by.ecp.entity.*;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 07.07.2017.
 */
@Data
@NoArgsConstructor
@ToString
public class GameDto {
    @Getter
    @Setter
    private String nameGame;

    @Getter
    @Setter
    private Long companyId;

    @Getter
    @Setter
    private Long genreId;

    @Getter
    @Setter
    private Long paymentModelId;

    @Getter
    @Setter
    private Long settingId;

    @Getter
    @Setter
    private Long stageId;

    @Getter
    @Setter
    private Long platformsId;
}
