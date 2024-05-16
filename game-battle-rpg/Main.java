public class Main {
    public static void main(String[] args) {
        Character hero = new Hero("Arthur", HeroType.KNIGHT, 1);
        Character foe = new Foe("Orc", FoeType.ORC, 1);

        System.out.println("Status awal:");
        printStatus(hero);
        printStatus(foe);

        // Hero menyerang Foe dengan serangan biasa
        ((Hero) hero).attack(foe);

        System.out.println("\nSetelah serangan biasa:");
        printStatus(hero);
        printStatus(foe);

        // Hero menggunakan skill khusus
        ((Hero) hero).useSkill(foe);

        System.out.println("\nSetelah menggunakan skill khusus:");
        printStatus(hero);
        printStatus(foe);

        // Foe menyerang Hero
        ((Foe) foe).attack(hero);

        System.out.println("\nSetelah serangan Foe:");
        printStatus(hero);
        printStatus(foe);

        // Membuat dan menggunakan item pada Hero
        Item potion = new Potion();
        ((Hero) hero).useItem(potion);

        System.out.println("\nSetelah menggunakan item:");
        printStatus(hero);
    }

    private static void printStatus(Character character) {
        System.out.println(character.getName() + ": HP = " + character.getHealthPoint() + ", MP = " + character.getMagicPoint());
    }
}
