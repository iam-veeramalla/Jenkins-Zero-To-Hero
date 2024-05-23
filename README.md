# Jenkins-Zero-To-Hero

Are you looking forward to learn Jenkins right from Zero(installation) to Hero(Build end to end pipelines)? then you are at the right place. 

## Installation on EC2 Instance

YouTube Video ->
https://www.youtube.com/watch?v=zZfhAXfBvVA&list=RDCMUCnnQ3ybuyFdzvgv2Ky5jnAA&index=1


![Screenshot 2023-02-01 at 5 46 14 PM](https://user-images.githubusercontent.com/43399466/216040281-6c8b89c3-8c22-4620-ad1c-8edd78eb31ae.png)

Install Jenkins, configure Docker as agent, set up cicd, deploy applications to k8s and much more.

## AWS EC2 Instance

- Go to AWS Console
- Instances(running)
- Launch instances

<img width="994" alt="Screenshot 2023-02-01 at 12 37 45 PM" src="https://user-images.githubusercontent.com/43399466/215974891-196abfe9-ace0-407b-abd2-adcffe218e3f.png">


# CI

### Install Jenkins.

Pre-Requisites:
 - Java (JDK)

### Run the below commands to install Java and Jenkins

Install Java

```
sudo apt update
sudo apt install openjdk-11-jre
```

Verify Java is Installed

```
java -version
```

Now, you can proceed with installing Jenkins

```
curl -fsSL https://pkg.jenkins.io/debian/jenkins.io-2023.key | sudo tee \
  /usr/share/keyrings/jenkins-keyring.asc > /dev/null
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
  https://pkg.jenkins.io/debian binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt-get update
sudo apt-get install jenkins
```

**Note: ** By default, Jenkins will not be accessible to the external world due to the inbound traffic restriction by AWS. Open port 8080 in the inbound traffic rules as show below.

- EC2 > Instances > Click on <Instance-ID>
- In the bottom tabs -> Click on Security
- Security groups
- Add inbound traffic rules as shown in the image (you can just allow TCP 8080 as well, in my case, I allowed `All traffic`).

<img width="1187" alt="Screenshot 2023-02-01 at 12 42 01 PM" src="https://user-images.githubusercontent.com/43399466/215975712-2fc569cb-9d76-49b4-9345-d8b62187aa22.png">


### Login to Jenkins using the below URL:

http://<ec2-instance-public-ip-address>:8080    [You can get the ec2-instance-public-ip-address from your AWS EC2 console page]

Note: If you are not interested in allowing `All Traffic` to your EC2 instance
      1. Delete the inbound traffic rule for your instance
      2. Edit the inbound traffic rule to only allow custom TCP port `8080`
  
After you login to Jenkins, 
      - Run the command to copy the Jenkins Admin Password - `sudo cat /var/lib/jenkins/secrets/initialAdminPassword`
      - Enter the Administrator password
      
<img width="1291" alt="Screenshot 2023-02-01 at 10 56 25 AM" src="https://user-images.githubusercontent.com/43399466/215959008-3ebca431-1f14-4d81-9f12-6bb232bfbee3.png">

### Check if Jenkins is running:

```
ps -ef | grep jenkins
```

Output:
![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/a0cac2c9-1493-4c0a-9aa3-2e21722fbc71)

### Click on Install suggested plugins

<img width="1291" alt="Screenshot 2023-02-01 at 10 58 40 AM" src="https://user-images.githubusercontent.com/43399466/215959294-047eadef-7e64-4795-bd3b-b1efb0375988.png">

Wait for the Jenkins to Install suggested plugins

<img width="1291" alt="Screenshot 2023-02-01 at 10 59 31 AM" src="https://user-images.githubusercontent.com/43399466/215959398-344b5721-28ec-47a5-8908-b698e435608d.png">

Create First Admin User or Skip the step [If you want to use this Jenkins instance for future use-cases as well, better to create admin user]

<img width="990" alt="Screenshot 2023-02-01 at 11 02 09 AM" src="https://user-images.githubusercontent.com/43399466/215959757-403246c8-e739-4103-9265-6bdab418013e.png">

Jenkins Installation is Successful. You can now starting using the Jenkins 

<img width="990" alt="Screenshot 2023-02-01 at 11 14 13 AM" src="https://user-images.githubusercontent.com/43399466/215961440-3f13f82b-61a2-4117-88bc-0da265a67fa7.png">


## Create Jenkins Pipeline and Code to Run the Pipeline using Jenkinsfile

We can type the entire pipeline steps or have the steps in a Jenksfile and give its path. We already have a Jenkinsfile.
This file can have any name. Notice the capital 'F" in JenkinsFile name.

![1 Pipeline Config](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/41c48e70-39fe-4830-aeab-00285438c46e)


![2 Pipeline Config](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/cf103133-cef3-4e1c-8827-81f414458175)







# Maven Pipeline Plugin
Not needed as Maven in part of the Docker image. If Maven wasn't part of the image we'd need to install the plugin here in Jenkins then. We can create our own images with Maven in it. Currently we're using the one Abhishek provided. To see the image stored at Docker Hub see the jenkinsFile.



# Docker Pipeline Plugin
## Install the Docker Pipeline plugin in Jenkins:

   - Log in to Jenkins.
   - Go to Manage Jenkins > Manage Plugins.
   - In the Available tab, search for "Docker Pipeline".
   - Select the plugin and click the Install button.
   - Restart Jenkins after the plugin is installed (we'll restart after all plugins are installed)
   
<img width="1392" alt="Screenshot 2023-02-01 at 12 17 02 PM" src="https://user-images.githubusercontent.com/43399466/215973898-7c366525-15db-4876-bd71-49522ecb267d.png">

Wait for the Jenkins to be restarted.

# SonarQube Pipeline Plugin
## Install the SonarQube plugin in Jenkins:

   - Go to Manage Jenkins > Manage Plugins.
   - In the Available tab, search for "SonarQube Scanner".
   - Select the plugin and click the Install button.

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/e38a81dd-7cf9-45f6-a73c-fe797583feee)

# SonarQube Installation on EC2 Instance
It can be installed on any server. For an organization it probably will be an internal server and with a private IP address.
For this project we'll install on the EC2 and use the public IP address to access it. 
AWS will need connectivitiy to the SonarQube server. Installing on the same EC2 instance avoids the complexity of configuring the Network, VPC, Ingress, VPC Pairing etc used for communciation between SonarQube server and AWS that has Jenkins server.

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

















## Docker Slave Configuration

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

## Shell Script
No installation needed. We also could user Argo Image Updater but it's not a tool used by the mainstream at the moment. So we're using Bash script. This script will updated the image to the Manifests Repo. For the GitHub repo we don't need any installation either.

## ArgoCD and Kubernets Cluster Installation
We're installing Kubernetes on local machine (laptop) instead of EC2 instance. There are many resources on EC2 instance and to save on paying for a more robust EC2 instance local machine is being used.

Go to this website to install MiniKube: https://minikube.sigs.k8s.io/docs/start/

I had to start HyperV in my windows machine by going into settings and selecting a checkbox. 



### Kubernetes Operators and Contollers

Whenever installing any Kubernetes Controller (AgoCD, FluxCD) it's advisable to use Kubernetes Operators. Kubernets Operators make installation and Operator Lifecycle Managment (OLM) of Kubernets Controllers significantly easier. Operators allow easy updates, version control, telemetry. They also have some default configurations out of the box. We'll be using Argo CD here. 


- Go to Operator Hub (operatorhub.io) and follow the instructions to install ArgoCD. 
- To install ArgoCD which is a kubernetes controller first an operator (OLM) is installed to manage this or any other controller installations.
- Then ArgoCD installed. Could be FluxCD or any other control manager.

#### Install on Kubernetes

1. Install Operator Lifecycle Manager (OLM), a tool to help manage the Operators running on your cluster.

```
$ curl -sL https://github.com/operator-framework/operator-lifecycle-manager/releases/download/v0.28.0/install.sh | bash -s v0.28.0
```

2. Install the operator by running the following command:What happens when I execute this command?

```
$ kubectl create -f https://operatorhub.io/install/argocd-operator.yaml
```

This Operator will be installed in the "operators" namespace and will be usable from all namespaces in the cluster.


3. After install, watch your operator come up using next command.

```
$ kubectl get csv -n operators
```

To use it, checkout the custom resource definitions (CRDs) introduced by this operator to start using it.



#### Check for Operators Up and Running

```
kubectl get pods -n operators
```

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/e38fdbc4-b083-4d3c-b23b-ef4428940949)



