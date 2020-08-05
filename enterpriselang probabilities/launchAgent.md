# Launch Agent 

## Context https://attack.mitre.org/techniques/T1543/001/

Adversaries may create or modify launch agents to repeatedly execute malicious payloads as part of persistence. Per Apple’s developer documentation, when a user logs in, a per-user launchd process is started which loads the parameters for each launch-on-demand user agent from the property list (plist) files found in /System/Library/LaunchAgents, /Library/LaunchAgents, and $HOME/Library/LaunchAgents. These launch agents have property list files which point to the executables that will be launched.

Adversaries may install a new launch agent that can be configured to execute at login by using launchd or launchctl to load a plist into the appropriate directories. The agent name may be disguised by using a name from a related operating system or benign software. Launch Agents are created with user level privileges and are executed with the privileges of the user when they log in. They can be set up to execute when a specific user logs in (in the specific user’s directory structure) or when any user logs in (which requires administrator privileges).

## Relevant findings

According to this source (https://eclecticlight.co/2017/06/24/launchagents-and-launchdaemons-closing-the-vulnerability/), the Launch Agent attack can be performed if the advesary can perform plist Modification. We assume that the probability distribution will be carried by the plist Modification step.

## Result

We assessed the probability distribution for this technique as binary.