package lab3;

public class Banana extends Fruit implements Peelable {
    private boolean isPeelOff;

    Banana(int sc, int wc, float w) {
        super(sc, wc, w, Color.YELLOW);
        this.isPeelOff = false;
    }

    @Override
    public void peelOff() {
        this.isPeelOff = true;
    }

    @Override
    public boolean hasPeel() {
        return !this.isPeelOff;
    }
}
