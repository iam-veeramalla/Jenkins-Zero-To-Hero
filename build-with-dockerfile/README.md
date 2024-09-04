# BUILD IMAGE FROM DOCKERFILE

For projects requiring a more customized execution environment, Pipeline also supports building and running a container from a Dockerfile in the source repository. In contrast to the previous approach of using an "off-the-shelf" container, using the agent { dockerfile true } syntax builds a new image from a Dockerfile, rather than pulling one from Docker Hub.