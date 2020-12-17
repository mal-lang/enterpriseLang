# Clipboard Data

## Context https://attack.mitre.org/techniques/T1115/

Adversaries may collect data stored in the clipboard from users copying information within or between applications.

In Windows, Applications can access clipboard data by using the Windows API. OSX provides a native command, pbpaste, to grab clipboard contents.

## Assumptions and results

This type of attack technique cannot be easily mitigated with preventive controls since it is based on the abuse of system features (with proper rights).

However, it may take some time before an adversary is able to collect valuable data from clipboard (most likely credentials pasted). We'll assume that within a day, an adversary should be able to collect sensitive data from clipboard.

We'll use the [Exponential(1)] distribution from the Ordinal distributions listed in the wiki (Esay and Certain)