# Private Keys

## Context https://attack.mitre.org/techniques/T1552/004/

Adversaries may search for private key certificate files on compromised systems for insecurely stored credentials. Private cryptographic keys and certificates are used for authentication, encryption/decryption, and digital signatures. Common key and certificate file extensions include: .key, .pgp, .gpg, .ppk., .p12, .pem, .pfx, .cer, .p7b, .asc.

Adversaries may also look in common key directories, such as ~/.ssh for SSH keys on * nix-based systems or C:\Users\(username)\.ssh\ on Windows. These private keys can be used to authenticate to Remote Services like SSH or for use in decrypting other collected files such as email.

Adversary tools have been discovered that search compromised systems for file extensions relating to cryptographic keys and certificates.

Some private keys require a password or passphrase for operation, so an adversary may also use Input Capture for keylogging or attempt to Brute Force the passphrase off-line.

## Relevant findings 

http://book.itep.ru/depository/security/vulnerability/AST-0125626_Ponemon_2014_SSH_Security_Vulnerability_Report.pdf
The Phonemon SSH Security report from 2014 states that 51 percent of companies have been impacted by SSH-key related compromise.
Lacking relevant papers, we can assume that this value can be used for other types of private keys and certificates.

## Results 

[Bernoulli(0.51)]
We separated the 2 cases (passphrase or not) in the code

## Discussion

This prevalence could be improved with further investigation on other key types exposure and certficates exposure.