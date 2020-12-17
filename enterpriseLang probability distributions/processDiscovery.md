# [Process Discovery](https://attack.mitre.org/techniques/T1057/)

## Context
>Adversaries may attempt to get information about running processes on a system. Information obtained could be used to gain an understanding of common software running on systems within the network. Adversaries may use the information from Process Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.
### Windows
>An example command that would obtain details on processes is ```"tasklist"``` using the Tasklist utility.
### Mac and Linux
>In Mac and Linux, this is accomplished with the ```ps``` command.

## Findings
According to vmware's Carbon Black [2020 Cyber Security Outlook Report](https://content.carbonblack.com/c/vmwcb-threat-report-?x=f_lWMB), 17% of malware uses Process Discovery. This corresponds to ```Bernoulli(0.17)```.

## Time to compromise
I attempted running the ```tasklist /v /fi "STATUS eq running"``` command on my own PC in the cmd.exe command prompt to get an estimate on the expected runtime. What the prompt does is use tasklist with some parameters to return more detailed information than usual (Which I am assuming an adversary may be interested in). With a Intel i7-7500 2.7GHz CPU, and with 90 processes running, I timed the commands runtime with ```Measure-Command {tasklist /v /fi "STATUS eq running"}``` in powershell, and it returned a runtime of 0.3839811 seconds. I will assume this to be instant. 

Now, I think for this step we also have to account for the time needed to read and analyze the results, because the adversary has to also use the data presented to get information of the processes they are potentially interested in. 
With a total of 991 words returned by the original ```tasklist /v /fi "STATUS eq running"``` command, and with the average adult having an [average reading speed of 238 words per minute for non fiction](https://www.researchgate.net/publication/332380784_How_many_words_do_we_read_per_minute_A_review_and_meta-analysis_of_reading_rate), this comes out to taking 4.1638... minutes. This is roughly 346 times per day, as such, I am estimating the TTC to be ```Exponential(346)``` 

## Result
```Bernoulli(0.17) * Exponential(346)```. 