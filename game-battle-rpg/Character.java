public interface Character {
    void attack(Character target);
    void defend(int attackPoints);
    void usePotion(int regenerateHP);
    void useEther(int regenerateMP);
}

