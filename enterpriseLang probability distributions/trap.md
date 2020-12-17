# Trap https://attack.mitre.org/techniques/T1154/

## Context 
The trap command allows programs and shells to specify commands that will be executed upon receiving interrupt signals. A common situation is a script allowing for graceful termination and handling of common keyboard interrupts like ctrl+c and ctrl+d. Adversaries can use this to register code to be executed when the shell encounters specific interrupts either to gain execution or as a persistence mechanism. Trap commands are of the following format trap 'command list' signals where "command list" will be executed when "signals" are received.

## Result
There are no mitigations for this attack steps as it relies directly on the abuse of system features so this probability will be considered as binary. 
However, this attack step relies on user execution. It requires the user to execute the keyboard interrupt command. I couldn't find any relevant data on how often people use keyboard interrupts. This attack step is very rare and is probably mostly used when the adversary knows that the target is a developper who often uses the CLI and runs tasks in a Terminal. We can assume that, in this context, the targetted user will use the keyboard interrupts at least once a day, but in others this might take more time. 
We assume the probability distribution for this attack step is [Exponential(0.1)], based on the supported ordinal distribution HardAndCertain (https://github.com/mal-lang/malcompiler/wiki/Supported-distribution-functions)

## Discussion

I couldn't find relevant data on how often people use keyboard interrupts. This might also depend on the type of companies that are being attacked. The time distribution is thus arbitrary and might need some improvement.