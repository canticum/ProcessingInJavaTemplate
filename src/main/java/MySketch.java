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
import processing.core.*;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class MySketch extends PApplet {

  PImage p3Img;

  @Override
  public void settings() {

    size(300, 300);
  }

  @Override
  public void setup() {

    p3Img = loadImage("nctu.png");
  }

  @Override
  public void draw() {

    background(255);
    if (mousePressed) {
      image(p3Img, (width - p3Img.pixelWidth) / 2, (height - p3Img.height) / 2);
    }
  }

  public static void main(String[] args) {

    System.setProperty("sun.java2d.uiScale", "1.0");
    PApplet.main(MySketch.class);
  }
}
