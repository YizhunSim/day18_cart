package vttp.ssf.day18_cart.model;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonString;

public class Item {
  private String name;
  private Integer quantity;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Integer getQuantity() {
    return quantity;
  }
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  // JsonString to Model
  public static Item create(String jsonString){
     StringReader reader = new StringReader(jsonString);
     JsonReader r = Json.createReader(reader);
     return create(r.readObject());
  }

  //Json object to model
  public static Item create(JsonObject jo){
    Item item = new Item();
    item.setName(jo.getString("name"));
    item.setQuantity(jo.getInt("quantity"));
    return item;
  }

  // Model to Json
  public JsonObject toJson(){
    return Json.createObjectBuilder()
    .add("name", name)
    .add("quantity", quantity)
    .build();
  }

  public String toString(){
    return "Items - name: " + name + "quantity: " + quantity + "quantity: " + quantity;
  }
}
