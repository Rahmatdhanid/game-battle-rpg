public abstract class Character {
    protected String name;
    protected int healthPoint;
    protected int magicPoint;

    public Character(String name, int level) {
        this.name = name;
        this.healthPoint = level * 100;
        this.magicPoint = level * 50;
    }

    public abstract void attack(Character target);
    public abstract void useSkill(Character target);
    public abstract void defend(int attackPoints);
    public abstract void useItem(Item item);

    public String getName() {
        return name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getMagicPoint() {
        return magicPoint;
    }

    public void setMagicPoint(int magicPoint) {
        this.magicPoint = magicPoint;
    }
}