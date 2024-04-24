package com.clientDELIVERY.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clientDELIVERY.Service.ClientDeviveryService;
import com.clientDELIVERY.domain.dto.SelectDeliveryDayAndTimeReq;
import com.clientDELIVERY.domain.dto.SelectDeliveryModeReq;

@RestController
public class ClientDeviveryController {

    @Autowired
    private ClientDeviveryService clientDeviveryService;

    @PostMapping("select-delivery-mode")
    public ResponseEntity<String> selectDeliveryMode(@RequestBody @Validated SelectDeliveryModeReq req) {
        clientDeviveryService.selectClientDeliveryMode(req);
        return ResponseEntity.ok().build();
    }

    @PostMapping("select-delivery-day-and-time")
    public ResponseEntity<String> selectDeliveryDayAndTime(@RequestBody @Validated SelectDeliveryDayAndTimeReq req) {
        clientDeviveryService.selectClientDeliveryDayAndTime(req);
        return ResponseEntity.ok().build();
    }

}
