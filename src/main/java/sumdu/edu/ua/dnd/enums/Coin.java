package sumdu.edu.ua.dnd.enums;

public enum Coin {
    COPPER(1), SILVER(10), GOLD(100);

    final int value;
    Coin(int i) {
        this.value = i;
    }

    
}
