package com.example.pretestquestions.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Availability {
    private String storeNo;
    private String productId;
    private Double availQty;
    @JsonFormat(pattern = "yyy-MM-dd")
    private Date date;

    public static List<Availability> getAvailabilities() throws ParseException {

        Availability availability1 = Availability.builder()
                .storeNo("Store001")
                .productId("Prod1")
                .availQty(1.0)
                .date(new SimpleDateFormat("yyyy-MM-dd")
                        .parse("2021-02-19"))
                .build();

        Availability availability2 = Availability.builder()
                .storeNo("Store001")
                .productId("Prod1")
                .availQty(3.0)
                .date(new SimpleDateFormat("yyyy-MM-dd")
                        .parse("2021-02-20"))
                .build();

        Availability availability3 = Availability.builder()
                .storeNo("Store001")
                .productId("Prod1")
                .availQty(0.0)
                .date(new SimpleDateFormat("yyyy-MM-dd")
                        .parse("2021-02-21"))
                .build();

        List<Availability> availabilityList = Arrays.asList(availability1,availability2,availability3);

        return availabilityList;
    }
}
