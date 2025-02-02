# Assignment Workflow

**1. Clean Repository Setup:**

* Create a dedicated folder for this assignment to keep your local projects organized.

**2. Fork and Make Changes:**

* Fork the repository you're working on to your own GitHub account.
* Clone your forked repository to your local machine.
* Make the necessary changes to the code.
* Commit your changes with descriptive commit messages.
* Push your changes to your forked repository on GitHub.

**3. Create a Pull Request:**

* **Option 1: GitHub Web Interface**
    * Go to your forked repository on GitHub.
    * Click the "Compare & pull request" button.
    * Select the base branch (usually "main" or "develop") and your feature branch.
    * Provide a clear and concise title and description for your pull request.
    * Submit the pull request.

* **Option 2: GitHub CLI**

    Use the following command to create a pull request from the command line:

    ```bash
    gh pr create --base main --head feature-branch --title "Your Pull Request Title" --body "Your Pull Request Description"
    ```

    * Replace `main` with the actual base branch name.
    * Replace `feature-branch` with the name of your feature branch.
    * Provide a clear and concise title and description for your pull request.

**Example:**

```bash
gh pr create --base main --head feature-branch-new-feature --title "Added new feature - User authentication" --body "This pull request adds user authentication functionality to the application."
