package sumdu.edu.ua;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    void succesfullCharacterCreationTest(){
        Character testCharacterEmpty = new Character();
        Character testCharacterNamed = new Character("Bilbo");
        Character testCharacterDefined = new Character("Aragorn","Ranger");

        assertEquals(1,testCharacterEmpty.getId());
        assertEquals(2,testCharacterNamed.getId());
        assertEquals(3,testCharacterDefined.getId());

        assertEquals(1,testCharacterEmpty.getLevel());
        assertEquals(1,testCharacterNamed.getLevel());
        assertEquals(1,testCharacterDefined.getLevel());

        assertNull(testCharacterEmpty.getName());
        assertNotNull(testCharacterNamed.getName());

        assertNotEquals(0,testCharacterEmpty.getLevel());
        assertNotEquals(0,testCharacterNamed.getLevel());

        testCharacterEmpty.setName("Frodo");
        assertEquals("Frodo",testCharacterEmpty.getName());
    }

    @Test
    void setIllegalExpTest(){
        Character TNO = new Character();
        assertThrows(IllegalArgumentException.class,()->{TNO.setExp(-1);});
    }

    @Test
    void setIllegalNameTest(){
        Character TNO = new Character();
        assertThrows(IllegalArgumentException.class,()->{TNO.setName("bronzeghoste@gmail.com");});
        assertThrows(IllegalArgumentException.class,()->{new Character("bronzeghoste@gmail.com");});

    }

}
