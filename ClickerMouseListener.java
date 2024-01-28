/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package cs4.puppytrainer;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
*
* @author Ricardo Muro
*/
public class ClickerMouseListener extends MouseAdapter {
 private final JProgressBar progressBar;
 private final Puppy puppy;
 private final int targetClicks;
 private final JButton returnButton;
 private int currentClicks;
 public ClickerMouseListener(JProgressBar progressBar, Puppy puppy, int targetClicks,
JButton returnButton) {
 this.progressBar = progressBar;
 this.puppy = puppy;
 this.targetClicks = targetClicks;
 this.returnButton = returnButton;
 this.currentClicks = 0;
 }
 @Override
 public void mouseClicked(MouseEvent e) {
 if (currentClicks < targetClicks) {
 currentClicks++;
 puppy.updateTrainingProgress(getTrainingType(), 1);
 progressBar.setValue(currentClicks);
 }
 if (currentClicks == targetClicks) {
 progressBar.setString("Training Completed!");
 returnButton.setEnabled(true);
 }
 }
 private String getTrainingType() {
 if (progressBar == puppy.getGoPottyProgressBar()) {
 return "Go Potty";
 } else if (progressBar == puppy.getNameRecognitionProgressBar()) {
 return "Name Recognition";
 } else if (progressBar == puppy.getLooseLeashWalkingProgressBar()) {
 return "Loose Leash Walking";
 } else if (progressBar == puppy.getComeCommandProgressBar()) {
 return "Come Command";
 } else if (progressBar == puppy.getCrateTrainingProgressBar()) {
 return "Crate Training";
 } else {
 return "";
 }
 }
}