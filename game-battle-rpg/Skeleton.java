public class Skeleton extends Foe implements Character {
    private final String senjata = "Pedang";
    private final int attackPoint = 5;

    public Skeleton(String name, int healthPoint, int magicPoint) {
        super(name, "Skeleton", healthPoint, magicPoint);
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public String getSenjata() {
        return senjata;
    }

    public void attack(Character target) {
        if (target instanceof Hero) { // Pastikan target implement interface Armor
            Hero targetHero = (Hero) target;
            targetHero.setHealthPoint(targetHero.getHealthPoint() - this.attackPoint); // Panggil metode defend untuk mengurangi armor HP terlebih dahulu
            System.out.println(this.name + " menyerang " + targetHero.getName() + " dengan " + this.attackPoint + " poin serangan1");
        }
    }

    public void defend(int attackPoint) {
    }

    public void usePotion(int regenerateHP) {
        this.healthPoint += regenerateHP;
        System.out.println("HP +" + regenerateHP + " poin");
    }

    public void useEther(int regenerateMP) {
        this.magicPoint += regenerateMP;
        System.out.println("MP +" + regenerateMP + " poin");
    }
}
