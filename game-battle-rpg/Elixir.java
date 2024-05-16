public class Elixir implements Item {
    @Override
    public void use(Hero hero) {
        hero.recoverHealth(150);
        hero.recoverMP(100);
        System.out.println(hero.getName() + " menggunakan Elixir dan memulihkan 150 HP dan 100 MP!");
    }
}