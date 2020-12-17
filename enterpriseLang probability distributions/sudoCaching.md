# Sudo Caching

## Context (https://attack.mitre.org/techniques/T1206/)

The sudo command "allows a system administrator to delegate authority to give certain users (or groups of users) the ability to run some (or all) commands as root or another user while providing an audit trail of the commands and their arguments." Since sudo was made for the system administrator, it has some useful configuration features such as a timestamp_timeout that is the amount of time in minutes between instances of sudo before it will re-prompt for a password. This is because sudo has the ability to cache credentials for a period of time. Sudo creates (or touches) a file at /var/db/sudo with a timestamp of when sudo was last run to determine this timeout. Additionally, there is a tty_tickets variable that treats each new tty (terminal session) in isolation. This means that, for example, the sudo timeout of one tty will not affect another tty (you will have to type the password again).

Adversaries can abuse poor configurations of this to escalate privileges without needing the user's password. /var/db/sudo's timestamp can be monitored to see if it falls within the timestamp_timeout range. If it does, then malware can execute sudo commands without needing to supply the user's password. When tty_tickets is disabled, adversaries can do this from any tty for that user.

The OSX Proton Malware has disabled tty_tickets to potentially make scripting easier by issuing echo \'Defaults !tty_tickets\' >> /etc/sudoers . In order for this change to be reflected, the Proton malware also must issue killall Terminal. As of macOS Sierra, the sudoers file has tty_tickets enabled by default

## Relevant findings

### TTC 

Various sources give a different default timestamp_timeout value. However, based on the sudoers manual page (https://www.sudo.ws/man/1.8.15/sudoers.man.html), we'll assume that the default value is 5 minutes, which means that users are reprompted for password five minutes after entering the sudo password once. If the attacker runs command in the shell in the meantime, they can execute it with elevated rights without knowing the user's password.
We can thus assess the average time to compromise to be 5 minutes which can be represented by the [Exponential(288)] distribution ((24*60)/5=288).

### Prevalence

The sudo command is used by almost all linux users and thus, the only way to prevent sudo caching, according to the sudoers manual page and the mitre description is by setting the timestamp_timeout value to 0 (prompting the user for password everytime they use the sudo command). tty_tickets can prevent this leakage to go to other ttys, however this doesn't prevent this to be used on the current tty. 
We could assume the prevalence to be binary if the probability for the timestamp_timeout value to be 0 is carried by the Privilege Account Management mitigation (as suggested by MITRE). 

## Result 

We assess the probability distribution for this technique to be [Exponential(288)]

## Discussion

The Privilege Account Management defense covers many attack steps. It could either be split in different defenses for each specific step or the prevalence could be carried by the attack step itself. Anyway, lacking specific data on the amount of companies that have a good configuration and set this value to 0, we assumed this to be carried by the mitigation. Many users would actually dislike having to write their passwords every time they write a sudo cmd so the binary assumption doesn't seem too bad. However, raw data would of course be ideal there.