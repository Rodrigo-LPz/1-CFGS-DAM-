public class Game {
    private boolean running;
    private Thread gameThread;
    private GamePanel gamePanel;

    public Game() {
        running = false;
        gamePanel = new GamePanel();
    }

    public void start() {
        running = true;
        gameThread = new Thread(this::run);
        gameThread.start();
    }

    public void stop() {
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000.0 / 60.0; // 60 ticks per second
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;

            while (delta >= 1) {
                tick();
                delta--;
            }

            render();
        }
    }

    private void tick() {
        gamePanel.updateGameState();
    }

    private void render() {
        gamePanel.repaint();
    }
}