# Launch Daemon 

## Context https://attack.mitre.org/techniques/T1543/001/

Adversaries may create or modify launch daemons to repeatedly execute malicious payloads as part of persistence. Per Apple’s developer documentation, when macOS and OS X boot up, launchd is run to finish system initialization. This process loads the parameters for each launch-on-demand system-level daemon from the property list (plist) files found in /System/Library/LaunchDaemons and /Library/LaunchDaemons. These LaunchDaemons have property list files which point to the executables that will be launched.

Adversaries may install a new launch daemon that can be configured to execute at startup by using launchd or launchctl to load a plist into the appropriate directories. The daemon name may be disguised by using a name from a related operating system or benign software. Launch Daemons may be created with administrator privileges, but are executed under root privileges, so an adversary may also use a service to escalate privileges from administrator to root.

The plist file permissions must be root:wheel, but the script or program that it points to has no such requirement. So, it is possible for poor configurations to allow an adversary to modify a current Launch Daemon’s executable and gain persistence or Privilege Escalation.

## Relevant findings

According to this source (https://eclecticlight.co/2017/06/24/launchagents-and-launchdaemons-closing-the-vulnerability/), the Launch Agent attack can be performed if the advesary can perform plist Modification. We assume that the probability distribution will be carried by the plist Modification step.

## Result

We assessed the probability distribution for this technique as binary.

## Discussion

The only difference between this technique and the launchAgent one is that launch Daemons are executed with root privilege and can thus be used for privilege escalation. This might suggest there should a probability distribution for the Launch Daemon technique, however, according to the source and the mitre description, only poor configurations can allow this to be exploited. Therefore, we assume that the probability will be carried by the User Account Management mitigation, as suggested by the MITRE framework.