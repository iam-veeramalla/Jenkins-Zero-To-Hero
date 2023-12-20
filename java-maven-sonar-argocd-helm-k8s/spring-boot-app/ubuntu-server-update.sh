#!/bin/bash

# Update and Upgrade Server on ubuntu 22 and latest version.

sudo DEBIAN_FRONTEND=noninteractive apt update -y;
sudo DEBIAN_FRONTEND=noninteractive apt upgrade -y ;

# Update and Upgrade of the server is done successful.
