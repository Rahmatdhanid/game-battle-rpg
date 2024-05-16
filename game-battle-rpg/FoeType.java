public enum FoeType {
    ORC("Club", 20),
    ELF("Lullaby", 15),
    DWARF("Axe", 22),
    SKELETON("Pedang", 15),
    GOBLIN("Bite", 20),
    DRAGON("Fire Breath", 325);

    private String weapon;
    private int attackPoint;

    FoeType(String weapon, int attackPoint) {
        this.weapon = weapon;
        this.attackPoint = attackPoint;
    }

    public String getWeapon() {
        return weapon;
    }

    public int getAttackPoint() {
        return attackPoint;
    }
}
