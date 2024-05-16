public class Potion implements Item {
    @Override
    public void use(Hero hero) {
        hero.recoverHealth(100);
        System.out.println(hero.getName() + " menggunakan Potion dan memulihkan 100 HP!");
    }
}