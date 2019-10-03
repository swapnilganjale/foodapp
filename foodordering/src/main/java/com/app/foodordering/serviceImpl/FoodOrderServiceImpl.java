package com.app.foodordering.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.foodordering.dao.Bill;
import com.app.foodordering.dao.OrderDetails;
import com.app.foodordering.dao.ProductDetais;
import com.app.foodordering.dao.UserOrder;
import com.app.foodordering.model.Menu;
import com.app.foodordering.model.Order;
import com.app.foodordering.model.Product;
import com.app.foodordering.repository.MenuRepository;
import com.app.foodordering.repository.OrderRepository;
import com.app.foodordering.service.FoodOrderService;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Integer createorder(UserOrder userOrder) {
		
		Order order=new Order();
		order.setTableid(userOrder.getTableid());
		order.setDate(LocalDateTime.now());
		
		List<Product> productlist=new ArrayList<>();
		
		for (ProductDetais productDetais : userOrder.getProductDetais()) {
			Product product=new Product();
			product.setProductcode(productDetais.getProductcode());
			product.setQuantity(productDetais.getQuantity());
			product.setOrders(order);
			productlist.add(product);

		}
		
		order.setProduct(productlist); 
	
		
		Order orderDb=orderRepository.save(order);
		
		System.out.println("Order DB === "+orderDb.getId());
		
		
		return orderDb.getId();
	}

	@Override
	public Bill getBill(Integer id) throws Exception {
		 
		Optional<Order> order=orderRepository.findById(id);
		Bill  bill=new Bill();

		if(order.isPresent()) {
			
			
			bill.setOrderid(id);
			bill.setTableid(order.get().getTableid());
			bill.setDate(order.get().getDate());
			
			List<OrderDetails> list=new ArrayList<>();
			
			Float total = 0.0f;
			for (Product product : order.get().getProduct()) {
				
				OrderDetails od=new OrderDetails();
				
				Menu menu=getMenuById(product.getProductcode());
				od.setProductname(menu.getProductname());
				od.setPrice(menu.getPrice());
				od.setQuantity(product.getQuantity());
				list.add(od);
				total+=addToTotal(menu.getPrice(),product.getQuantity());
			}
			
			bill.setTotal(total);
			bill.setOrderDetails(list);
			
		}else {
			throw new Exception("Not able to create bill of id == "+id);
		}
		return bill;
	}

	private Float addToTotal(Float price, Integer quantity) {
		
		return quantity * price;
	}

	@Autowired
	MenuRepository menuRepository;
	private Menu getMenuById(Integer productcode) {
	 
		 return menuRepository.findById(productcode).get();
	}

}
