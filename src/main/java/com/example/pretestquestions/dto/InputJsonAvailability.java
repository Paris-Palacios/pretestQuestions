package com.example.pretestquestions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputJsonAvailability {
    private String storeNo;
    private String productId;
    private Double reqQty;
    private String reqDate;
}
