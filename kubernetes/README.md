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

## Demo ##

- Build the project and create a fat jar: `./mvnw clean package`
- Build and push the docker image (see the parent README)
- Delete minikube to purge any existing cluster state: `minikube delete`
- Start minikube: `minikube start`
- Start the minikube dashboard to visualize the cluster state: `minikube dashboard`
- Create the Kubernetes objects: `kubectl apply -f ./hello-world-config.yml` and `kubectl apply -f ./hello-world-db.yml` and `kubectl apply -f ./hello-world-app.yml`
- Get the minikube IP: `minikube ip`
- Get the ports on which services are exposed: `kubectl get services`
- Optional: Connect to the DB 
- Invoke the deployed service: `curl --location --request GET 'http://172.17.0.3:31296/hello'`
