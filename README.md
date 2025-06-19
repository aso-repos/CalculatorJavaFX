
# 🧮 CalculatorJavaFX

A clean, retro-style desktop calculator built using Java and JavaFX, inspired by the Casio Personal M-1 calculator. This project bridges the gap between structured Java coursework and real-world GUI development — applying design, coding, and problem-solving skills into a fully functional, visually polished app.

## 🎯 Project Overview
- Transition from academic Java training into desktop GUI development
- Reinforce object-oriented principles and modular JavaFX design
- Develop practical GitHub workflow and open-source portfolio experience
- Showcase a retro calculator with precise UI, custom font, and LED-style glow effects

## ⚙️ Key Features
- ✅ Custom-designed CalculatorDigits.ttf font
- ✅ Decimal point manually spaced and aligned using FontForge
- ✅ LED-style display glow effect with duplicate label + drop shadow
- ✅ Accurate retro calculator layout using Scene Builder
- ✅ Clean window with fixed dimensions and custom icon
- ✅ GitHub-tracked learning and version control throughout

## 📐 Design Inspiration
- Based on the Casio Personal M-1 calculator — a personal keepsake
- All digits (0–9 and dot) were redrawn in CorelDRAW and converted to vector
- Final font manually kerned and spaced in FontForge for 1:1 alignment
- Display layered with StackPane for foreground + glow labels
- LED glow achieved using subtle Gaussian dropshadow in CSS

## 🔧 Technologies Used
- Java 21 (Azul ZuluFX JDK)
- JavaFX 21 (via GluonHQ SDK)
- IntelliJ IDEA CE 2024.1
- Scene Builder (for layout construction)
- CorelDRAW + FontForge (custom font design)
- Git & GitHub (version control and portfolio publishing)

## 🚀 How to Run

1. Clone the repository:
```bash
git clone https://github.com/aso-repos/CalculatorJavaFX.git
```

2. Open the project in IntelliJ IDEA

3. Configure JavaFX VM options:
```bash
--module-path "C:/Java/javafx-sdk-21/lib" --add-modules javafx.controls,javafx.fxml
```

4. Run `Main.java`

The calculator window will appear with LED-style display and turquoise digit glow.

## 🖼️ Visual Showcase

<p align="center">
  <img src="./images/calculator_reference.png" alt="Original Calculator" width="45%">
  &nbsp; &nbsp; &nbsp;
  <img src="./images/calculator_glow.png" alt="LED-style Glow" width="45%">
</p>

- **Font Design Preview**  
  ![Vector Digits](./images/custom_font_preview.png)

<p align="center">
  <img src="./images/calculator_real.png" alt="Original Casio Calculator Scan" width="45%">
  &nbsp; &nbsp; &nbsp;
  <img src="./images/calculator_scene_builder.png" alt="Scene Builder Replica" width="45%">
</p>

**Button Layout Detail**  
- Left: High-resolution scan of the original Casio Personal M-1 calculator
- Right: JavaFX recreation using Scene Builder and real JavaFX buttons  
  → Labels designed in CorelDRAW and exported as PNG  
  → Buttons styled with CSS for bevel and hover behavior  
  → Buttons are functional JavaFX elements, PNGs are for visual authenticity only

## 🧱 Current Display Styling

```css
.digit-display {
    -fx-font-family: "CalcFont";
    -fx-font-size: 24px;
    -fx-text-fill: #61faf8; /* Turquoise screenfont color */
}

.digit-glow {
    -fx-font-family: "CalcFont";
    -fx-font-size: 24px;
    -fx-text-fill: #61faf8; /* Turquoise screenfont color */
    -fx-effect: dropshadow(gaussian, #e7ffff, 43, 0.03, 0, 0);
}

.calc-button {
    -fx-background-color: #d4cec0; /* Button Background color */
    -fx-background-radius: 11px;
}

.calc-button:hover {
    -fx-background-color: #bab5a8;
    -fx-effect: dropshadow(gaussian, #00000033, 4, 0.1, 0, 1);
}

.orange-button {
    -fx-background-color: #ec7e0f;
    -fx-background-radius: 7px;
    -fx-effect: innershadow(gaussian, #ffb771, 2, 0.1, -1, 1);
}

.orange-button:hover {
    -fx-background-color: #d97412;
    -fx-effect: dropshadow(gaussian, #00000033, 4, 0.1, 0, 1);
    -fx-effect: innershadow(gaussian, #ffb771, 2, 0.1, -1, 1);
}

.dark-button {
    -fx-background-color: #252f34;
    -fx-background-radius: 5px;
    -fx-effect: innershadow(gaussian, #5e6467, 1, 0.1, -1, 1);
}

.dark-button:hover {
    -fx-background-color: #1f2528;
    -fx-effect: dropshadow(gaussian, #00000033, 4, 0.1, 0, 1);
    -fx-effect: innershadow(gaussian, #5e6467, 1, 0.1, -1, 1);
}
```

## 🛠️ Development Roadmap
- ✅ Initial JavaFX calculator frame
- ✅ Custom font creation and embedding
- ✅ Digit/decimal alignment and glow overlay
- ✅ Button placement and PNG font overlays
- ⬜ Interactive digit button input
- ⬜ Add arithmetic operations (+, −, ×, ÷)
- ⬜ Implement clear and backspace functionality
- ⬜ Add keyboard support and button hover effects
- ⬜ Integrate scientific and memory functions

## 🎓 Learning Journey
This project is a culmination of:
- 📘 Java Specialization (Duke University / UC San Diego)
- 🎥 Bro Code’s JavaFX YouTube series
- 🛠️ Self-taught Git and open-source publishing
- ✏️ Custom font creation using CorelDRAW and FontForge

## 📚 Related Projects
- 🔁 BroCourse – JavaFX tutorial mirror project
- 🐍 Early Python UI Projects – Available in GitHub archive

## 👋 Contact
**Wessel Wessels**  
📫 LinkedIn *(insert your link)*  
📁 GitHub: [aso-repos](https://github.com/aso-repos)

## 📄 License
Personal learning project — no license applied. The custom font “CalculatorDigits” was created by Wessel and is intended for non-commercial use.
