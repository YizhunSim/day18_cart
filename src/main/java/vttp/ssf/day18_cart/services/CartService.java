package vttp.ssf.day18_cart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.ssf.day18_cart.model.Cart;
import vttp.ssf.day18_cart.repositories.ShoppingcartRepositories;

@Service
public class CartService {
  @Autowired
  private ShoppingcartRepositories shoppingCartRepo;

  public Integer count() {
    return shoppingCartRepo.count();
  }

  public List<String> keys() {
    return shoppingCartRepo.keys();
  }

  // public Optional<Cart> getBoardgameById(Integer id) {
  //       return getUsersCartById(id.toString());
  // }

  public Optional<Cart> getUsers() {
    // System.out.println("getUsers - name: " + name);
    String result = shoppingCartRepo.getUsers();
    System.out.println("getUsers - result: " + result);
    if (null == result)
        return Optional.empty();

    return Optional.of(Cart.create(result));
  }

  public void createNewUser(String name){
    shoppingCartRepo.saveUser(name);
  }
}