### Run the Jenkins Pipeline

Go into the Jenkins pipeline and click on 'Build Now'.

Most pipelines have small errors that need fixing before they run. If it's the case fix those errors.

### Verify the image has been pushed to Docker Hub

Once the pipeline has run see if the image has been build and pushed to Docker Hub.
- Go to docker hub account and look for the image.
- It can also be checked on the EC2 instance by typing 'docker images'.


## Deploy Cluster on Kubernetes using ArgoCD

### Minikube Status

Check status of minikube on personal machine (that's where we installed it for this project).
Otherwise check into whatever location the Kubernets is running.

```
minikube status
```

Go to the ArgoCD documentation on argo-cd-operator.readthedocs.io
Usage -> Basics

Copy that example code at the top.

We're trying to create the ArgoCD controller here.

```
apiVersion: argoproj.io/v1alpha1
kind: ArgoCD
metadata:
  name: example-argocd
  labels:
    example: basic
spec: {}
```

Create a file with this code.

```
vim argocd-basic.yml
```

Then apply this to kubernetes
```
kubectl apply -f argocd-basic.yml
```

Note: we can also install using Helm Charts but it's much better to learn how to do it.

```
kubectl get pods
```

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/c0b83e7d-f74c-45c6-ae41-53254de4c1f4)

