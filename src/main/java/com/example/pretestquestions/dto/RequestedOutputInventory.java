package com.example.pretestquestions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestedOutputInventory {
    private String productId;
    private String prodName;
    private Double availQty;
}
