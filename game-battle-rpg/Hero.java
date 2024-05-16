public class Hero extends Character implements SkillUser {
    private HeroType type;
    private int level;
    private boolean isWeak;
    private boolean isPoisoned;
    private boolean isSleeping;

    public Hero(String name, HeroType type, int level) {
        super(name, level);
        this.type = type;
        this.level = level; 
        this.healthPoint = level * 100;
        this.magicPoint = level * 50;
    }

    public void addWeakness() {
        isWeak = true;
    }

    public void addPoison() {
        isPoisoned = true;
    }

    public void addSleep() {
        isSleeping = true;
    }

    public void removeWeakness() {
        isWeak = false;
    }

    public void removePoison() {
        isPoisoned = false;
    }

    public void removeSleep() {
        isSleeping = false;
    }

    public boolean isWeak() {
        return isWeak;
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    @Override
    public void attack(Character target) {
        if (isSleeping) {
            System.out.println(name + " sedang tidur dan tidak dapat menyerang!");
            return;
        }

        if (target instanceof Foe) {
            Foe foe = (Foe) target;
            int damageDealt = type.getAttackPoint();
            if (isWeak) {
                damageDealt *= 1.5;
            }
            System.out.println(name + " menyerang " + foe.getName() + " dengan " + type.getWeapon() + " dan menyebabkan " + damageDealt + " poin damage!");
            foe.defend(damageDealt);
        } else {
            System.out.println("Hanya bisa menyerang Foe!");
        }
    }

    public void useHealingSkill(Character target) {
        if (type != HeroType.FAIRY) {
            System.out.println(name + " tidak memiliki skill healing!");
            return;
        }

        if (!(target instanceof Hero)) {
            System.out.println("Hanya bisa menyembuhkan karakter Hero!");
            return;
        }

        int healAmount = level * 20;
        ((Hero) target).recoverHealth(healAmount);
        System.out.println(name + " menggunakan skill healing dan memulihkan " + healAmount + " HP untuk " + target.getName() + "!");
    }

    public void useRecoverSkill() {
        if (type != HeroType.FAIRY) {
            System.out.println(name + " tidak memiliki skill recover!");
            return;
        }

        int recoverAmount = level * 15;
        this.magicPoint += recoverAmount;
        System.out.println(name + " menggunakan skill recover dan memulihkan " + recoverAmount + " MP!");
    }

    @Override
    public void defend(int attackPoints) {
        int damageTaken = attackPoints;
        if (isWeak) {
            damageTaken *= 1.5; 
            System.out.println(name + " menjadi lemah dan menerima tambahan damage!");
        }
        if (isPoisoned) {
            int poisonDamage = 10; 
            healthPoint -= poisonDamage;
            System.out.println(name + " terkena racun dan kehilangan " + poisonDamage + " HP setiap siklus!");
        }
        healthPoint -= damageTaken;
        System.out.println(name + " menerima " + damageTaken + " poin damage dari serangan lawan!");
    }

    @Override
    public void useSkill(Character target) {
        if (magicPoint < 10) {
            System.out.println(name + " tidak memiliki cukup MP untuk menggunakan skill!");
            return;
        }

        if (target instanceof Foe) {
            Foe foe = (Foe) target;
            int specialDamage = type.getAttackPoint() + 10;
            System.out.println(name + " menggunakan skill khusus dan menyebabkan " + specialDamage + " poin damage kepada " + foe.getName() + "!");
            foe.defend(specialDamage);
            magicPoint -= 10;
        } else {
            System.out.println("Hanya bisa menyerang Foe dengan skill khusus!");
        }
    }

    @Override
    public void useItem(Item item) {
        item.use(this); 
    }

    public String getName() {
        return name;
    }

    public HeroType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getMagicPoint() {
        return magicPoint;
    }

    public void recoverHealth(int amount) {
        healthPoint += amount;
        System.out.println(name + " memulihkan " + amount + " HP!");
    }

    public void recoverMP(int amount) {
        magicPoint += amount;
        System.out.println(name + " memulihkan " + amount + " MP!");
    }
}
