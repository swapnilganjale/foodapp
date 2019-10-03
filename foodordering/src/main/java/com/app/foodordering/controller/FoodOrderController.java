package com.app.foodordering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.foodordering.dao.Bill;
import com.app.foodordering.dao.UserOrder;
import com.app.foodordering.service.FoodOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class FoodOrderController {

    private static final Logger logger = LogManager.getLogger(FoodOrderController.class);

	@Autowired
	private FoodOrderService foodOrderService;

	
	@PostMapping(path="/createorder")
	public Integer createorder(@RequestBody UserOrder userOrder) {
        logger.info("createorder for table id  =="+userOrder.getTableid());
		return foodOrderService.createorder(userOrder);
	}

	@GetMapping(path = { "getbill/{id}" })
	public Bill getBil(@PathVariable("id") Integer id) throws Exception {
        logger.info("get bill for order id =="+id);
        
		return foodOrderService.getBill(id);
	}
	
	
	@GetMapping(path = { "/test" })
	public String findOne() {
		return "swapnil";
	}
}