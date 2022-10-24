package lab3;

public abstract class Fruit {
    int sugarContent;
    int waterContent;
    float weight;
    Color color;

    Fruit(int sc, int wc, float w, Color c) {
        this.sugarContent = sc;
        this.waterContent = wc;
        this.weight = w;
        this.color = c;
    }
}
