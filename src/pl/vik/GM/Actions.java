package pl.vik.GM;

public interface Actions {
    void attack(Skill skill);
    void heal(Skill skill);
    void buff(Skill skill);
    void makeMove();
    void regen();
    boolean haveEnergyToMakeThatMove(Skill skill);
    void useSkill(Skill skill);
}
