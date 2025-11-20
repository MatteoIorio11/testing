#!/bin/bash

# Exit immediately if a command exits with a non-zero status.
set -e

# 1. Get the current branch name and store it in a variable
branch_name=$(git rev-parse --abbrev-ref HEAD)

# 2. Sanitize the branch name by replacing '/' with '-' for a safe filename
safe_file_name=$(echo "$branch_name" | tr '/' '-').txt
user_names=("Alice Smith" "Bob Johnson" "Charlie Brown" "Diana Prince" "Ethan Hunt")
user_emails=("alice@example.com" "bob@example.com" "charlie@example.com" "diana@example.com" "ethan@example.com")

# Get the total number of users
num_users=${#user_names[@]}

echo "Creating commits on branch '$branch_name' in file '$safe_file_name'..."
echo "Test line ${i}" >> "$safe_file_name"
# Stage the file
git add "$safe_file_name"

# Commit with the randomly selected author
git -c user.name="matteo.iorio" -c user.email="matteo.iorio01@gmail.com" commit -m "chore: test commit 0 on ${branch_name}"

# 3. Loop three times to create files and commits
for i in $(seq 1 20); do
  
  random_index=$((RANDOM % num_users))
  commit_author_name="${user_names[$random_index]}"
  commit_author_email="${user_emails[$random_index]}"
  echo "Test line ${i}" >> "$safe_file_name"
  # Stage the file
  git add "$safe_file_name"
  
  # Commit with the randomly selected author
  git -c user.name="$commit_author_name" -c user.email="$commit_author_email" \
    commit -m "chore: test commit ${i} on ${branch_name}"
done

# 4. Push the new commits to the remote's current branch
# The -u flag sets the upstream branch on the first push
git push -u origin "$branch_name"

clear

echo "Done!"
