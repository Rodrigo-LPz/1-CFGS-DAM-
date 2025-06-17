import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Snake snake;
    private Food food;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        snake = new Snake();
        food = new Food();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGame(g);
    }

    private void drawGame(Graphics g) {
        snake.draw(g);
        food.draw(g);
    }

    public void updateGame() {
        snake.move();
        if (snake.checkCollision(food)) {
            snake.grow();
            food.relocate();
        }
        repaint();
    }
}