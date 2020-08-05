# [Application Isolation and Sandboxing](https://attack.mitre.org/mitigations/M1048/) [Mitigation]

## Context
Restrict execution of code to a virtual environment on or in transit to an endpoint system.

## Findings 
A specific type of sandboxing is virtualization. According to a study done by [spiceworks on the 2020 state of virtualization technology](https://www.spiceworks.com/marketing/reports/state-of-virtualization/), 39% use application virtualization. This corresponds to ```Bernoulli(0.39)```. 

## Result
The prevalence of application virtualization was found to be ```Bernoulli(0.39)```. 

## Additional findings
According to one [paper, "Bypassing modern sandbox technologies"](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwig8JChvYvqAhXID5oKHRylBCYQFjAGegQIJhAB&url=https%3A%2F%2Fwww.eit.lth.se%2Fsprapport.php%3Fuid%3D966&usg=AOvVaw1F2TxzPdTzWTYvjPq7HA8Y), the rate of success for sandboxes to prevent malware was on average was 57%. 
