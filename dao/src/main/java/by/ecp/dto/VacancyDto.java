package by.ecp.dto;

import by.ecp.entity.Company;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by Vinty on 06.07.2017.
 */
@Data
@NoArgsConstructor
@ToString
public class VacancyDto {
    @Getter
    @Setter
    private String nameVacancy;
    @Getter
    @Setter
    private String companyId;
}
