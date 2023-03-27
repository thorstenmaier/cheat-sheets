# Exercises

- https://github.com/dgkanatsios/CKAD-exercises
- https://github.com/lucassha/CKAD-resources

# Journey

- https://www.linkedin.com/pulse/my-ckad-exam-experience-atharva-chauthaiwale/ (/)
- https://medium.com/@harioverhere/ckad-certified-kubernetes-application-developer-my-journey-3afb0901014 (/)

# Save time

## Generators

- https://medium.com/@atharvac.cloud/kubernetes-deep-dive-part-3-generators-for-quick-poc-6cac698f08eb

## Alias

```sh
export ns=default
alias k='kubectl -n $ns' # This helps when namespace in question doesn't have a friendly name 
alias kdr= 'kubectl -n $ns -o yaml --dry-run'.  # run commands in dry run mode and generate yaml.
```

## VIM Settings

```sh
vim ~/.vimrc
set nu
set expandtab
set shiftwidth=2
set tabstop=2
```

## Things to remember during the exam

- Proctors are very strict about exam code of conduct. I was warned couple of times just for covering my mouth and reading out questions aloud.
- Before you attempt a new question, be sure to execute command to switch contexts. It is given at the start of the question
- Sometimes you need to ssh to another node or change to root user. Beware of where you are all the time on bash terminal.
- Note down questions and its percentage ( only in the note pad provided by exam environment ) if you want to skip the question for later. This strategy really helped me when there was a time crunch and I had to cover as much ground as possible 
- I would highly recommend that questions be answered based on their weight-age. All the questions have their weight-age displayed. There are some questions with lower weight-age that will consume more time. So its better to come back to these questions once you are done with questions of higher weight-age.
Time and speed are critical. 2 hrs yes, but since the format of the exam is hands on its quite important to keep a check on the time. Get as much as practice as you can.
- Resist the urge to answer the questions sequentially.
- The notepad is your friend. For questions that you want to come back later and answer, make a note of it in the notepad provided in the exam to note the question number and its weightage. Doing this will help you to prioritize which questions you want to take a look at.
- If you are from windows background like me, then get some understanding on volume mounts, ssh, linux file systems
- Read the instructions given before the start of the exam on how to copy and paste from kubernetes.io documentation into the shell.

## Helpers

### Set namespace

`k config set-context --namespace=... --current`

### YAML syntax documentation
* `k explain pod --recursive | less`
* `/searchTerm`

## Fastest way to create resources YAMLs

### Pod
`k run --image=nginx --dry-run=client -o yaml my-nginx`

### Deployment
`k create deployment --image=nginx --dry-run=client -o yaml my-nginx`

### Service
`k create service nodeport --dry-run=client -o yaml --tcp 80:80 my-service`

### PV, PVC, Pod using Volume

https://kubernetes.io/docs/tasks/configure-pod-container/configure-persistent-volume-storage/

