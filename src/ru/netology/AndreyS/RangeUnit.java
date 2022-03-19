package ru.netology.AndreyS;

public class RangeUnit extends Unit{
    private int attackRange;

    public RangeUnit(String name, int dmg, int hp, int level, int attackRange) {
        super(name, dmg, hp, level);
        this.attackRange = attackRange;
    }

    @Override
    public void attack(Unit target) {
      int dx = target.getX() - getX();
      int dy = target.getY() - getY();
      int sum = dx*dx + dy*dy;
      long distant = Math.round(Math.sqrt(sum));

      if (distant<=attackRange){
          super.attack(target);
      }


    }
}
