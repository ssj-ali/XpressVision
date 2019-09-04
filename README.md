# XpressVision
Android App that detects human face and recognize his/her expressions in run-time. Link to the apk:https://drive.google.com/open?id=1-E-zWAxXNCjuo-5poG91_DZW71znX4jV

## Steps involved in this creation of app:
### A) Prerequiste: Traing and saving the model.

1) Train a keras CNN model on the famous kaggle fer2013 dataset. You can get the dataset from here:https://www.kaggle.com/c/challenges-in-representation-learning-facial-expression-recognition-challenge/data .The data consists of 48x48 pixel grayscale images of faces. It consist of around 28K training images. You can train your model using python on your laptop/server. Note: You can also use tensorflow model (more accurate) instead of keras but keras is high api framework and can also be built over tensorflow.

2) Next important step is converting and saving your model into a single protobuf (.pb) file. This can be done by using tensorflow as a backend. After that optimise your model for an android device. Tutorial for this step: https://www.youtube.com/watch?v=kFWKdLOxykE

### B) Steps Involving Android Studio

1} Learn how to setup opencv in android studio and some basic applications (like opening opencv camera). Please refer these tutorials: https://www.youtube.com/watch?v=ZjZHiPWBiYY&list=PL6v5F68v1ZZzTDq8VI9Jcmb0J99WRrYn4

2) Learn how to detect faces in runtime using opencv haar-cascade classifier.

3) We are deploying a pre-trained model in our android app that receive specific data as input and predicts results. This can be achieved by using tensorflow backend. Follow this two steps

a) Download the .AAR files for tensorflow Inference Interface support. This is made by google that contains all the necessary libraries for the tensorflow to work in Android. Link to the download: https://javalibs.com/artifact/org.tensorflow/tensorflow-android

b) Link it with the Android Studio. See how: http://docs.onemobilesdk.aol.com/android-ad-sdk/adding-aar-files.html

4) We are almost done. Just load the model. Then take the face portion of the human from camera-frame and convert it into float array because the model only takes input as a 2D array of 48x48 size. All this happen in run-time.

5) At last, receive the results from the model and print the result having maximum probability. That's all. 

The code is neat and nicely commented when needed. 
##### please consider starring


Screenshots
![Surprised Woman](https://cdn1.imggmi.com/uploads/2019/9/4/d476a02d8e2c4ad6f4152d994891fde0-full.png)
![Neutal Woman](https://cdn1.imggmi.com/uploads/2019/9/4/2df1c2985864fb6f5c766cf9ea7d0253-full.png)
![Angry Man](https://cdn1.imggmi.com/uploads/2019/9/4/1169f0eb151939397a8efb1751d930ec-full.png)
![Sad Child](https://cdn1.imggmi.com/uploads/2019/9/4/2de2af8e4eb27b03edbf7e94d2747cee-full.png)
![Happy Man](https://cdn1.imggmi.com/uploads/2019/9/4/8023a01dc674d0419fed7f148ba2e4b3-full.png)
