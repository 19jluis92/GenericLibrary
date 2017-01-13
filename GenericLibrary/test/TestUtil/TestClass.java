/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestUtil;
import GenericPackage.GenericUtilities;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

/**
 *
 * @author jluis
 */

public class TestClass {
  @Test
public void testFirstReadGenericObject() 
{
    
    Object data = new Object(){
    public int Id = 1;
    public String Name="name";
        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }
    
    
    };
    String value = GenericUtilities.getValue(data, "id");
    String name = GenericUtilities.getValue(data, "name");
    assertEquals("1", value);
    assertEquals("name", name);
}
}
