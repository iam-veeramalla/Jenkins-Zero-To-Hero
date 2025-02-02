# Jenkins Multi-Stage Pipeline

## Overview
This Jenkins pipeline demonstrates multi-stage builds using different programming languages inside Docker containers.

## Prerequisites
- Jenkins installed and configured
- Docker installed on the Jenkins agent

## Stages
1. **Python Stage**
   - Runs Python 3.10
   - Prints the Python version
   - Executes a simple "Hello, World" script

2. **Node.js Stage**
   - Runs Node.js 16
   - Prints the Node.js version
   - Runs a simple JavaScript script

3. **Go Stage**
   - Runs Golang latest
   - Prints the Go version
   - Runs a basic Go program

## How to Run
1. Add this `Jenkinsfile` in your repository.
2. Create a Jenkins job with "Pipeline from SCM".
3. Trigger the build and check the output.

## Expected Output
Each stage should display the language version and print "Hello, World!" in that language.

