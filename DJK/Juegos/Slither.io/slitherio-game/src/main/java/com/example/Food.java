public class Food {
    private int x;
    private int y;

    public Food(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Food generateRandomFood(int width, int height, int unitSize) {
        int x = (int) (Math.random() * (width / unitSize)) * unitSize;
        int y = (int) (Math.random() * (height / unitSize)) * unitSize;
        return new Food(x, y);
    }
}