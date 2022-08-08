# Basic K8s commands

## Creating Pods

### Run container in a Pod

```sh
kubectl run [podname] --image=[image-name]
kubectl run nginx --image=nginx:alpine
```

### List only Pods

```sh
kubectl get pods
```

### List all resources

```sh
kubectl get all
```

### Enable Pod container to be called externally

Running pods get a cluster-ip address. Such a cluster-ip address is only exposed to other pods in the same cluster. If you want to get external access to the pod for testing, you can do this with the following command:

```sh
kubectl port-forward [name-of-pod] [external-port]:[internal-port]
kubectl port-forward nginx 8080:80
```

### Delete a Pod

```sh
kubectl delete pod [name-of-pod]
kubectl delete pod nginx
```

## Defining a Pod with YAML

### Simple YAML file

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: my-nginx
spec:
  containers:
  - name: my-nginx
    image: nginx:alpine
```
