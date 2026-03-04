package sumdu.edu.ua;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Character hero = new Character();
        System.out.println(hero.toString());
        Character hero2 = new Character("Argorn@dunedain.me","Ranger");
        System.out.println(hero2.toString());

        Character[] arr= new Character[]{hero,hero2};

        for(Character c: arr) {
            System.out.println(c.toString());
        }
        ArrayList<Object> arr2= new ArrayList<>();
        arr2.add(hero);
        for(Object c: arr2) {
            System.out.println(c.toString());
        }

    }
}