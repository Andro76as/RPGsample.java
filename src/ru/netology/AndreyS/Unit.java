package ru.netology.AndreyS;

public abstract class Unit {
    private String name;
    private int dmg;
    private int hp;
    private int level;
    private int x;
    private int y;
    private boolean isAlive = true;

    public Unit(String name, int dmg, int hp, int level) {
        this.name = name;
        this.dmg = dmg;
        this.hp = hp;
        this.level = level;

    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void attack(Unit target) {
        if (target != this) {
            target.hp -= dmg;
            if (target.hp <= 0) {
                target.isAlive = false;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
