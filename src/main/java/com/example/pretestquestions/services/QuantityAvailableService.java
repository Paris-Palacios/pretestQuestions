package com.example.pretestquestions.services;

import com.example.pretestquestions.dto.RequestInputInventory;
import com.example.pretestquestions.dto.RequestedOutputInventory;
import com.example.pretestquestions.models.Inventory;
import com.example.pretestquestions.repository.InventoryRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityAvailableService {

    final static Long range = 10L;
    public RequestedOutputInventory quantityAvailable(RequestInputInventory requestInputInventory){

        LocalDate reqDate = LocalDate.parse(requestInputInventory.getReqDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String reqProductId = requestInputInventory.getProductId();

        List<Inventory> filteredInventoriesWithinRange = getFilteredInventoriesWithinDate(reqProductId,reqDate);

        Double sumQty = filteredInventoriesWithinRange.stream()
                .map(inventory -> inventory.getAvailQty())
                .reduce((aDouble, aDouble2) -> aDouble + aDouble2)
                .get();

        return RequestedOutputInventory.builder()
                .productId(reqProductId)
                .prodName(requestInputInventory.getProdName())
                .availQty(sumQty)
                .build();
    }

    public List<Inventory> getInventories(){
        return InventoryRepo.getInventories();
    }

    public List<Inventory> getFilteredInventoriesWithinDate(String productId, LocalDate reqDate ) {

        LocalDate dateInRange = reqDate.plusDays(range);

        return getInventories().stream()
                .filter(inventory -> inventory.getProductId().equalsIgnoreCase(productId) &&
                        inventory.getAvailDate().isBefore(dateInRange) && inventory.getAvailDate().isAfter(reqDate) )
                .collect(Collectors.toList());
    }
}
