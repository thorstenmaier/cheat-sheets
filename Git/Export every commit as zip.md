# Export every git commit as zip archive

```sh
mkdir zip && git log --format="%h %s" --reverse |
    while read hash;
    do git archive --format zip --output "zip/$((i=i+1))-$(cut -c 9- <<< $hash).zip" $(cut -c 1-8 <<< $hash);
done
```
