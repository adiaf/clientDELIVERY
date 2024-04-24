package com.clientDELIVERY.domain.dto;

import java.time.LocalDate;

import com.clientDELIVERY.domain.enums.TimeSlotEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectDeliveryDayAndTimeReq {
   
    @NonNull
    private Long clientId;

    @NonNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate deliveryDate;

    private TimeSlotEnum TimeSlot;

}
