package com.n11.graduationproject.notification;

import com.n11.graduationproject.dto.response.CustomerDto;

public interface ICustomerSMSNotification {
    void smsSend(CustomerDto customerDto, String message);
}
