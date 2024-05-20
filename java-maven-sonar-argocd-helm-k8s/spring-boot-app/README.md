# Spring Boot based Java web application
 
This is a simple Sprint Boot based Java application that can be built using Maven. Sprint Boot dependencies are handled using the pom.xml 
at the root directory of the repository.

This is a MVC architecture based application where controller returns a page with title and message attributes to the view.

## Execute the application locally and access it using your browser

Checkout the repo and move to the directory

```
git clone https://github.com/iam-veeramalla/Jenkins-Zero-To-Hero/java-maven-sonar-argocd-helm-k8s/sprint-boot-app
cd java-maven-sonar-argocd-helm-k8s/sprint-boot-app
```

Execute the Maven targets to generate the artifacts

```
mvn clean package
```

The above maven target stroes the artifacts to the `target` directory. You can either execute the artifact on your local machine
(or) run it as a Docker container.

** Note: To avoid issues with local setup, Java versions and other dependencies, I would recommend the docker way. **


### Execute locally (Java 11 needed) and access the application on http://localhost:8080

```
java -jar target/spring-boot-web.jar
```

### The Docker way

Build the Docker Image


```
docker build -t ultimate-cicd-pipeline:v1 .
```

```
docker run -d -p 8010:8080 -t ultimate-cicd-pipeline:v1
```

Hurray !! Access the application on `http://<ip-address>:8010`


## Next Steps

### Configure a Sonar Server locally

```
sudo su -
apt install unzip
adduser sonarqube
```

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/4fd8a7df-9aff-4225-8e96-68f1971c0245)

Use the below commands one by one while proceeding.
```
sudo su - sonarqube
wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-9.4.0.54424.zip
unzip *
chmod -R 755 /home/sonarqube/sonarqube-9.4.0.54424
chown -R sonarqube:sonarqube /home/sonarqube/sonarqube-9.4.0.54424
cd sonarqube-9.4.0.54424/bin/linux-x86-64/
./sonar.sh start
```

Hurray !! Now you can access the `SonarQube Server` on `http://<ip-address>:9000` 
(Can use jenkins ip-address with port 9000)

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/a7fc43df-2dc1-44e6-9c11-9f24576fec1c)


Ensure to add Inbound Rule that allows incoming traffic on port 9000 on the EC2 instance.

Note: Since the sonarqube was installed on the ec2 instance we use the public IP. We can also use private IP when an organization has special VPC for sonarqube server. In that case the network will need to be configured as sonarqube will need access to communicate. For ease we installed SonarQube server on the same EC2 virtual machine instance and it avoids configuration of the networking.

### Login to SonarQube Server
Default Values when the SonarQube server just started:
user: admin
pass: admin

It immediatey asks to update the password.

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/34cd9422-4566-4d8e-afc9-98fa0fb5a718)

### SonarQube Authentication with Jenkins
When Jenkins pipeline is going to run it will need to access SonarQube. We need Jenkins to be able to do that. 

Under the A click on My Account.

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/8c0e36e9-eca8-473e-8c42-c2de36b0dea9)

Then click on Security tab:

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/c75b4f45-0cb9-46a1-ba50-5fb9fe63298e)

Entre token name as 'jenkins' and click Generate.

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/3dd78f5b-6e39-4915-bff6-6814b6faf490)

Copy the generated token.

Go to Jenkins and click on Manage Genkins -> Credentials -> System -> Global credentials 
Click on Add Credentials button

Under Kind select Secret text from the dropdown.
Paste the generated credentials from SonarQube to Secrets here in Jenkins.
ID can be named SonarQube.

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/c59e6db1-1b3c-488b-b06c-e17f4ca0411a)


Click Create

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/ccb0c6a4-920a-409a-ac8d-d289fd742eda)


## Docker Slave Configuration on EC2 Instance

Run the below command to Install Docker

```
sudo apt update
sudo apt install docker.io
```
 
### Grant Jenkins user and Ubuntu user permission to docker deamon.

```
sudo su - 
usermod -aG docker jenkins
usermod -aG docker ubuntu
systemctl restart docker
```

Once you are done with the above steps, it is better to restart Jenkins.

```
http://<ec2-instance-public-ip>:8080/restart
```

The docker agent configuration is now successful.


# CD

Two things are missing from Jenkins to make it run automatically
1. Docker Hub credentials (to pull image if public and push it back to docker hub when completed)
2. Git Hub credentials (to access the repo and to push changes back to repo)

### 1. Docker Hub Credentials

Go to Jenkins and click on Manage Genkins -> Credentials -> System -> Global credentials 
Click on Add Credentials button

Fill the below information

variable name in JenkinsFile is 'docker-cred'. We'll use the ID to match the variable name from JenkinsFile. 

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/7fbc0060-95d9-482b-9e12-6abc7030294b)
