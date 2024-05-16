public class Weapon {
    private String name;
    private int attackPoint;

    public Weapon(String name, int attackPoint) {
        this.name = name;
        this.attackPoint = attackPoint;
    }

    public void use(Character character) {
        if (character instanceof Hero) {
            Hero hero = (Hero) character;
            System.out.println(hero.getName() + " menggunakan " + name + " dan mendapatkan " + attackPoint + " poin attack point tambahan!");
        } else {
            System.out.println("Senjata hanya dapat digunakan oleh Hero!");
        }
    }

    public String getName() {
        return name;
    }

    public int getAttackPoint() {
        return attackPoint;
    }
}
