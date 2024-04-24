package com.clientDELIVERY.Service;

import com.clientDELIVERY.domain.dto.SelectDeliveryDayAndTimeReq;
import com.clientDELIVERY.domain.dto.SelectDeliveryModeReq;

public interface  ClientDeviveryService {

    void selectClientDeliveryMode(SelectDeliveryModeReq req);

    void selectClientDeliveryDayAndTime(SelectDeliveryDayAndTimeReq req);

}
