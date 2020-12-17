# Bash History

## Context https://attack.mitre.org/techniques/T1552/003/

Adversaries may search the bash command history on compromised systems for insecurely stored credentials. Bash keeps track of the commands users type on the command-line with the "history" utility. Once a user logs out, the history is flushed to the user’s .bash_history file. For each user, this file resides at the same location: ~/.bash_history. Typically, this file keeps track of the user’s last 500 commands. Users often type usernames and passwords on the command-line as parameters to programs, which then get saved to this file when they log out. Attackers can abuse this by looking through the file for potential credentials.

## Relevant findings

In order to assess prevalence, we need to find the percentage of companies that have a good bash_history policy, clearing the history on use. 

In order to assess the TTC for this technique we would need to find out how often (ideally how many times / number of lines) people write credentials in their bash. 

It is very hard to find exactly this data online.
We don't have any relevant source on the realted mitigation either.  

We'll use some other numbers to approximate the distribution for this teechnique.

https://www.darkreading.com/endpoint/average-employee-manages-nearly-200-passwords/d/d-id/1330304
http://blog.lastpass.com/2017/11/lastpass-reveals-8-truths-about-passwords-in-the-new-password-expose/
According to this report, employees use an average of 191 passwords to enter 154 times in a given month. That means they enter passwords ~5.1 times a day. However, they're not necessarily entering these passwords in bash. That being said, we can assume that the average employee would enter credentials in bash at least once a day.

For the prevalence, we couldn't find any relevant paper. We'll use the ordinal distribution for Easy and Uncertain. [Bernoulli(0.5)*Exponential(1)]

## Results

[Bernoulli(0.5)*Exponential(1)]

## Discussion

This probability distribution can be significantly improved wwith better raw data.