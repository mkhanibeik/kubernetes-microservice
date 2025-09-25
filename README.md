# kubernetes-microservice

A demo project with some microservices deployed on Kubernetes that communicate with each other.

## How to run and deploy

### Build microservices

Build each spring boot microservice.

```bash
mvn package
```

### Use Docker env of minikube

```bash
eval $(minikube docker-env)
```

### Create docker images

Create and tag docker images.

```bash
docker build --platform linux/amd64 --tag=reservation-service:0.0.1-SNAPSHOT . --build-arg="JAR_FILE=./target/reservation-0.0.1-SNAPSHOT.jar"
```

### Create helm instance from the helm charts

To generate the templates use the following command:

```bash
helm template reservation-service ./helm
```

and to deploy the template:

```bash
helm install reservation-service ./helm
```

To check the pod status, you can check the pod with kubectl

```bash
kubectl describe pod --namespace kube-ms
```

To enable port forwarding and access the service running in kubernetes, use the following command:

```bash
kubectl port-forward reservation-service-547498d664-bw92z 3000:8080 --namespace kube-ms
```

### Deploy using helmfile

To deploy all microservices together, helmfile can be used

```bash
helmfile apply
```

and to un-deploy:

```bash
helmfile destroy
```
