#

## Install Postgres in Kubernetes

Follow chapter 1 of this [manual](https://phoenixnap.com/kb/postgresql-kubernetes)

```shell
helm install psql-test bitnami/postgresql --set persistence.existingClaim=postgresql-pv-claim --set volumePermissions.enabled=true
```

Default settings:
- Database name: postgres
- Username: postgres
- Password: auto generated and written into a K8s secret

```shell
kubectl get secret psql-test-postgresql -o jsonpath="{.data.postgres-password}" | base64 --decode
```

## Activate direct accessing to the Postgres Pod

This is useful for accessing the db with a database management tool

```shell
kubectl port-forward pods/psql-test-postgresql-0 5432:5432
```

## Build and deploy Spring service with DB access

### Add Postgres driver to pom.xml

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

### Build docker image

```shell
./mvnw spring-boot:build-image
```

### Create and apply deployment yaml

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: usermanagement-deployment
  labels:
    app: usermanagement
spec:
  replicas: 1
  selector:
    matchLabels:
      app: usermanagement
  template:
    metadata:
      labels:
        app: usermanagement
    spec:
      containers:
      - name: usermanagement
        image: usermanagement:0.0.1-SNAPSHOT
        ports:
        - containerPort: 8080
        env:
          - name: SPRING_PROFILES_ACTIVE
            value: prod
          - name: SPRING_DATASOURCE_URL
            value: jdbc:postgresql://psql-test-postgresql/postgres
          - name: SPRING_DATASOURCE_USERNAME
            value: postgres
          - name: SPRING_DATASOURCE_PASSWORD
            valueFrom:
              secretKeyRef:
                key: postgres-password
                name: psql-test-postgresql
          - name: SPRING_JPA_HIBERNATE_DDL-AUTO
            value: create
```

```shell
kubectl apply -f deployment.yaml
```

### Optional: create service to access Spring service form outside

```yaml
apiVersion: v1
kind: Service
metadata:
  name: usermanagement-service
spec:
  selector:
    app:  usermanagement
  type:  NodePort
  ports:
  - port:  8080
    targetPort:  8080
    nodePort: 32055
```

```shell
kubectl apply -f service.yaml
```
