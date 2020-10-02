# Kubernetes Deployment #

## Minikube Setup ##

- Start minikube: `minikube start`
- Stop minikube: `minikube stop`
- Start the minikube dashboard: `minikube dashboard`
- Destroy minikube (including any configurations): `minikube delete`
- Get exposed URL for service: `minikube service hello-world-service --url`
- Enable ingress (required by ingress controllers): `minikube addons enable ingress`
- Enable metrics server (required by autoscaler): `minikube addons enable metrics-server`

## Kubectl commands ##

- Apply a kubernetes configuration: `kubectl apply -f <path-to-file>`
- Get resources: `kubectl get pods/services/deployments/nodes`
- Describe a particular pod: `kubectl describe pod/<pod-name>` 
- Describe a particular service: `kubectl describe service/<service-name>`
- Describe a particular deployment: `kubectl describe deployment/<deployment-name>`
- Get logs for a pod: `kubectl logs <pod-name>`
- Delete a particular pod: `kubectl delete pod <pod-name>`
- Delete a particular service: `kubectl delete service <service-name>`
- Delete a particular deployment: `kubectl delete deployment <deployment-name>`
- Get the deployment revision history: `kubectl rollout history deployment/hello-world-deployment`
- Rollback to previous deployment: `kubectl rollout undo deployment/hello-world-deployment`
- Rollback to an older version: `kubectl rollout undo deployment/hello-world-deployment --to-revision=<revision-index>`
- Get the status of a rolling update: `kubectl rollout status -w deployment/hello-world-deployment`
- Restart a deployment (rolling update to same image): `kubectl rollout restart deployment/hello-world-deployment`

## Demo ##

- Delete minikube to purge any existing cluster state: `minikube delete`
- Start minikube: `minikube start`
- Start the minikube dashboard to visualize the cluster state: `minikube dashboard`
- Enable ingress: `minikube addons enable ingress`
- Enable metrics server: `minikube addons enable metrics-server`
- Create the Kubernetes objects: `kubectl apply -f ./hello-world-config.yml` and `kubectl apply -f ./hello-world-db.yml` and `kubectl apply -f ./hello-world-app.yml`
- Get the minikube IP: `minikube ip`
- Get the ports on which services are exposed: `kubectl get services`
- Invoke the deployed service: `curl --location --request GET 'http://172.17.0.3:31296/hello'`
- Test ingress: `curl 172.17.0.3/hello -H 'Host: helloworld.example.com'`
- Do a rolling upgrade to V2 (modify the deployment file): `kubectl apply -f <path-to-file>`
- Get the deployment revision history: `kubectl rollout history deployment/hello-world-deployment`
- Invoke the deployed service: `curl --location --request GET 'http://172.17.0.3:31296/hello'`
- Do a rollback to V1: `kubectl rollout undo deployment/hello-world-deployment`
- Get the status of a rolling update: `kubectl rollout status -w deployment/hello-world-deployment`
- Invoke the deployed service: `curl --location --request GET 'http://172.17.0.3:31296/hello'`
