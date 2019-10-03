package com.app.foodordering.service;

import com.app.foodordering.dao.Bill;
import com.app.foodordering.dao.UserOrder;

public interface FoodOrderService {

	Integer createorder(UserOrder userOrder);

	Bill getBill(Integer id) throws Exception;

}
