import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void monster_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("Bear", 1);
    assertEquals(true, testAnimal instanceof Animal);
  }

  @Test
    public void save_insertsObjectIntoDatabase_Animal() {
      Animal testAnimal = new Animal("name");
      testAnimal.save();
      assertTrue(Animal.all().get(0).equals(testAnimal));
    }
  }
