package sumdu.edu.ua.dnd;

public enum DnDClass {
    WIZARD("Wizard",6,"INT"),ROGUE("Rogue",8,"DEX"), BARD("Bard",8,"CHA"),BARBARIAN("Barbarian",10,"STR");

    private final String title;
    private final int dice;
    private final String stat;

    DnDClass(String title, int dice, String stat) {
        this.title=title;
        this.dice=dice;
        this.stat=stat;
    }

    public String getTitle() {
        return title;
    }

    public int getDice() {
        return dice;
    }

    public String getStat() {
        return stat;
    }
}
