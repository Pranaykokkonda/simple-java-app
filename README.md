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
- 🐋**Builds Docker image** and **Runs Docker Container**

`Select jenkins pipeline model`
              ⬇️

`Add jenkinsfile as jenkins declerative script`
              ⬇️

`Configure the environment variables`
              ⬇️

`Click on build`
              ⬇️

`Browse Application with ip address`

  ---
## 🔐Required Jenkins Credentials:
- SSH Key for REMOTE_USER on REMOTE_HOST
- Configurable environment Variables in Jenkinsfile

---
## 🔁CI/CD Automation with GitHub Webhook
This project uses a GitHub webhook to automate deployments via Jenkins.

✅ How it works:
- You push changes to your GitHub repo.
- GitHub sends a webhook POST request to your Jenkins server.
- Jenkins receives the webhook and automatically:
        Pulls the latest code.
        Builds the application.
        Builds the Docker image.
- Deploys it to your remote host/container.
