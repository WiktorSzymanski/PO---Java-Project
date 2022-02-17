package pl.vik.gm.fight_manager;

import pl.vik.gm.animals.Skill;

public interface Actions {
    void attack(Skill skill);
    void heal(Skill skill);
    void buff(Skill skill);
    int regen(int efficiency);
    void afterRoundRegen();
    boolean haveEnergyToMakeThatMove(Skill skill);
    boolean makeMove(Skill skill);

    void useSkill(Skill skill);
}
