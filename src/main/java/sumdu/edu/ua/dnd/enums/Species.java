package sumdu.edu.ua.dnd.enums;

public enum Species {

    HUMAN(0){
        public int maxage(){
            return 100;
        }
    }, ELF(1){
        public int maxage(){
            return 1000;
        }
    }, DWARF(2){
    public int maxage(){
        return 600;
    }};

    private final int id;

    Species(int i) {
            this.id = i;
        }

        public void printCreed(){
            switch(this.id){
                case 0: {System.out.println("Aerendil!");break;}
                case 1: {System.out.println("Elbereth!");break;}
                case 2: {System.out.println("GOLD!!!");break;}
            }
        }

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                '}';
    }
}

