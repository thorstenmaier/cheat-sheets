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