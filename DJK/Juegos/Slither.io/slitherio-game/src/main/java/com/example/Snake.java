public class Snake {
    private int x;
    private int y;
    private int length;
    private int[] xPositions;
    private int[] yPositions;
    private String direction;

    public Snake(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
        this.length = 1;
        this.xPositions = new int[100]; // Arbitrary size for the snake's body
        this.yPositions = new int[100];
        this.xPositions[0] = initialX;
        this.yPositions[0] = initialY;
        this.direction = "RIGHT"; // Initial direction
    }

    public void move() {
        // Update the position based on the current direction
        for (int i = length; i > 0; i--) {
            xPositions[i] = xPositions[i - 1];
            yPositions[i] = yPositions[i - 1];
        }

        switch (direction) {
            case "UP":
                y--;
                break;
            case "DOWN":
                y++;
                break;
            case "LEFT":
                x--;
                break;
            case "RIGHT":
                x++;
                break;
        }

        xPositions[0] = x;
        yPositions[0] = y;
    }

    public void grow() {
        length++;
    }

    public boolean checkCollision() {
        // Check for collision with itself or the walls
        for (int i = length; i > 0; i--) {
            if (x == xPositions[i] && y == yPositions[i]) {
                return true; // Collision with itself
            }
        }
        return false; // No collision
    }

    public void setDirection(String newDirection) {
        this.direction = newDirection;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

    public int[] getXPositions() {
        return xPositions;
    }

    public int[] getYPositions() {
        return yPositions;
    }
}