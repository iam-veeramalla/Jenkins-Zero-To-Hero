#!/bin/bash

# Install Java latest version on ubuntu server.

sudo DEBIAN_FRONTEND=noninteractive apt install openjdk-18-jre -y ; sudo java -version ; sudo -i ;

#Java is installed with version of jdk 17.

# Install Jenkins on ubuntu server 22 and latest.
# import the Jenkins GPG key from Jenkins repository
curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key | sudo tee \
/usr/share/keyrings/jenkins-keyring.asc > /dev/null ;

# configure Jenkins repository to the sources list file echo and tee command.
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
/etc/apt/sources.list.d/jenkins.list > /dev/null ;

# update the system’s package list.
DEBIAN_FRONTEND=noninteractive apt update -y ;

# And install Jenkins.
DEBIAN_FRONTEND=noninteractive apt install -y jenkins ;

# Once the installation is complete, Jenkins should start automatically. To confirm this, run the command:
systemctl status jenkins;

# Jenkins setup done successful run command http://<public ip address>:8080 and open port no. 8080 under Security group as per your need.

# Install Docker Slave Configuration on ubuntu 22 and latest server
# Run the below command to Install Docker
DEBIAN_FRONTEND=noninteractive apt update;
DEBIAN_FRONTEND=noninteractive apt install docker.io -y;

#Grant Jenkins user and Ubuntu user permission to docker daemon.
usermod -aG docker jenkins ; 
usermod -aG docker ubuntu ; 
systemctl restart docker ; 
systemctl status docker ;

# Docker Slave setup done.


#!/bin/bash

# Install Sonarqube server setup on ubuntu 22 and latest.
#Update the server and install dependencies package.
DEBIAN_FRONTEND=noninteractive apt update -y;
DEBIAN_FRONTEND=noninteractive apt install unzip -y;

# Add sonarqube user and install sonarqube with latest community version.
# Define username as sonarqube, here you can change the password as per your need.
username=sonarqube
password=admin
# Now create the user with password
adduser $username --disabled-password --gecos Sonarqube;
echo "$username:$password" | chpasswd ;
echo Sonarqube: $username has been created with password: $password ;
# Sonarqube: sonarqube has been created with password: admin
sudo su - sonarqube ;

#Install sonarqube and start the setup.
sudo wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-9.9.3.79811.zip ;
sudo unzip * ;
sudo chmod -R 755 /home/sonarqube/sonarqube-9.4.0.54424 ; 
sudo chown -R sonarqube:sonarqube /home/sonarqube/sonarqube-9.4.0.54424 ; 
sudo cd sonarqube-9.4.0.54424/bin/linux-x86-64/ ; 
sudo ./sonar.sh start

# Sonarqube steup is done, login onto your browser with URL http://<public-ip-address>:9000 and allow 9000 port in your security group.
# Username and password is admin to first time login.
