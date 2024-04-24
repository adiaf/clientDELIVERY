package com.clientDELIVERY.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientDELIVERY.domain.dto.SelectDeliveryDayAndTimeReq;
import com.clientDELIVERY.domain.dto.SelectDeliveryModeReq;
import com.clientDELIVERY.domain.entities.Client;
import com.clientDELIVERY.domain.entities.DeliveryMode;
import com.clientDELIVERY.domain.enums.DeliveryModeEnum;
import com.clientDELIVERY.repository.ClientRepository;

@Service
public class ClientDeviveryServiceImpl implements ClientDeviveryService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void selectClientDeliveryMode(SelectDeliveryModeReq req) {

        Optional<Client> clientOp = clientRepository.findById(req.getClientId());

        if (clientOp.isPresent()) {
            Client client = clientOp.get();
            client.setDeliveryMode(DeliveryMode.builder().mode(req.getDeliveryMode()).build());
            clientRepository.save(client);
        }
        throw new RuntimeException("Unknown clientId");
    }

    @Override
    public void selectClientDeliveryDayAndTime(SelectDeliveryDayAndTimeReq req) {

        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        if (req.getDeliveryDate().isBefore(today)) {
            throw new RuntimeException("deliveryDate can only be today or in the future");
        }

    
        Optional<Client> clientOp = clientRepository.findById(req.getClientId());

        if (clientOp.isPresent()) {
            Client client = clientOp.get();

            DeliveryModeEnum deliveryMode = client.getDeliveryMode().getMode();

            int countByDeliveryDateAndTimeSlot = clientRepository.countByDeliveryDateAndTimeSlot(req.getDeliveryDate(), req.getTimeSlot());
            switch (deliveryMode) {
                case DELIVERY,DELIVERY_ASAP:   
                    if(countByDeliveryDateAndTimeSlot > 0)
                        throw new RuntimeException("TimeSlot already selected by another client");
                    
                    break;
                case DELIVERY_TODAY:
                    if (req.getDeliveryDate().isAfter(today)) 
                        throw new RuntimeException("deliveryDate must be today ");
                    
                    if(countByDeliveryDateAndTimeSlot > 0)
                        throw new RuntimeException("TimeSlot already selected by another client");
                    
                    break;
                default:
                    break;
            }

            
            client.setDeliveryDate(req.getDeliveryDate());
            client.setTimeSlot(req.getTimeSlot());

            clientRepository.save(client);
        }
        throw new RuntimeException("Unknown clientId");
    }

}