ArgoCD workloads are getting created.

#### Run the Cluster in Browser

```
kubectl get svc
```

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/4e3c843f-313b-4223-9f8f-19d1f6fdc2e9)

example-argocd-server service needs to change from ClusterIP to NodePort.

```
kubectl edi svc example-argocd-server
```

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/ca989fa0-aef1-4982-9382-0b1abc95a901)


![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/f1ac9fac-b895-44d3-8573-67fd73d9b02f)


Check if the change took place

```
kubectl get svc
```

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/4d8edd74-9904-4edd-9906-173fb4776032)

To execute it on browser minikube offers and automatic service. 

```
minikube service argocd-server
```

Minikube will generate a url using which we can access using browser. It's done by doing some port forwarding.

```
minikube service list
```

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/d9cbe5c0-d937-42cf-846f-bdcc869cc7a4)


Before accessing via browser ensure the pods are up and running

```
kubectl get pods
```

Notice the pods are now running.

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/fcc53200-84da-484d-929d-32f2a7ccdd2a)


#### Access the ArgoCD via URL

Use the url to access AcgoCD via browser. 

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/11c7ee85-adac-484b-8ab0-d90fd13644bc)


Username and Password are needed.

Username: admin

For password use the command

```
kubectl get secret
```

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/cee29984-2235-49ca-9881-caad09b8509e)


ArgoCD stores secret in example-argocd-cluster. To get it.

```
kubectl edit secret example-argocd-cluster
```

Copy the password.

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/6cdc8667-5503-4823-9aba-83bdc244c758)


Kubernetes secrets are not in plain text format but base64 ecrypted. To get the password they need to be decrypted first.

```
echo copied_password_goes_here | base64 -d
```

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/53d49959-98f2-4893-b86f-4661741b70eb)

Copy the password and paste it into the password field on ArgoCD login.


![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/e8e28c09-b75b-4509-b4e5-d32c733723ec)

Logged into ArgoCD successfully.

![image](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/8eb254cb-0c3e-4116-b563-1cd9a69af42d)


#### Configure ArgoCD

Fill the details

Application Name: test
Project Name: default
Sync Policy: Automatic
Repository URL: https://github.com/rgitrepo/Jenkins-Zero-To-Hero
Path: java-maven-sonar-argocd-helm-k8s/spring-boot-app-manifests
DESTINATION
Cluster URL: https://kubernetes.deault.svc
Namespace: default


![5 Pods visible in ArgoCD](https://github.com/rgitrepo/Jenkins-Zero-To-Hero/assets/77811423/9b8d1369-06de-4569-b363-346cab767062)




