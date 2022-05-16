package ru.netology.AndreyS;

import java.util.Objects;

public class Unit {

    private String name;
    private int dmg;
    private int hp;
    private int level;
    private int x;
    private int y;
    private boolean isAlive = true;
    private OnValueChangeListener<Integer> onHpChangeListener = null;

    public Unit(String name, int dmg, int hp, int level) {
        this.name = name;
        this.dmg = dmg;
        this.hp = hp;
        this.level = level;

    }

    public Unit() {

    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void attack(Unit target) {
        if (target != this) {
            target.setHp(target.getHp()-dmg) ;
            if (target.hp <= 0) {
                target.isAlive = false;
            }
        }
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (onHpChangeListener != null){
            onHpChangeListener.onChange(hp);
        }
    }

    public void setOnHpChangeListener(OnValueChangeListener<Integer> onHpChangeListener) {
        this.onHpChangeListener = onHpChangeListener;
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

    /**
     * pattern Builder
     * 1 Класс должен быть статическим и внутреним
     * 2 Класс должен иметь копии всех полей
     * 3 Методы установки значений должны начинаться с префикса with или set или без префикса,
     * а также возвращать ссылку на сам Builder (return this;)
     * 4 Должен быть метод build который возвращает объект класса в котором объявлен Builder
     * Плюсы:
     * 1 Переиспользование Builder для создания множества экземпляров объекта
     * 2 Нельзя перепутать свойства
     * Минусы:
     * 1 Можно забыть задать какое либо необходимое свойство
     * 2 Builder нужно прописывать много кода
     */
    public static class Builder {
        private String name;
        private int dmg;
        private int hp;
        private int level;

        public Builder() {
        }
        public Builder withName(String name) {
            this.name = name;
            return this;
        }
        public Builder withHp(int hp) {
            this.hp = hp;
            return this;
        }
        public Builder withDmg(int dmg) {
            this.dmg = dmg;
            return this;
        }
        public Builder withLevel(int level) {
            this.level = level;
            return this;
        }
        public Unit build(){
            return new Unit(name,dmg,hp,level);
        }

    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", dmg=" + dmg +
                ", level=" + level +
                ", x=" + x +
                ", y=" + y +
                ", isAlive=" + isAlive +
                '}'+ '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (dmg != unit.dmg) return false;
        if (hp != unit.hp) return false;
        if (level != unit.level) return false;
        if (x != unit.x) return false;
        if (y != unit.y) return false;
        if (isAlive != unit.isAlive) return false;
        return Objects.equals(name, unit.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + dmg;
        result = 31 * result + hp;
        result = 31 * result + level;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + (isAlive ? 1 : 0);
        return result;
    }
}
