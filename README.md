# 🐍🪜 Snake and Ladder Game

A complete **Snake and Ladder** game built in Java Swing with traditional gameplay, multiple dice options, and 4-player support.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

## 🎯 Features

### 🎮 **Game Features**
- ✅ **4-Player Support** (Traditional gameplay)
- ✅ **Welcome Screen** with player setup
- ✅ **Multiple Dice Types** (Standard, Lucky, Power)
- ✅ **Interactive Game Board** (100 squares)
- ✅ **Real-time Player Tracking**
- ✅ **Game Log** with move history
- ✅ **Winner Celebration** with statistics

### 🎲 **Dice Options**
- **Standard Dice:** Roll 1-6 (Traditional)
- **Lucky Dice:** Roll 1-8 (More movement)
- **Power Dice:** Roll 1-10 (Maximum movement)

### 🐍🪜 **Traditional Board Elements**
- **12 Snakes** including the famous 99→54 snake
- **10 Ladders** for quick progression
- **Authentic positions** from traditional Snake & Ladder boards
- **Visual indicators** (Red for snakes, Green for ladders)

### 👥 **Player System**
- **Player 1:** Red ●
- **Player 2:** Blue ●
- **Player 3:** Green ●
- **Player 4:** Yellow ●

## 🚀 Getting Started

### Prerequisites
- **Java 8** or higher
- Any Java IDE (VS Code, Eclipse, IntelliJ) or Command Line

### Installation & Running

1. **Download the files:**
   - `SimpleSnakeLadder.java`
   - Save to your computer

2. **Compile the game:**
   ```bash
   javac SimpleSnakeLadder.java
   ```

3. **Run the game:**
   ```bash
   java SimpleSnakeLadder
   ```

## 🎮 How to Play

### 🎯 **Objective**
Be the first player to reach **position 100** exactly!

### 📖 **Game Rules**
1. **Starting:** All players begin at position 0
2. **Movement:** Roll dice and move forward by the number shown
3. **Turn System:** Players take turns in order (Red → Blue → Green → Yellow)
4. **Winning:** First to reach exactly position 100 wins
5. **Bounce Back:** If dice takes you beyond 100, you bounce back

### 🐍 **Snakes**
- Landing on a snake **head** takes you **DOWN** to its tail
- Snakes are marked in **red** color on the board
- Major snakes: 99→54, 95→67, 88→24, 84→58

### 🪜 **Ladders**
- Landing on a ladder **bottom** takes you **UP** to its top
- Ladders are marked in **green** color on the board  
- Major ladders: 28→84, 71→91, 87→94

## 🖥️ Game Screenshots

### Welcome Screen
- Player selection (2-4 players)
- Dice type selection
- Game instructions

### Game Board
- 10x10 grid (positions 1-100)
- Visual snake and ladder indicators
- Player position markers with colors
- Real-time game log

### Winner Celebration
- Congratulations message
- Complete game statistics
- Play again option

## 🛠️ Technical Details

### **Built With:**
- **Language:** Java
- **GUI Framework:** Swing
- **Design Pattern:** Object-Oriented
- **Compatibility:** Java 8+

### **Key Components:**
- `SimpleSnakeLadder.java` - Complete game implementation
- Welcome screen with game configuration
- Interactive 100-square game board
- Multi-player management system
- Dice rolling with multiple types
- Automatic snake and ladder detection
- Winner celebration system

### **File Structure:**
```
SnakeLadderGame/
├── SimpleSnakeLadder.java    # Main game file
├── README.md                 # This documentation
└── LICENSE                   # MIT License file
```

## 🎨 Game Mechanics

### **Board Layout:**
- Traditional **snake pattern** numbering (100 at top-left, 1 at bottom-left)
- **Authentic snake and ladder positions** from classic boards
- **Color-coded squares:** White (normal), Red (snake heads), Green (ladder bottoms), Gold (finish)

### **Player Movement:**
- **Turn-based system** with visual current player indicator
- **Position tracking** with colored dot markers (●)
- **Automatic snake/ladder detection** and instant movement
- **Bounce-back rule** for moves exceeding position 100

### **Game Features:**
- Real-time move tracking and logging
- Snake bite notifications (🐍)
- Ladder climb celebrations (🪜)
- Clear player turn announcements
- Winner congratulations with statistics (🏆)

## 🎯 Game Controls

- **🎲 Roll Dice:** Click to roll and move
- **📋 Instructions:** View complete game rules
- **🚀 Start Game:** Begin new game with selected settings
- **🔄 Play Again:** Restart after game completion

## 🤝 Contributing

Contributions and suggestions are welcome! Feel free to:

1. **Fork** this repository
2. **Create** a feature branch
3. **Make** your improvements
4. **Submit** a pull request

### **Enhancement Ideas:**
- 🎵 Sound effects for moves and events
- 🎨 Enhanced graphics and animations
- 🤖 Computer player (AI) option
- 💾 Save/load game functionality
- 🏆 Score tracking and leaderboard
- 🌐 Network multiplayer support

## 📝 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

## 🏆 Acknowledgments

- Traditional **Snake and Ladder** board game mechanics
- Classic **Chutes and Ladders** positioning system
- Java **Swing** framework documentation
- Open source community feedback

---

### 🎮 **Ready to Play?**

```bash
# Download, compile and run:
javac SimpleSnakeLadder.java
java SimpleSnakeLadder
```

**Enjoy the classic Snake and Ladder gaming experience!** 🐍🪜🎉

---

⭐ **If you enjoyed this game, please give it a star!** ⭐
