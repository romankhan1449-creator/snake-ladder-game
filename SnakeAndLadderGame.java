import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakeAndLadderGame extends JFrame {
    private static final int BOARD_SIZE = 100;
    private static final int GRID_SIZE = 10;
    
    // Game components
    private JPanel gamePanel;
    private JPanel controlPanel;
    private JButton rollDiceButton;
    private JButton startGameButton;
    private JButton instructionsButton;
    private JLabel diceLabel;
    private JLabel currentPlayerLabel;
    private JLabel positionLabel;
    private JComboBox<String> diceTypeComboBox;
    private JTextArea gameLogArea;
    
    // Game state
    private int[] playerPositions;
    private String[] playerNames;
    private int currentPlayer;
    private int numberOfPlayers;
    private boolean gameStarted;
    private Random random;
    private int selectedDiceType;
    
    // Board graphics
    private JButton[][] boardButtons;
    private Color[] playerColors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    
    // Snakes and Ladders positions
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    
    public SnakeAndLadderGame() {
        initializeGame();
        setupSnakesAndLadders();
        createWelcomeScreen();
    }
    
    private void initializeGame() {
        setTitle("🐍 Snake and Ladder Game 🪜");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        random = new Random();
        gameStarted = false;
        currentPlayer = 0;
        
        // Initialize snakes and ladders
        snakes = new HashMap<>();
        ladders = new HashMap<>();
    }
    
    private void setupSnakesAndLadders() {
        // Traditional Snake positions (head -> tail)
        snakes.put(99, 54);
        snakes.put(95, 67);
        snakes.put(88, 24);
        snakes.put(84, 58);
        snakes.put(80, 19);
        snakes.put(73, 53);
        snakes.put(69, 33);
        snakes.put(64, 36);
        snakes.put(59, 17);
        snakes.put(52, 29);
        snakes.put(41, 20);
        snakes.put(37, 3);
        
        // Traditional Ladder positions (bottom -> top)
        ladders.put(1, 40);
        ladders.put(4, 14);
        ladders.put(9, 31);
        ladders.put(16, 26);
        ladders.put(20, 42);
        ladders.put(28, 84);
        ladders.put(51, 67);
        ladders.put(63, 81);
        ladders.put(71, 91);
        ladders.put(87, 94);
    }
    
    private void createWelcomeScreen() {
        getContentPane().removeAll();
        
        JPanel welcomePanel = new JPanel(new BorderLayout());
        welcomePanel.setBackground(new Color(135, 206, 235));
        
        // Welcome title
        JLabel titleLabel = new JLabel("🎉 Welcome to Snake & Ladder Game! 🎉", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 20, 30, 20));
        
        // Center panel with options
        JPanel centerPanel = new JPanel(new GridLayout(6, 1, 10, 15));
        centerPanel.setBackground(new Color(135, 206, 235));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        
        // Player count selection
        JLabel playerLabel = new JLabel("Select Number of Players:", JLabel.CENTER);
        playerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        playerLabel.setForeground(Color.WHITE);
        
        String[] playerOptions = {"2 Players", "3 Players", "4 Players"};
        JComboBox<String> playerComboBox = new JComboBox<>(playerOptions);
        playerComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Dice type selection
        JLabel diceLabel = new JLabel("Select Dice Type:", JLabel.CENTER);
        diceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        diceLabel.setForeground(Color.WHITE);
        
        String[] diceOptions = {"Standard Dice (1-6)", "Lucky Dice (1-8)", "Power Dice (1-10)"};
        diceTypeComboBox = new JComboBox<>(diceOptions);
        diceTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Buttons
        startGameButton = new JButton("🚀 Start Game");
        startGameButton.setFont(new Font("Arial", Font.BOLD, 16));
        startGameButton.setBackground(new Color(34, 139, 34));
        startGameButton.setForeground(Color.WHITE);
        
        instructionsButton = new JButton("📋 Instructions");
        instructionsButton.setFont(new Font("Arial", Font.BOLD, 16));
        instructionsButton.setBackground(new Color(255, 165, 0));
        instructionsButton.setForeground(Color.WHITE);
        
        centerPanel.add(playerLabel);
        centerPanel.add(playerComboBox);
        centerPanel.add(diceLabel);
        centerPanel.add(diceTypeComboBox);
        centerPanel.add(startGameButton);
        centerPanel.add(instructionsButton);
        
        welcomePanel.add(titleLabel, BorderLayout.NORTH);
        welcomePanel.add(centerPanel, BorderLayout.CENTER);
        
        add(welcomePanel);
        
        // Event listeners
        startGameButton.addActionListener(e -> {
            numberOfPlayers = playerComboBox.getSelectedIndex() + 2;
            selectedDiceType = diceTypeComboBox.getSelectedIndex();
            startGame();
        });
        
        instructionsButton.addActionListener(e -> showInstructions());
        
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void showInstructions() {
        String instructions = """
                🎯 SNAKE AND LADDER GAME INSTRUCTIONS 🎯
                
                📖 How to Play:
                • Each player starts at position 0
                • Roll the dice to move forward on the board
                • First player to reach position 100 wins!
                
                🪜 Ladders:
                • Landing on a ladder bottom takes you UP to the top
                • Ladders help you progress faster
                
                🐍 Snakes:
                • Landing on a snake head takes you DOWN to the tail
                • Avoid snakes to maintain your progress
                
                🎲 Dice Types:
                • Standard Dice: Roll 1-6 (Traditional)
                • Lucky Dice: Roll 1-8 (More movement)
                • Power Dice: Roll 1-10 (Maximum movement)
                
                🏆 Winning:
                • Reach exactly position 100 to win
                • If dice roll takes you beyond 100, you bounce back
                
                🎮 Controls:
                • Click 'Roll Dice' when it's your turn
                • Follow the game log for updates
                
                Good Luck and Have Fun! 🎉
                """;
        
        JTextArea instructionArea = new JTextArea(instructions);
        instructionArea.setEditable(false);
        instructionArea.setFont(new Font("Arial", Font.PLAIN, 12));
        instructionArea.setBackground(new Color(248, 248, 255));
        
        JScrollPane scrollPane = new JScrollPane(instructionArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        
        JOptionPane.showMessageDialog(this, scrollPane, "Game Instructions", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void startGame() {
        getContentPane().removeAll();
        
        // Initialize players
        playerPositions = new int[numberOfPlayers];
        playerNames = new String[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            playerPositions[i] = 0;
            playerNames[i] = "Player " + (i + 1);
        }
        
        gameStarted = true;
        currentPlayer = 0;
        
        createGameBoard();
        
        revalidate();
        repaint();
        
        // Show game start message
        addToGameLog("🎮 Game Started! " + playerNames[currentPlayer] + " goes first!");
        addToGameLog("🎯 Goal: Reach position 100 to win!");
    }
    
    private void createGameBoard() {
        setLayout(new BorderLayout());
        
        // Create game board
        gamePanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE, 2, 2));
        gamePanel.setBackground(Color.BLACK);
        gamePanel.setBorder(BorderFactory.createTitledBorder("Game Board (1-100)"));
        
        boardButtons = new JButton[GRID_SIZE][GRID_SIZE];
        
        // Create board buttons (100 to 1, snake pattern)
        int number = 100;
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 2 == 0) {
                // Left to right
                for (int col = 0; col < GRID_SIZE; col++) {
                    createBoardButton(row, col, number--);
                }
            } else {
                // Right to left
                for (int col = GRID_SIZE - 1; col >= 0; col--) {
                    createBoardButton(row, col, number--);
                }
            }
        }
        
        // Control panel
        controlPanel = new JPanel(new BorderLayout());
        controlPanel.setBorder(BorderFactory.createTitledBorder("Game Controls"));
        
        // Top controls
        JPanel topControls = new JPanel(new FlowLayout());
        rollDiceButton = new JButton("🎲 Roll Dice");
        rollDiceButton.setFont(new Font("Arial", Font.BOLD, 14));
        rollDiceButton.setBackground(new Color(220, 20, 60));
        rollDiceButton.setForeground(Color.WHITE);
        
        diceLabel = new JLabel("Dice: -");
        diceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        currentPlayerLabel = new JLabel("Current: " + playerNames[currentPlayer]);
        currentPlayerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        currentPlayerLabel.setForeground(playerColors[currentPlayer]);
        
        positionLabel = new JLabel("Position: 0");
        positionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        topControls.add(rollDiceButton);
        topControls.add(diceLabel);
        topControls.add(currentPlayerLabel);
        topControls.add(positionLabel);
        
        // Game log
        gameLogArea = new JTextArea(8, 30);
        gameLogArea.setEditable(false);
        gameLogArea.setFont(new Font("Arial", Font.PLAIN, 11));
        gameLogArea.setBackground(new Color(248, 248, 255));
        JScrollPane logScrollPane = new JScrollPane(gameLogArea);
        logScrollPane.setBorder(BorderFactory.createTitledBorder("Game Log"));
        
        controlPanel.add(topControls, BorderLayout.NORTH);
        controlPanel.add(logScrollPane, BorderLayout.CENTER);
        
        // Add dice roll functionality
        rollDiceButton.addActionListener(new DiceRollListener());
        
        add(gamePanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.EAST);
        
        setSize(1000, 700);
        setLocationRelativeTo(null);
        updateBoard();
    }
    
    private void createBoardButton(int row, int col, int number) {
        JButton button = new JButton(String.valueOf(number));
        button.setFont(new Font("Arial", Font.BOLD, 10));
        button.setPreferredSize(new Dimension(50, 50));
        
        // Color coding for special squares
        if (snakes.containsKey(number)) {
            button.setBackground(new Color(255, 182, 193)); // Light red for snake heads
            button.setToolTipText("Snake Head! Goes to " + snakes.get(number));
        } else if (ladders.containsKey(number)) {
            button.setBackground(new Color(144, 238, 144)); // Light green for ladder bottoms
            button.setToolTipText("Ladder Bottom! Goes to " + ladders.get(number));
        } else if (number == 100) {
            button.setBackground(new Color(255, 215, 0)); // Gold for finish
            button.setToolTipText("Finish Line!");
        } else {
            button.setBackground(Color.WHITE);
        }
        
        boardButtons[row][col] = button;
        gamePanel.add(button);
    }
    
    private void updateBoard() {
        // Clear all player markers first
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                JButton button = boardButtons[row][col];
                String text = button.getText();
                // Remove player markers, keep only numbers
                if (text.contains("●")) {
                    button.setText(text.substring(0, text.indexOf("●")).trim());
                }
            }
        }
        
        // Add current player positions
        for (int i = 0; i < numberOfPlayers; i++) {
            if (playerPositions[i] > 0) {
                int[] coords = getCoordinatesForPosition(playerPositions[i]);
                if (coords != null) {
                    JButton button = boardButtons[coords[0]][coords[1]];
                    button.setText(button.getText() + " ●");
                    // Highlight current player
                    if (i == currentPlayer) {
                        button.setBorder(BorderFactory.createLineBorder(playerColors[i], 3));
                    }
                }
            }
        }
        
        // Update labels
        currentPlayerLabel.setText("Current: " + playerNames[currentPlayer]);
        currentPlayerLabel.setForeground(playerColors[currentPlayer]);
        positionLabel.setText("Position: " + playerPositions[currentPlayer]);
    }
    
    private int[] getCoordinatesForPosition(int position) {
        if (position < 1 || position > 100) return null;
        
        int adjustedPos = position - 1;
        int row = 9 - (adjustedPos / 10);
        int col;
        
        if ((9 - row) % 2 == 0) {
            col = adjustedPos % 10;
        } else {
            col = 9 - (adjustedPos % 10);
        }
        
        return new int[]{row, col};
    }
    
    private class DiceRollListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!gameStarted) return;
            
            // Roll dice based on selected type
            int maxDiceValue = 6; // Standard dice
            switch (selectedDiceType) {
                case 1: maxDiceValue = 8; break; // Lucky dice
                case 2: maxDiceValue = 10; break; // Power dice
            }
            
            int diceRoll = random.nextInt(maxDiceValue) + 1;
            diceLabel.setText("Dice: " + diceRoll);
            
            addToGameLog(playerNames[currentPlayer] + " rolled: " + diceRoll);
            
            // Move player
            int oldPosition = playerPositions[currentPlayer];
            int newPosition = oldPosition + diceRoll;
            
            // Check if player goes beyond 100
            if (newPosition > 100) {
                newPosition = 100 - (newPosition - 100); // Bounce back
                addToGameLog("Bounced back from " + (oldPosition + diceRoll) + " to " + newPosition);
            }
            
            playerPositions[currentPlayer] = newPosition;
            
            // Check for snakes and ladders
            if (snakes.containsKey(newPosition)) {
                int snakeTail = snakes.get(newPosition);
                playerPositions[currentPlayer] = snakeTail;
                addToGameLog("🐍 Oops! Snake bite! Moved from " + newPosition + " to " + snakeTail);
            } else if (ladders.containsKey(newPosition)) {
                int ladderTop = ladders.get(newPosition);
                playerPositions[currentPlayer] = ladderTop;
                addToGameLog("🪜 Great! Climbed ladder from " + newPosition + " to " + ladderTop);
            }
            
            // Check for win
            if (playerPositions[currentPlayer] == 100) {
                gameWon();
                return;
            }
            
            // Move to next player
            currentPlayer = (currentPlayer + 1) % numberOfPlayers;
            
            updateBoard();
            addToGameLog(playerNames[currentPlayer] + "'s turn!");
        }
    }
    
    private void gameWon() {
        gameStarted = false;
        rollDiceButton.setEnabled(false);
        
        String winner = playerNames[currentPlayer];
        addToGameLog("🏆🎉 CONGRATULATIONS! " + winner + " WINS! 🎉🏆");
        addToGameLog("🏁 Final Score: " + winner + " reached position 100!");
        
        // Show winning dialog
        String message = String.format("""
                🏆 CONGRATULATIONS! 🏆
                
                Winner: %s
                Final Position: 100
                
                🎯 Game Statistics:
                • Total Players: %d
                • Dice Type Used: %s
                • Winner's Color: %s
                
                🎉 Excellent Game! 🎉
                
                Would you like to play again?
                """, 
                winner, 
                numberOfPlayers,
                diceTypeComboBox.getItemAt(selectedDiceType),
                getColorName(playerColors[currentPlayer])
        );
        
        int choice = JOptionPane.showConfirmDialog(
                this, 
                message, 
                "🏆 WINNER! 🏆", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE
        );
        
        if (choice == JOptionPane.YES_OPTION) {
            createWelcomeScreen();
        } else {
            System.exit(0);
        }
    }
    
    private String getColorName(Color color) {
        if (color == Color.RED) return "Red";
        if (color == Color.BLUE) return "Blue";
        if (color == Color.GREEN) return "Green";
        if (color == Color.YELLOW) return "Yellow";
        return "Unknown";
    }
    
    private void addToGameLog(String message) {
        gameLogArea.append(message + "\n");
        gameLogArea.setCaretPosition(gameLogArea.getDocument().getLength());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new SnakeAndLadderGame();
        });
    }
}

