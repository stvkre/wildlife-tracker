import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Animal {
  private String name;
  private int id;

  public Animal(String name, int animalId) {
  }

  public String getName() {
    return name;
  }

  // defining a save method
  public void save() {
   try(Connection con = DB.sql2o.open()) {
     String sql = "INSERT INTO animals (name) VALUES (:name)";
     con.createQuery(sql)
       .addParameter("name", this.name)
       .executeUpdate()
       .getKey();
   }
 }

 // all method returning database entries
 public static List<Animal> all() {
    String sql = "SELECT * FROM animals";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql)
     .throwOnMappingFailure(false)
     .executeAndFetch(Animal.class);
    }
  }

}
