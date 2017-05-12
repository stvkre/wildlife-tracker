import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void monster_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("Chewbacca", 1);
    assertEquals(true, testAnimal instanceof Animal);
  }

// all method to return database entries
  @Test
  public void all_returnsAllInstancesOfAnimal_true() {
    Animal firstAnimal = new Animal("Bear");
    firstAnimal.save();
    Animal secondAnimal = new Animal("Panda");
    secondAnimal.save();
    assertEquals(true, Animal.all().get(0).equals(firstAnimal));
    assertEquals(true, Animal.all().get(1).equals(secondAnimal));
  }

}
