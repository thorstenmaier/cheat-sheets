# Docker in Apline Linux unter Oracle Virtual Box installieren

* Folgender Anleitung folgen bis Punkt 17
  * [https://www.c-sharpcorner.com/article/docker-installation-in-windows-system-through-oracle-virtual-box/]

* Vernüftigen Editor und curl installieren
  * `apk add nano`
  * `apk add curl`

* Punkt 18 wie folgt anpassen
  * SSH Zugang per root ohne Passwort erlauben
  * `nano /etc/ssh/sshd_config`
    * `PermitRootLogin yes`
    * `PermitEmptyPasswords yes`
  * `service sshd restart`

* Punkte 19-21 der Anleitung oben folgen

* Docker als Autostart-Dienst einrichten
  * `rc-update add docker`

* Docker per TCP von außen erreichbar machen (https://fredyyudiawan.medium.com/exposing-docker-api-in-alpine-9cec04b12958)
  * `nano /etc/conf.d/docker`
  * `DOCKER_OPTS="-H tcp://0.0.0.0:9999 -H unix:///var/run/docker.sock"`
  * `/etc/init.d/docker restart`
  * Smoke-Test: `curl http://localhost:9999/images/json`

* Umgebungsvariable DOCKER_HOST in Windows setzen auf `tcp://192.168.2.55:9999`
