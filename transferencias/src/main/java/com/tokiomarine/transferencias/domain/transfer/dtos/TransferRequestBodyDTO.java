package com.tokiomarine.transferencias.domain.transfer.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tokiomarine.transferencias.domain.transfer.Transfer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferRequestBodyDTO {
    private String originAccount;
    private String destinationAccount;
    private BigDecimal value;
        @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate requestedDate;
    private LocalDate scheduledDate;

    public Transfer getTransfer() {
        return new Transfer(this.originAccount, this.destinationAccount, this.value, this.requestedDate, this.scheduledDate);
    }
}
