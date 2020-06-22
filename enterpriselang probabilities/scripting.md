# [Scripting](https://attack.mitre.org/techniques/T1064/)
"Adversaries may use scripts to aid in operations and perform multiple actions that would otherwise be manual. Scripting is useful for speeding up operational tasks and reducing the time required to gain access to critical resources. Some scripting languages may be used to bypass process monitoring mechanisms by directly interacting with the operating system at an API level instead of calling other programs. Common scripting languages for Windows include VBScript and PowerShell but could also be in the form of command-line batch scripts."

## Prevalence
According to [Red Canary's Threat Detection Report 2020](https://redcanary.com/threat-detection-report/techniques/scripting/), 38% of organizations are affected by this attack step. -> ```Bernoulli(0.38)```. 

## Time to compromise
This is a very broad area and depends on the script being used. To get a rough estimate on when a script should be done running, I will look at the maximum execution time limit for some common scripting techniques. Google Scripts has a [maximum execution time limit of 4-5 minutes](https://www.labnol.org/code/20016-maximum-execution-time-limit), [PHP scripts are by default limited to 30 seconds](https://www.php.net/manual/en/function.set-time-limit.php), Javascript scripts maximum execution times vary from which browser its running on. [Firefox has a timed limit of 10 seconds, and safari 5 seconds](https://www.sitepoint.com/javascript-execution-browser-limits/). Using the average of these limits we get (270 + 30 + 10 + 5) / 4 = 78.75 seconds. This is ~1097 times per day, which comes out to a probability distribution of ```Exponential(1097)```. In other words, a very low Time to Compromise (TTC), almost negligible compared to one day.

## Result 
This comes out to ```Bernoulli(0.38)*Exponential(1097)```. 

## Discussion
The TTC here uses the maximum time limit for a script to get a rough estimate on time - however the true time to execute a script is most likely much lower. That means it might be appropriate to leave out the Exponential part of the probability distribution. 