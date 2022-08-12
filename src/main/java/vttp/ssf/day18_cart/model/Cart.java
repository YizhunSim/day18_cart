package vttp.ssf.day18_cart.model;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Cart {
  private int id;
  private String cartName;

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getCartName() {
    return cartName;
  }
  public void setCartName(String name) {
    this.cartName = name;
  }

  public static Cart create(String jsonStr) {
    StringReader strReader = new StringReader(jsonStr);
    JsonReader reader = Json.createReader(strReader);
    return create(reader.readObject());
  }

    // Json to Model
  public static Cart create(JsonObject jo){
      Cart cart = new Cart();
      cart.setId(jo.getInt("id"));
      cart.setCartName(jo.getString("name"));
      System.out.println("Final JO object: " + jo);
      return cart;
  }

  // Model to Json
  public JsonObject toJson(Cart cart){
    return Json.createObjectBuilder()
    .add("id", cart.getId())
    .add("name", cart.getCartName())
    .build();
  }

  public String toString(){
    return "Cart - id: " + id + "name: " + cartName ;
  }

}
