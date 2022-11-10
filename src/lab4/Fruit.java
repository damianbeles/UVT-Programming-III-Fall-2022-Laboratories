package lab4;

public abstract class Fruit implements Comparable<Fruit> {
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

    @Override
    public int compareTo(Fruit o) {
        float compareByWeight = this.weight - o.weight;
        int compareBySugarContent = this.sugarContent - o.sugarContent;
        return compareByWeight == 0 ? compareBySugarContent : (int) compareByWeight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "sugarContent=" + sugarContent +
                ", waterContent=" + waterContent +
                ", weight=" + weight +
                ", color=" + color +
                '}';
    }
}
