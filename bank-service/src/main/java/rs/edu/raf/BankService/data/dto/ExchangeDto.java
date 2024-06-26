package rs.edu.raf.BankService.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeDto {

    private Long id;
    private String exchangeName;
    private String exchangeAcronym;
    private String exchangeMICode;
    private String polity;
    private String currency;
    private Integer timeZone;

}
