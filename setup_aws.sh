#!/bin/bash

# http://flummox-engineering.blogspot.com/2012/11/how-to-install-play-framework-ubuntu.html
# Steps to install play on AWS

sudo apt-get install default-jre
sudo apt-get install default-jdk
sudo apt-get install scala
sudo apt-get install git
sudo apt-get install mysql-server
sudo apt-get install unzip


# wget http://download.playframework.org/releases/play-2.0.4.zip
wget http://downloads.typesafe.com/play/2.2.0/play-2.2.0.zip

unzip play-2.2.0.zip

sudo mv play-2.2.0 /opt
sudo ln -s /opt/play-2.2.0 /opt/play
sudo ln -s /opt/play/play /usr/local/bin/play

git clone https://github.com/wadeanderson7/SnipStory.git
# Add credentials

play start
#play "start -Dhttp.port=80 -DapplyEvolutions.default=true"
# Alternatively play stage
# 
# Make sure evolutions are set to true
# And db is configured 

# if the console says this is not a play application then you installed correctly. 