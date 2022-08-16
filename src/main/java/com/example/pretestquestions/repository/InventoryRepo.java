package com.example.pretestquestions.repository;

import com.example.pretestquestions.models.Inventory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class InventoryRepo {
    public static List<Inventory> getInventories(){
               Inventory inventory1 = Inventory.builder()
                       .productId("Prod1")
                       .prodName("Shirt")
                       .UOM("EACH")
                       .availQty(10.0)
                       .availDate(LocalDate.parse("2021-03-20"))
                       .build();
            Inventory inventory2 = Inventory.builder()
                    .productId("Prod1")
                    .prodName("Shirt")
                    .UOM("EACH")
                    .availQty(20.0)
                    .availDate(LocalDate.parse("2021-03-21"))
                    .build();

            Inventory inventory3 = Inventory.builder()
                    .productId("Prod1")
                    .prodName("Shirt")
                    .UOM("EACH")
                    .availQty(20.0)
                    .availDate(LocalDate.parse("2021-03-28"))
                    .build();

            return Arrays.asList(inventory1, inventory2, inventory3);

    }
}
