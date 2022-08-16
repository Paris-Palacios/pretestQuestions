package com.example.pretestquestions.services;

import com.example.pretestquestions.dto.InputJsonAvailability;
import com.example.pretestquestions.models.Availability;
import com.example.pretestquestions.models.Capacity;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class CheckAvailabilityAndCapacity {
    @Autowired
    private AvailabilityCapacityServiceManager availabilityCapacityServiceManager;

    public JSONObject checkAvailabilityAndCapacity(InputJsonAvailability inputJsonAvailability) throws ParseException, ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Availability> availabilityFuture = executorService.submit(() -> availabilityCapacityServiceManager.getAvailability(inputJsonAvailability.getStoreNo(),inputJsonAvailability.getReqDate()));

        Future<Capacity> capacityFuture = executorService.submit(() -> availabilityCapacityServiceManager
                .getCapacity(inputJsonAvailability.getStoreNo(),inputJsonAvailability.getReqDate()));

        Availability availability = availabilityFuture.get();
        Capacity capacity = capacityFuture.get();

        executorService.shutdown();

        JSONObject jsonObject = new JSONObject(inputJsonAvailability);
        
        if (availability.getAvailQty() > 0 && capacity.getNoOfOrdersAccepted() > 0 ){
            jsonObject.put("status","Available");
        } else if (capacity.getNoOfOrdersAccepted() == 0.0 || availability.getAvailQty() > 0) {
            jsonObject.put("status","Not Capacity");
        }
        else {
            jsonObject.put("status","404");
        }
        return jsonObject;
    }
}
