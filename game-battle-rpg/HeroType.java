public enum HeroType {
    KNIGHT(25, "Pedang"),
    ARCHER(18, "Panah"),
    FIGHTER(20, "Sarung Tangan"),
    FAIRY(22, "Magic Wand");

    private int attackPoint;
    private String weapon;

    HeroType(int attackPoint, String weapon) {
        this.attackPoint = attackPoint;
        this.weapon = weapon;
    }
    
    public int getAttackPoint() {
        return attackPoint;
    }

    public String getWeapon() {
        return weapon;
    }
}