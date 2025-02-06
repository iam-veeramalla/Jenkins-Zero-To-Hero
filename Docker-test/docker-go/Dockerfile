# Use the official Golang image from the Docker Hub
FROM golang:1.16

# Set the working directory
WORKDIR /app

# Copy go.mod and go.sum
COPY go.mod go.sum ./

# Download the dependencies
RUN go mod download

# Copy the rest of the application code
COPY . .

# Build the application
RUN go build -o myapp .

# Expose the port the app runs on
EXPOSE 8081

# Command to run the application
CMD ["./myapp"]

