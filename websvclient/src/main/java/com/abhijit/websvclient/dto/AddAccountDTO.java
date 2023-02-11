package com.abhijit.websvclient.dto;

//import io.swagger.v3.oas.annotations.media.Schema;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
//import org.jetbrains.annotations.NotNull;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAccountDTO {

    private AccountType accountType;


    private String customerName;

    private List<String> notes;

    private AccountStatus accountStatus;

    private String region;
}
