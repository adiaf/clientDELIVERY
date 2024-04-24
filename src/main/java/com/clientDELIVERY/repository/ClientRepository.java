package com.clientDELIVERY.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientDELIVERY.domain.entities.Client;
import com.clientDELIVERY.domain.enums.TimeSlotEnum;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    int countByDeliveryDateAndTimeSlot(LocalDate deliveryDate, TimeSlotEnum timeSlot);

}

