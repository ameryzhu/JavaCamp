package com.example.week11;

import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService {
    public void handlerOrder(String orderInfo){
        try {
            System.out.println("handling order ..."+orderInfo);
            Thread.sleep(1000);
            System.out.println("finish order: "+orderInfo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
