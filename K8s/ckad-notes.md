# Exercises

- https://github.com/dgkanatsios/CKAD-exercises
- https://github.com/lucassha/CKAD-resources

# Journey

- https://www.linkedin.com/pulse/my-ckad-exam-experience-atharva-chauthaiwale/ (/)
- https://medium.com/@harioverhere/ckad-certified-kubernetes-application-developer-my-journey-3afb0901014

# Save time

## Generators

- https://medium.com/@atharvac.cloud/kubernetes-deep-dive-part-3-generators-for-quick-poc-6cac698f08eb

## Alias

```sh
export ns=default
alias k='kubectl -n $ns' # This helps when namespace in question doesn't have a friendly name 
alias kdr= 'kubectl -n $ns -o yaml --dry-run'.  # run commands in dry run mode and generate yaml.
```
