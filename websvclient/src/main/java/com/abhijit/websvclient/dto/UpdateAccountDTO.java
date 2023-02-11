package com.abhijit.websvclient.dto;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateAccountDTO {


    private String customerName;
    private AccountStatus accountStatus;
    private String region;
}
