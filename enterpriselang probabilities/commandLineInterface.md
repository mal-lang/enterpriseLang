# Command Line Interface https://attack.mitre.org/techniques/T1059/

## Context 
Command-line interfaces provide a way of interacting with computer systems and is a common feature across many types of operating system platforms. One example command-line interface on Windows systems is cmd, which can be used to perform a number of tasks including execution of other software. Command-line interfaces can be interacted with locally or remotely via a remote desktop application, reverse shell session, etc. Commands that are executed run with the current permission level of the command-line interface process unless the command includes process invocation that changes permissions context for that execution (e.g. Scheduled Task).

Adversaries may use command-line interfaces to interact with systems and execute other software during the course of an operation.

The command Line access might be restricted for simple users.

## Relevant findings
https://www.itjungle.com/2020/06/22/security-gaining-attention-on-ibm-i-but-more-progress-needed/
While this vestigial approach of imposing security by restricting access to the command line is still rampant (with 76 percent of users having their command line access restricted), there’s a subset of the whole IBM i population that not only still has command line access (24 percent), but also has a fully enabled user profile. According to HelpSystems, 17 percent of user profiles surveyed had both command line access and a fully enabled user profile, which presents “a very clear risk.”

According to this report, 24% of users have access to CLI at IBM. Without any further data, we assume that this probability can be used as an apporximation of the amount of users having access to CLI in any comapnies.

## Result

Exploiting the CLI takes no time. We assess the probability distribution for this attack step to be [Bernoulli(0.24)] for the userCommandLineInterface step.

As far as the adminCommandLineInterface is concerned, admins need CLI access to manage the network so the probability is assessed as binary.
## Discussion

IBM is a top technology company which is aware of cybersecurity risks. Some other companies might not have the same security process as IBM and thus the value found for IBM might not be 100% accurate.
The Execution Prevention mitigation is too wide to be given a probability distribution, which is why omitigation has directly been taken into account in the probability given to the attack step itself.