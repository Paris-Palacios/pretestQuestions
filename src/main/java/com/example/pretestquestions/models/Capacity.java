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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Capacity {
    private String storeNo;
    @JsonFormat(pattern = "yyy-MM-dd")
    private Date date;
    private Double noOfOrdersAccepted;

    public static List<Capacity> getCapacities() throws ParseException {

        Capacity capacity1 = Capacity.builder()
                .storeNo("Store001")
                .date(new SimpleDateFormat("yyyy-MM-dd")
                        .parse("2021-02-19"))
                .noOfOrdersAccepted(0.0)
                .build();

        Capacity capacity2 = Capacity.builder()
                .storeNo("Store001")
                .date(new SimpleDateFormat("yyyy-MM-dd")
                        .parse("2021-02-20"))
                .noOfOrdersAccepted(2.0)
                .build();

        Capacity capacity3 = Capacity.builder()
                .storeNo("Store001")
                .date(new SimpleDateFormat("yyyy-MM-dd")
                        .parse("2021-02-21"))
                .noOfOrdersAccepted(2.0)
                .build();

        List<Capacity> availabilityList = Arrays.asList(capacity1,capacity2,capacity3);

        return availabilityList;
    }
}
