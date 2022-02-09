package pl.vik.GM;

public interface Actions {
    void attack(Skill skill);
    void heal(Skill skill);
    void buff(Skill skill);
    void makeMove();
    int regen(int efficiency);
    void afterRoundRegen();

    boolean haveEnergyToMakeThatMove(Skill skill);
    void useSkill(Skill skill);
}
