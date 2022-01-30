package com.n11.graduationproject.notification;

import com.n11.graduationproject.dto.response.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class SmsNotificationServiceImpl implements ICustomerSMSNotification{

    @Override
    public void smsSend(CustomerDto customerDto, String message) {
        String phone = customerDto.getPhoneNumber();

        if (phone != null){
            log.info("SMS message send to customer phone number!");
            log.info("SMS: " + message);
            log.info("Customer Phone Number:" + phone);
        }
        else {
            log.error("Customer phone is not found");
        }
    }
}
