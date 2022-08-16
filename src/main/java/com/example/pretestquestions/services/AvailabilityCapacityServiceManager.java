package com.example.pretestquestions.services;

import com.example.pretestquestions.models.Availability;
import com.example.pretestquestions.models.Capacity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AvailabilityCapacityServiceManager {

    public Availability getAvailability(String storeNo, String reqDate) throws ParseException {
        Date reqDate2 = new SimpleDateFormat("yyyy-MM-dd")
                .parse(reqDate);

        return Availability.getAvailabilities().stream()
                .filter(availability -> availability.getStoreNo().equalsIgnoreCase(storeNo) &&
                        availability.getDate().compareTo(reqDate2)==0)
                .findFirst()
                .get();

    }

    public Capacity getCapacity(String storeNo, String reqDate) throws ParseException {
        Date reqDate2 = new SimpleDateFormat("yyyy-MM-dd")
                .parse(reqDate);
        return Capacity.getCapacities().stream()
                .filter(capacity -> capacity.getStoreNo().equalsIgnoreCase(storeNo) &&
                        capacity.getDate().compareTo(reqDate2)==0)
                .findFirst()
                .get();
    }
}
