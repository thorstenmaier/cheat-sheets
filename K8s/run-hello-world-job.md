# Run a hello world job in Kubernetes

## Run the job as one-shot-job

Create and run the job

```shell
kubectl create job --image=hello-world hello
```

Check if job was created successfully:

```shell
kubectl get job
```

```shell
$ kubectl get pod
NAME          READY   STATUS      RESTARTS   AGE
hello-tg9pc   0/1     Completed   0          48s
```

Show output of job. The job itself has no output but the pod that was executed by the job. Therefore we must determine the name of the pod as first step

```shell
kubectl describe job hello
```

Show log of completed pod:

```shell
kubectl logs hello-tg9pc
```

Delete job as last step:

```shell
kubectl delete job hello
```

## Run the job every minute as cron job

```shell
kubectl create cronjob --image=hello-world --schedule="* * * * *" hello-cronjob
```

```shell
kubectl describe cronjob hello-cronjob
```

Resulting cronjob:

```shell
kubectl edit cronjob hello-cronjob
```

```yaml
apiVersion: batch/v1
kind: CronJob
metadata:
  creationTimestamp: "2022-08-09T08:06:09Z"
  generation: 3
  name: hello-cronjob
  namespace: default
  resourceVersion: "22936"
  uid: 44d9b5c9-6728-4590-85a6-aa374d5d8a97
spec:
  concurrencyPolicy: Allow
  failedJobsHistoryLimit: 1
  jobTemplate:
    metadata:
      creationTimestamp: null
      name: hello-cronjob
    spec:
      template:
        metadata:
          creationTimestamp: null
        spec:
          containers:
          - image: hello-world
            imagePullPolicy: Always
            name: hello-cronjob
            resources: {}
            terminationMessagePath: /dev/termination-log
            terminationMessagePolicy: File
          dnsPolicy: ClusterFirst
          restartPolicy: OnFailure
          schedulerName: default-scheduler
          securityContext: {}
          terminationGracePeriodSeconds: 30
  schedule: '* * * * *'
  successfulJobsHistoryLimit: 3
  suspend: false
status:
  lastScheduleTime: "2022-08-09T08:17:00Z"
  lastSuccessfulTime: "2022-08-09T08:17:07Z"

```