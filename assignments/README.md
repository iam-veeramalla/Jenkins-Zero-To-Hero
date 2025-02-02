Creating a folder dedicated to assignment so that the Repo is Clean
And hopefully PR can be accepted.

## Fork and Make changes push to your Forked repo, and then compare and create a pull request.

## or

## Use the Gitbash CLI command:

To create a pull request (PR) in Git using the command line, you would typically use the command "gh pr create" which is part of the GitHub CLI,  
specifying the base branch you want to merge into and the head branch containing your changes with flags like --base and --head respectively;  
you can also add a title and description using --title and --body options.

## Example:

```gh
gh pr create --base main --head feature-branch --title "Added new feature" --body "This pull request adds a new feature to the application."
```

```
Explanation:
gh pr create: Initiates the process of creating a pull request.
--base main: Specifies the "main" branch as the target branch where your changes will be merged.
--head feature-branch: Identifies the branch ("feature-branch") containing your changes that will be pulled into the main branch.
--title "Added new feature": Sets the title of your pull request.
--body "This pull request adds a new feature to the application.": Adds a descriptive body explaining your changes.
```
