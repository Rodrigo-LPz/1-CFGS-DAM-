# Slither.io Game

This project is a simple implementation of the popular game Slither.io using Java and a graphical user interface. The game allows players to control a snake, consume food, and grow in length while avoiding collisions with other snakes.

## Project Structure

The project is organized as follows:

```
slitherio-game
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   └── example
│   │   │   │       ├── Game.java          // Main game logic
│   │   │   │       ├── GamePanel.java     // GUI for rendering game elements
│   │   │   │       ├── Snake.java         // Represents the snake
│   │   │   │       ├── Food.java          // Represents food items
│   │   │   │       └── Main.java          // Entry point for the application
│   │   └── resources
│   │       └── application.properties      // Configuration properties
├── build.gradle                             // Gradle build configuration
└── README.md                                // Project documentation
```

## Setup Instructions

1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd slitherio-game
   ```

2. **Build the project**:
   Ensure you have Gradle installed, then run:
   ```
   ./gradlew build
   ```

3. **Run the game**:
   After building, you can run the game using:
   ```
   ./gradlew run
   ```

## Gameplay

- Use the arrow keys or WASD to control the snake's direction.
- Eat food to grow longer.
- Avoid colliding with other snakes to stay alive.

## Configuration

You can modify game settings such as window size and frame rate in the `src/main/resources/application.properties` file.

## License

This project is open-source and available for modification and distribution under the MIT License.