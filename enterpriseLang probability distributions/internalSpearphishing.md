# Internal Spearphishing

## Context https://attack.mitre.org/techniques/T1534/

Adversaries may use internal spearphishing to gain access to additional information or exploit other users within the same organization after they already have access to accounts or systems within the environment. Internal spearphishing is multi-staged attack where an email account is owned either by controlling the user's device with previously installed malware or by compromising the account credentials of the user. Adversaries attempt to take advantage of a trusted internal account to increase the likelihood of tricking the target into falling for the phish attempt.

Adversaries may leverage Spearphishing Attachment or Spearphishing Link as part of internal spearphishing to deliver a payload or redirect to an external site to capture credentials through Input Capture on sites that mimic email login interfaces.

There have been notable incidents where internal spearphishing has been used. The Eye Pyramid campaign used phishing emails with malicious attachments for lateral movement between victims, compromising nearly 18,000 email accounts in the process. The Syrian Electronic Army (SEA) compromised email accounts at the Financial Times (FT) to steal additional account credentials. Once FT learned of the attack and began warning employees of the threat, the SEA sent phishing emails mimicking the Financial Times IT department and were able to compromise even more users.

## Relevant findings

https://er.educause.edu/articles/2005/1/fostering-email-security-awareness-the-west-point-carronade
A study conducted on 512 cadets received a spear phishing e-mail urging them to click on an embedded link. 80% of the subjects pursued
to act upon the message. The message was addressed from a colonel and the culture at the institution state that whenever a message is signed by a colonel, you act upon instructions even if they seem irrational.
Because this exercise was a proof-of-concept with a small sample size, extrapolating the results to the general population is ambitious at best. Nonetheless, 80 percent (more than 400) of the cadets in the sample clicked on the embedded link. Even with four hours of computer security instruction, 90 percent of the freshmen clicked on the embedded link.
Considering this spearphishing campaign was designed as an internal spearphishing attack, we can assume that the results can be extrapolated in enterprise environment for the case of internal spearphishing.
We will thus use a probability in between 80%-90%.

The TTC used will be the same as for other spear phishing techniques.

## Results

We assess the probability distribution for this technique to be [Bernoulli(0.85)*Exponential(1)]

## Discussion

The prevalence of the Spearphishing Attachment technique is higher than internal Spearphishing. This might be discussed, one of the two might be wrong and these probabilities might be updated with further investigation.