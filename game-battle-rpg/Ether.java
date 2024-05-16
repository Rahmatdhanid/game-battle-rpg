public class Ether implements Item {
    @Override
    public void use(Hero hero) {
        hero.recoverMP(100);
        System.out.println(hero.getName() + " menggunakan Ether dan memulihkan 100 MP!");
    }
}