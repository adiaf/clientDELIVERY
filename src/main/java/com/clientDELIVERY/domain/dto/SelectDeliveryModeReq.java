package com.clientDELIVERY.domain.dto;

import com.clientDELIVERY.domain.enums.DeliveryModeEnum;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectDeliveryModeReq {
   
    @NonNull
    private Long clientId;

    @NonNull
    private DeliveryModeEnum deliveryMode;

}
