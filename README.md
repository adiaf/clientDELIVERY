# Getting Started

### RUNNING THE APP

ClientDeliveryApplication.main function, this will run the spring boot app and expose 2 endpoints /select-delivery-mode and /select-delivery-day-and-time

4 clients already exist in database id(1,2,3,4)

### /select-delivery-mode

REQ JSON BODY
clientId (1 or 2 or 3 or 4)
deliveryMode (DRIVE or DELIVERY or DELIVERY_TODAY or DELIVERY_ASAP)

### /select-delivery-day-and-time

REQ JSON BODY
clientId (1 or 2 or 3 or 4)
deliveryDate (pattern 'dd/MM/yyyy')
TimeSlot (FROM_08_TO_0830, FROM_0830_TO_09,  
 FROM_09_TO_0930, FROM_0930_TO_10,
FROM_10_TO_1030, FROM_1030_TO_11,
FROM_11_TO_1130, FROM_1130_TO_12,
FROM_12_TO_1230, FROM_1230_TO_13,
FROM_13_TO_1330, FROM_1330_TO_14,
FROM_14_TO_1430, FROM_1430_TO_15,
FROM_15_TO_1530, FROM_1530_TO_16,
FROM_16_TO_1630, FROM_1630_TO_17,
FROM_17_TO_1730, FROM_1730_TO_18)
