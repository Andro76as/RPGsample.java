package ru.netology.AndreyS;

public class Hunter extends RangeUnit implements Target {
    private Target target;

    public Hunter(String name) {
        super(name, 12, 100, 1, 6);
    }

    @Override
    public void target(Target holder) {
        target = holder;
    }

    public Target getTarget() {
        return target;
    }

}
