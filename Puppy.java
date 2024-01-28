/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package cs4.puppytrainer;
import javax.swing.JProgressBar;
import java.util.HashMap;
import java.util.Map;
/**
*
* @author Ricardo Muro
*/
public class Puppy {
 private final String name;
 private final Map<String, Integer> trainingProgress;
 private final PuppyTrainer puppyTrainer;
 public Puppy(String name, PuppyTrainer puppyTrainer) {
 this.name = name;
 this.trainingProgress = new HashMap<>();
 this.puppyTrainer = puppyTrainer;
 }
 public void simulateTrainingAction(String trainingType, int clicks) {
 System.out.println(name + " is learning " + trainingType + "!");
 for (int i = 0; i < clicks; i++) {
 simulateClick(trainingType);
 updateTrainingProgress(trainingType, 1);
 }
 System.out.println(name + " has completed " + trainingType + " training!");
 playTrainingAnimation(trainingType);
 }
 private void simulateClick(String trainingType) {
 // Simulate a click during training
 System.out.print("*click* ");
 puppyTrainer.updateProgressBar(trainingType);
 }
 private void playTrainingAnimation(String trainingType) {
 // Implement animation logic here, e.g., displaying animated gifs or playing a video
 // This could involve external libraries or tools depending on the chosen approach
 }
 public void updateTrainingProgress(String trainingType, int clicks) {
 // Update training progress based on the training action
 trainingProgress.put(trainingType, trainingProgress.getOrDefault(trainingType, 0) + clicks);
 }
 public int getTrainingProgress(String trainingType) {
 return trainingProgress.getOrDefault(trainingType, 0);
 }
 public JProgressBar getGoPottyProgressBar() {
 return puppyTrainer.getGoPottyProgressBar();
 }
 public JProgressBar getNameRecognitionProgressBar() {
 return puppyTrainer.getNameRecognitionProgressBar();
 }
 public JProgressBar getLooseLeashWalkingProgressBar() {
 return puppyTrainer.getLooseLeashWalkingProgressBar();
 }
 public JProgressBar getComeCommandProgressBar() {
 return puppyTrainer.getComeCommandProgressBar();
 }
 public JProgressBar getCrateTrainingProgressBar() {
 return puppyTrainer.getCrateTrainingProgressBar();
 }
}
