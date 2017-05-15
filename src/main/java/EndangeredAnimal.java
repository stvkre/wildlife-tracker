import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class EndangeredAnimal {
  private String name;
  private String health;
  private int id;
  private String age;

  public EndangeredAnimal(String name, String health, int animalId, int age) {
  }

  public String getName() {
    return name;
  }

  public String getHealth() {
    return health;
  }

  public int getAnimalId() {
    return animalId;
  }

  public int getAge() {
    return age;
  }

  // defining a save method
  @Override
 public void save() {
   try(Connection con = DB.sql2o.open()) {
     String sql = "INSERT INTO animals (name, health, age) VALUES (:name, :health, :age)";
     this.id = (int) con.createQuery(sql, true)
       .addParameter("name", this.name)
       .addParameter("health", this.health)
       .addParameter("age", this.age)
       .executeUpdate()
       .getKey();
   }
 }

 // all method returning database entries
 public static List<Animal> all() {
    String sql = "SELECT * FROM animals";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Animal.class);
    }
  }

}
