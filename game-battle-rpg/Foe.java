public class Foe extends Character implements SkillUser {
    private FoeType type;
    private int level;
    private boolean isWeak;
    private boolean isPoisoned;
    private boolean isSleeping;

    public Foe(String name, FoeType type, int level) {
        super(name, level);
        this.type = type;
        this.level = level; 
        this.healthPoint = level * 80;
        this.magicPoint = level * 40;
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

        if (target instanceof Hero) {
            Hero hero = (Hero) target;
            int damageDealt = type.getAttackPoint();
            System.out.println(name + " menyerang " + hero.getName() + " dengan " + type.getWeapon() + " dan menyebabkan " + damageDealt + " poin damage!");
            hero.defend(damageDealt);
        } else {
            System.out.println("Hanya bisa menyerang Hero!");
        }
    }

    @Override
    public void useSkill(Character target) {
        if (magicPoint < 10) {
            System.out.println(name + " tidak memiliki cukup MP untuk menggunakan skill!");
            return;
        }

        if (target instanceof Hero) {
            Hero hero = (Hero) target;
            int specialDamage = type.getAttackPoint() + 10;

            switch (type) {
                case DRAGON:
                    hero.addWeakness();
                    System.out.println(name + " menggunakan skill 'fire' dan menyebabkan " + specialDamage + " poin damage kepada " + hero.getName() + " serta memberikan status 'Weak'!");
                    break;
                case GOBLIN:
                    hero.addPoison();
                    System.out.println(name + " menggunakan skill 'bite' dan menyebabkan " + specialDamage + " poin damage kepada " + hero.getName() + " serta memberikan status 'Poison'!");
                    break;
                case ELF:
                    hero.addSleep();
                    System.out.println(name + " menggunakan skill 'lullaby' dan menyebabkan " + specialDamage + " poin damage kepada " + hero.getName() + " serta memberikan status 'Sleep'!");
                    break;
                default:
                    System.out.println(name + " menggunakan skill khusus dan menyebabkan " + specialDamage + " poin damage kepada " + hero.getName() + "!");
                    break;
            }
            hero.defend(specialDamage);
            magicPoint -= 10;
        } else {
            System.out.println("Hanya bisa menyerang Hero dengan skill khusus!");
        }
    }

    @Override
    public void defend(int attackPoints) {
        int damageTaken = attackPoints / 2;
        healthPoint -= damageTaken;
        System.out.println(name + " berhasil bertahan dari serangan dan hanya menerima " + damageTaken + " poin damage!");
        if (isPoisoned) {
            int poisonDamage = 10; 
            healthPoint -= poisonDamage;
            System.out.println(name + " terkena racun dan kehilangan " + poisonDamage + " HP setiap siklus!");
        }
    }

    @Override
    public void useItem(Item item) {
        System.out.println(name + " tidak bisa menggunakan item!");
    }

    public FoeType getType() {
        return type;
    }

    public String getName() {
        return name;
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
}
