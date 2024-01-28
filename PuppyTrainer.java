/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
license
*/
package cs4.puppytrainer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
*
* @author Ricardo Muro
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class PuppyTrainer {
 private final JFrame mainFrame;
 private final JTextField nameField;
 private final JButton startButton;
 private final JButton exitButton;
 private final JProgressBar goPottyProgressBar;
 private final JProgressBar nameRecognitionProgressBar;
 private final JProgressBar looseLeashWalkingProgressBar;
 private final JProgressBar comeCommandProgressBar;
 private final JProgressBar crateTrainingProgressBar;
 private final JButton returnButton; // Button to return to the main menu during training
 private int completedTrainings; // Counter for completed trainings
 private final JPanel progressPanel; // Declare progressPanel as a class-level variable
 public PuppyTrainer() {
 mainFrame = new JFrame("Puppy Trainer Game");
 mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 mainFrame.setSize(500, 400);
 // Introduction Panel
 JPanel introPanel = new JPanel();
 introPanel.setLayout(new BoxLayout(introPanel, BoxLayout.PAGE_AXIS));
 JLabel titleLabel = new JLabel("Puppy Trainer Simulation Game");
 JLabel descLabel = new JLabel("Welcome to the Puppy Trainer Game! Train your puppy in
various activities.");
 JLabel instructionLabel = new JLabel("Please enter the name of your puppy:");
 nameField = new JTextField();
 startButton = new JButton("Start Training");
 exitButton = new JButton("Exit");
 introPanel.add(titleLabel);
 introPanel.add(descLabel);
 introPanel.add(instructionLabel);
 introPanel.add(nameField);
 introPanel.add(startButton);
 introPanel.add(exitButton);
 // Initialize progressPanel
 progressPanel = new JPanel();
 progressPanel.setLayout(new GridLayout(6, 2));
 goPottyProgressBar = createProgressBar("Go Potty");
 nameRecognitionProgressBar = createProgressBar("Name Recognition");
 looseLeashWalkingProgressBar = createProgressBar("Loose Leash Walking");
 comeCommandProgressBar = createProgressBar("Come Command");
 crateTrainingProgressBar = createProgressBar("Crate Training");
 // Initialize return button for training screens
 returnButton = new JButton("Return to Main Menu");
 returnButton.setEnabled(false); // Disabled initially
 progressPanel.add(goPottyProgressBar);
 progressPanel.add(createClickerButton("Go Potty"));
 progressPanel.add(nameRecognitionProgressBar);
 progressPanel.add(createClickerButton("Name Recognition"));
 progressPanel.add(looseLeashWalkingProgressBar);
 progressPanel.add(createClickerButton("Loose Leash Walking"));
 progressPanel.add(comeCommandProgressBar);
 progressPanel.add(createClickerButton("Come Command"));
 progressPanel.add(crateTrainingProgressBar);
 progressPanel.add(createClickerButton("Crate Training"));
 mainFrame.getContentPane().setLayout(new BorderLayout());
 mainFrame.add(introPanel, BorderLayout.CENTER);
 mainFrame.add(progressPanel, BorderLayout.SOUTH);
 startButton.addActionListener(this::startTraining);
 exitButton.addActionListener(this::handleExitAction);
 mainFrame.setVisible(true);
 }
 private JProgressBar createProgressBar(String label) {
 JProgressBar progressBar = new JProgressBar(0, 20);
 progressBar.setStringPainted(true);
 progressBar.setString(label + ": 0/20");
 return progressBar;
 }
 private JButton createClickerButton(String label) {
 JButton button = new JButton("Click to Train");
 button.addActionListener(e -> startTrainingSimulation(label));
 return button;
 }
 private void startTraining(ActionEvent event) {
 // Retrieve puppy name and create Puppy instance
 String puppyName = nameField.getText();
 Puppy puppy = new Puppy(puppyName, this);
 // Remove introPanel and display progressPanel
 mainFrame.getContentPane().removeAll();
 mainFrame.getContentPane().setLayout(new BorderLayout());
 mainFrame.add(progressPanel, BorderLayout.CENTER);
 // Add action listeners to buttons
 exitButton.addActionListener(this::handleExitAction);
 // Reset completion counter
 completedTrainings = 0;
 // Reset progress bars
 resetProgressBars();
 mainFrame.revalidate();
 }
 private void resetProgressBars() {
 goPottyProgressBar.setValue(0);
 goPottyProgressBar.setString("Go Potty: 0/20");
 nameRecognitionProgressBar.setValue(0);
 nameRecognitionProgressBar.setString("Name Recognition: 0/20");
 looseLeashWalkingProgressBar.setValue(0);
 looseLeashWalkingProgressBar.setString("Loose Leash Walking: 0/20");
 comeCommandProgressBar.setValue(0);
 comeCommandProgressBar.setString("Come Command: 0/20");
 crateTrainingProgressBar.setValue(0);
 crateTrainingProgressBar.setString("Crate Training: 0/20");
 }
 private void startTrainingSimulation(String trainingType) {
 // Disable start button during training
 startButton.setEnabled(false);
 // Disable return button during training
 returnButton.setEnabled(false);
 // Get the corresponding progress bar for the training type
 JProgressBar progressBar = getProgressBarForTraining(trainingType);
 // Start the training simulation with a ClickerMouseListener
 progressBar.addMouseListener(new ClickerMouseListener(progressBar, this));
 mainFrame.revalidate();
 }
 private void handleExitAction(ActionEvent event) {
 System.exit(0);
 }
 public static void main(String[] args) {
 SwingUtilities.invokeLater(PuppyTrainer::new);
 }
 private JProgressBar getProgressBarForTraining(String trainingType) {
 switch (trainingType) {
 case "Go Potty":
 return goPottyProgressBar;
 case "Name Recognition":
 return nameRecognitionProgressBar;
 case "Loose Leash Walking":
 return looseLeashWalkingProgressBar;
 case "Come Command":
 return comeCommandProgressBar;
 case "Crate Training":
 return crateTrainingProgressBar;
 default:
 throw new IllegalArgumentException("Invalid training type: " + trainingType);
 }
 }
 public void trainingCompleted(String trainingType) {
 // Enable start button after training completion
 startButton.setEnabled(true);
 // Increment completed trainings counter
 completedTrainings++;
 // Display completion message
 JOptionPane.showMessageDialog(mainFrame, trainingType + " training completed!",
"Training Completed", JOptionPane.INFORMATION_MESSAGE);
 // Update progress bar string
 JProgressBar progressBar = getProgressBarForTraining(trainingType);
 progressBar.setString(trainingType + ": 20/20");
 // Check if all trainings are completed
 if (completedTrainings == 5) {
 JOptionPane.showMessageDialog(mainFrame, "Congratulations! All trainings
completed.", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
 // Enable return button after completing all trainings
 returnButton.setEnabled(true);
 // Reset completed trainings counter
 completedTrainings = 0;
 }
 }
 public JButton getReturnButton() {
 return returnButton;
 }
 // Added method to update progress bar
 public void updateProgressBar(String trainingType) {
 JProgressBar progressBar = getProgressBarForTraining(trainingType);
 int currentValue = progressBar.getValue();
 progressBar.setValue(currentValue + 1);
 if (currentValue + 1 == progressBar.getMaximum()) {
 progressBar.setString("Training Completed!");
 trainingCompleted(trainingType);
 }
 }
}