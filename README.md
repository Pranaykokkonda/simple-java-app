# ☕ Simple Java Application with CI/CD Pipeline

This project is a simple Java Spring Boot application packaged and deployed using **Docker** and a **Jenkins CI/CD pipeline**. It is designed to demonstrate modern DevOps practices including building, testing, and deploying Java applications with automated workflows.

Additionally, a **GitHub webhook** is integrated to automate the deployment process. When changes are pushed to the GitHub repository, Jenkins is automatically triggered to pull, build, and redeploy the updated application—fully automating the CI/CD process.

---
## 🧱 Features
- ☕Java 21 with Spring Boot
- 🛠️Maven wrapper support
- 🐳Multi-stage Docker build for optimized image
- 🔁Jenkins pipeline for CI/CD
- 🚀Docker image deployment to remote server (via SSH)

---
## 🚀Jenkins CI/CD Deployment – Step-by-Step
The following steps are executed in the Jenkins pipeline to automate deployment to a remote server using Docker:
- 🗂️**Checkout the source code** from the repository
- 📦**Compress the GitHub repository** into a ZIP file
- 🚀**Transfer the ZIP file** to the remote server using SCP
- 🔐**Establish an SSH connection** to the remote server
- 📂**Unzip the file** on the remote server
- 🐋**Execute Docker pull and Docker run** to retrieve the image and run the container

`Select jenkins pipeline model`
              ⬇️

`Add jenkinsfile as jenkins declerative script`
              ⬇️

`Configure the environment variables`
              ⬇️

`Click on build`

  ---
## 🔐Required Jenkins Credentials:
- SSH Key for REMOTE_USER on REMOTE_HOST
- Configurable environment Variables in Jenkinsfile

---



