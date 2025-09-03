#!/bin/bash

# Exit immediately if a command exits with a non-zero status.
set -e

# 1. Get the current branch name and store it in a variable
branch_name=$(git rev-parse --abbrev-ref HEAD)

# 2. Sanitize the branch name by replacing '/' with '-' for a safe filename
safe_file_name=$(echo "$branch_name" | tr '/' '-').txt

echo "Creating commits on branch '$branch_name' in file '$safe_file_name'..."

# 3. Loop three times to create files and commits
for i in $(seq 1 3); do
  echo "Test line ${i}" >> "$safe_file_name"
  git add "$safe_file_name"
  git commit -m "chore: test commit ${i} on ${branch_name}"
done

# 4. Push the new commits to the remote's current branch
# The -u flag sets the upstream branch on the first push
git push -u origin "$branch_name"

clear

echo "Done!"
