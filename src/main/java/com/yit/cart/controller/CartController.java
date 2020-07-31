package com.yit.cart.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yit.cart.bean.Cart;
import com.yit.cart.repository.CartDAO;
import com.yit.cart.repository.ProductDAO;

@RestController
@RequestMapping(path = "/api")
public class CartController {
	
	@Resource
    private ProductDAO productDao;
	
	@Resource
    private CartDAO cartDao;
	
	@GetMapping("/getCart")
    public List<Cart> catalog() {
       
        List<Cart> list = cartDao.getCarts();

		return list ;

    }
	
	@PostMapping("/addToCart")
    public int addToCart(@RequestBody String json) {
      
		System.out.println(">>>>>>>> Log Debug message Add to cart ");
        
		System.out.println(">>>>>>>> Add to cart json " + json);
		
		Cart c = Cart.buildJsonToObject(json);

		int s = cartDao.insertCart(c);
		System.out.println("result save Cart " + s);
		return s;
		
    }
	

	@PostMapping("/deleteItem")
    public Object deleteItem(@RequestBody String json) {
      
		System.out.println(">>>>>>>> Log Debug message Delete Cart ");
        
		System.out.println(">>>>>>>> Delete cart json " + json);
		
		Cart c = Cart.buildJsonToObject(json);

		int s = cartDao.deleteItem(c);
	
		if(s == 1) {
			List<Cart> list = cartDao.getCarts();

			return list;
		}
		System.out.println("result delete Cart " + s);
		return s;
		
    }
	
}
