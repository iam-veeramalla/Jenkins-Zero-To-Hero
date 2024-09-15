Real Time Used Case Detailed Steps Explained:

**Web Tier (Java)**

Build:
mvn clean compile: Cleans and compiles the Java project.
mvn package: Packages the compiled code into a .jar or .war file.
Test:
mvn test: Runs unit tests.
mvn verify: Runs integration tests and verifies the results.


**Application Tier (Node.js)**

Build:
npm install: Installs dependencies defined in package.json.
npm run build: Builds the application if a build step is defined (e.g., for a React app).
Test:
npm test: Runs the tests defined in package.json.

**Database Tier (SQL)**

Build:
mysql -u root -p"$MYSQL_ROOT_PASSWORD" < init-database.sql: Initializes the database with schema and seed data.
Test:
mysql -u root -p"$MYSQL_ROOT_PASSWORD" < test-database.sql: Runs tests or validations on the database.
Deploy Stages

Web Tier:
Uses scp to copy the JAR file to the deployment server and ssh to restart the application service.

Application Tier:
Uses scp to copy built files to the deployment server and ssh to restart the Node.js application using pm2.

Database Tier:
Uses mysql to apply any database changes or schema updates.

Customization:

Scripts and Commands: Ensure the scripts (e.g., build-web.sh, test-web.sh) and deployment commands are adapted to fit your actual build and deployment processes.

Credentials: Securely manage credentials (e.g., database passwords) using Jenkins credentials management rather than hard-coding them in scripts.

This pipeline setup should give you a comprehensive framework to manage builds, tests, and deployments across different tiers of your application using Docker containers for isolated and consistent environments.
