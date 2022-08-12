package vttp.ssf.day18_cart.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.ssf.day18_cart.model.Cart;
import vttp.ssf.day18_cart.services.CartService;

@Controller
@RequestMapping(path="/cart")
public class CartController {

  @Autowired
  private CartService cartService;

	@PostMapping
	public String postCart(@RequestBody MultiValueMap<String, String> form
				, Model model) {

		String name = form.getFirst("name");
    Optional<Cart> opt = cartService.getUsers();

    if (opt.isEmpty()){
      // load user cart items
      System.out.println("User exists in Redis");
    } else{
      // save user as new user
      System.out.println("Create new user to redis: " + name);
      cartService.createNewUser(name);
    }

    // Call Redis search for name in database
		if ((null == name) || (name.trim().length() <= 0))
			name = "anonymous";

		model.addAttribute("name", name.toUpperCase());

		return "cart";
	}
}
