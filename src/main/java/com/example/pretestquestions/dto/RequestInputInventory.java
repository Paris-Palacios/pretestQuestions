package com.example.pretestquestions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestInputInventory {
    private String productId;
    private String prodName;
    private String reqDate;
}
