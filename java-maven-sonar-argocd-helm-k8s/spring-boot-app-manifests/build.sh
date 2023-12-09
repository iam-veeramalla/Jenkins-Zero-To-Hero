#!/bin/bash
BUILD_NUMBER=${BUILD_NUMBER}
sed -i "s/mydevopsacr1.azurecr.io\/ultimate-cicd:.*/mydevopsacr1.azurecr.io\/ultimate-cicd:${BUILD_NUMBER}/g" java-maven-sonar-argocd-helm-k8s/spring-boot-app-manifests/deployment.yml
