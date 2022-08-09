# Accessing a pod running in Minikube from your Windows host

## Start Minikube

```sh
minikube delete
minikube start --driver virtualbox --no-vtx-check --memory 8192 --cpus 4
```

## Use Deployment YAML

Store the following content as `deployment.yml`.

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: nginx-deployment
  labels:
    app: nginx
spec:
  replicas: 3
  selector:
    matchLabels:
      app: nginx
  template:
    metadata:
      labels:
        app: nginx
    spec:
      containers:
      - name: nginx
        image: nginx:alpine
        ports:
        - containerPort: 80
```

Apply the yml file:

```sh
minikube kubectl -- apply -f deployment.yml
```

Check the cluster:

```sh
minikube kubectl -- get all
```

## Create NodePort Service

```yaml
apiVersion: v1
kind: Service
metadata:
  name: nginx-service
spec:
  type: NodePort
  ports:
    - targetPort: 80
      port: 80
      nodePort: 32055
  selector:
    app: nginx
```

## Access nginx

Call `minikube docker-env` to get the ip address.

Open browser and navigate to `http://[ip]:32055/`
