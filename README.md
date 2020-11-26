# XpressVision
Android App that detects human face and recognize his/her expressions in run-time. Link to the apk:https://drive.google.com/open?id=1-E-zWAxXNCjuo-5poG91_DZW71znX4jV

## Steps involved in this creation of app:
### A) Prerequiste: Traing and saving the model.

1) Train a keras CNN model on the famous kaggle fer2013 dataset. You can get the dataset from here:https://www.kaggle.com/c/challenges-in-representation-learning-facial-expression-recognition-challenge/data .The data consists of 48x48 pixel grayscale images of faces. It consist of around 28K training images. You can train your model using python on your laptop/server. Note: You can also use tensorflow model (more accurate) instead of keras but keras is high api framework and can also be built over tensorflow.

```
def build_model(x, keep_prob, y_, output_node_name):
    x_image = tf.reshape(x, [-1, 48, 48, 1])
    #48*48*1
    conv1 = tf.layers.conv2d(x_image, 64, 3, 1, 'same', activation=tf.nn.relu)
    #48*48*64
    pool1 = tf.layers.max_pooling2d(conv1, 2, 2, 'same')
    #24*24*64
    conv2 = tf.layers.conv2d(pool1, 128, 3, 1, 'same', activation=tf.nn.relu)
    #24*24*128
    pool2 = tf.layers.max_pooling2d(conv2, 2, 2, 'same')
    #12*12*128
    conv3 = tf.layers.conv2d(pool2, 256, 3, 1, 'same', activation=tf.nn.relu)
    #12*12*256
    pool3 = tf.layers.max_pooling2d(conv3, 2, 2, 'same')
    #6*6*256
    flatten = tf.reshape(pool3, [-1, 6*6*256])
    fc = tf.layers.dense(flatten, 1536, activation=tf.nn.relu)
    dropout = tf.nn.dropout(fc, keep_prob)
    logits = tf.layers.dense(dropout, 7)
    outputs = tf.nn.softmax(logits, name=output_node_name)
    
```

2) Next important step is converting and saving your model into a single protobuf (.pb) file. This can be done by using tensorflow as a backend. After that optimise your model for an android device. Tutorial for this step: https://github.com/llSourcell/A_Guide_to_Running_Tensorflow_Models_on_Android

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
![Surprised Woman](https://drive.google.com/uc?export=view&id=1VHBY3Sv4RfdN5y-TJKeIcyq2PzuWlrsk)
![Angry Man](https://drive.google.com/uc?export=view&id=1VNNb_G5OEAYRX7YD6BV2znHPp7gNav-I)
![Sad Child](https://drive.google.com/uc?export=view&id=1VSVm8Y7JWcmM0QeCqbrAKwTtJ9DTmENR)
![Happy Man](https://drive.google.com/uc?export=view&id=1Vk1d8Uum99KdOCFuLIyHiXG1-haYr9Ed)
![Neutal Woman](https://drive.google.com/uc?export=view&id=1VLiIdq5tK0gjU_FnlAY5gBzIcz6roJpe)
