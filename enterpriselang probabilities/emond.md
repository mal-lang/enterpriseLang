# Emond

## Context (https://attack.mitre.org/techniques/T1519/)

Adversaries may use Event Monitor Daemon (emond) to establish persistence by scheduling malicious commands to run on predictable event triggers. Emond is a Launch Daemon that accepts events from various services, runs them through a simple rules engine, and takes action. The emond binary at /sbin/emond will load any rules from the /etc/emond.d/rules/ directory and take action once an explicitly defined event takes place. The rule files are in the plist format and define the name, event type, and action to take. Some examples of event types include system startup and user authentication. Examples of actions are to run a system command or send an email. The emond service will not launch if there is no file present in the QueueDirectories path /private/var/db/emondClients, specified in the Launch Daemon configuration file at/System/Library/LaunchDaemons/com.apple.emond.plist.

Adversaries may abuse this service by writing a rule to execute commands when a defined event occurs, such as system start up or user authentication. Adversaries may also be able to escalate privileges from administrator to root as the emond service is executed with root privileges by the Launch Daemon service.

This technique can be blocked by disabling the Emond plist file.

## Relevant findings 

https://www.xorrior.com/emond-persistence/
The following event triggers can be leveraged : startup, periodic, auth.success, auth.failure. These respectively trigger at system startup, when a given time has elapsed, and on successful or unsuccessful authentication.
Most adversaries using this technique are looking for persistence. We can thus assume that the adversary will prioritize leveraging startup and auth.success triggers.
Assuming users on average start their system once a day and authenticate once or twice a day, we'll assume the TTC to be described by [Exponential(2)]

## Result

We assess the probability distribution for the Emond technique to be [Exponential(2)]
## Discussion

The TTC was arbitrarily assumed and isn't based on any scientific paper. It is therefore up to discussion.
Here we assume that the probability of the feature being disabled is carried by the mitigation, however, Disable or Remove Feature Or Program mitigates plenty of techniques and we don't know whether companies disable or remove some, many or all of the techniques mitigated. We might want to have this probability carried by each technique instead. I couldn't find relevant data on how many companies actually disable the emond.plist file.

