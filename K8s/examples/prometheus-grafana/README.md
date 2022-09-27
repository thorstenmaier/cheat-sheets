# Prometheus and Grafana with a Spring Boot App

## Steps to build and run the demo in a K8s cluster

- Deploy Prometheus and Grafana to cluster
  - `kubectl apply -f prometheus-grafana`
- Build Docker Container of Spring Boot App
  - `cd spring-service`
  - `mvnw spring-boot:build-image`
- Run Spring Boot App in cluster
  - `kubectl apply -f k8s`

## Browse the stack

- Spring Boot Prometheus Interface
  - <http://k8s-cluster-node-ip:31080/actuator/prometheus>
- Prometheus Interface
  - <http://k8s-cluster-node-ip:31002>
- Grafana Interface
  - <http://k8s-cluster-node-ip:31001>
  - Add Datasource Prometheus `http://prometheus-service:9090`
