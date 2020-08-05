# LSASS Driver 

## Context 

The Windows security subsystem is a set of components that manage and enforce the security policy for a computer or domain. The Local Security Authority (LSA) is the main component responsible for local security policy and user authentication. The LSA includes multiple dynamic link libraries (DLLs) associated with various other security functions, all of which run in the context of the LSA Subsystem Service (LSASS) lsass.exe process.

Adversaries may target lsass.exe drivers to obtain execution and/or persistence. By either replacing or adding illegitimate drivers (e.g., DLL Side-Loading or DLL Search Order Hijacking), an adversary can achieve arbitrary code execution triggered by continuous LSA operations.

## Relevant Findings 

Anthe, C. et al. (2016, December 14). Microsoft Security Intelligence Report Volume 21. Retrieved November 27, 2017.
According to this report and to the MITRE framework, this specific attack seems quite rare and a bit complicated as it needs to be performed in combination with other attacks to allow code injection. The adversary has to deliver a payload previously (probably via Spearphishing) and has to add/replace drivers to inject arbitrary code into the system.

## Results

Lacking relevant scientific papers and only based on the few data we have, we'll use the following ordinal supported distribution for this attack step : [Bernoulli(0.5)*Exponential(0.1)] (Hard and Not Certain)

## Discussion

I couldn't find relevant data/papers on that specific attack and thus the distribution I chose may be discussed.