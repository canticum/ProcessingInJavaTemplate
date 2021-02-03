package mysketch;


/*
 * Copyright 2021 Jonathan Chang, Chun-yien <ccy@musicapoetica.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.KeyValue;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.SoundFile;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class MySketchWithSound extends PApplet {

  PImage p3Img;

  SoundFile alarm;
  SoundFile footstep;

  Media opening;
  MediaPlayer player;
  Timeline fadeIn, fadeOut;

  static {
    com.sun.javafx.application.PlatformImpl.startup(() -> {

    });
  }

  @Override
  public void settings() {

    size(300, 300);
  }

  @Override
  public void setup() {

    background(255);

    opening = new Media(this.getClass().getResource("/joint_stereo_kikuo.mp3").toExternalForm());
    player = new MediaPlayer(opening);
    player.setVolume(0);
    fadeIn = new Timeline(
            new KeyFrame(Duration.seconds(1), new KeyValue(player.volumeProperty(), 0.5)));
    player.setOnPlaying(fadeIn::play);
    player.play();

    fadeOut = new Timeline(
            new KeyFrame(Duration.seconds(5), new KeyValue(player.volumeProperty(), 0)));
    fadeOut.setOnFinished(e -> player.stop());

    footstep = new SoundFile(this, "footstep.mp3");
    System.out.printf("SFSampleRate= %d Hz\n", footstep.sampleRate());
    System.out.printf("SFSamples= %d samples\n", footstep.frames());
    System.out.printf("SFDuration= %f seconds\n", footstep.duration());

    alarm = new SoundFile(this, "Alarm04.wav");

    p3Img = loadImage("nctu.png");
  }

  @Override
  public void draw() {

    if (mousePressed) {
      if (!footstep.isPlaying() && mouseButton == RIGHT) {
        footstep.play();
      }
      if (player.getStatus() == MediaPlayer.Status.PLAYING) {
        fadeOut.play();
      }
      image(p3Img, (width - p3Img.pixelWidth) / 2, (height - p3Img.height) / 2);
    } else {
      background(255);
    }
  }

  @Override
  public void mousePressed() {

    if (!alarm.isPlaying() && mouseButton == LEFT) {
      alarm.play();
    }
  }

  public static void main(String[] args) {

    System.setProperty("sun.java2d.uiScale", "1.0");
    PApplet.main(MySketchWithSound.class);
  }
}
