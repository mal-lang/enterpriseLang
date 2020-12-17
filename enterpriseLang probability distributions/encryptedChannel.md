# Encrypted Channel / Multi Layer Encryption

## Context (https://attack.mitre.org/techniques/T1573/)

This technique used to be Multi Layer Encryption and is now Encrypted Channel (hence the diffferent names for the file and within the code)

Adversaries may employ a known encryption algorithm to conceal command and control traffic rather than relying on any inherent protections provided by a communication protocol. Despite the use of a secure algorithm, these implementations may be vulnerable to reverse engineering if secret keys are encoded and/or generated within malware samples/configuration files.

Adversaries may either employ symmetric or asymmetric encryption algorithms. The main difference between them is the time taken to encrypt the data. Symmetric is generally faster.

### Symmetric 

Adversaries may employ a known symmetric encryption algorithm to conceal command and control traffic rather than relying on any inherent protections provided by a communication protocol. Symmetric encryption algorithms use the same key for plaintext encryption and ciphertext decryption. Common symmetric encryption algorithms include AES, DES, 3DES, Blowfish, and RC4.

### Asymmetric 

Adversaries may employ a known asymmetric encryption algorithm to conceal command and control traffic rather than relying on any inherent protections provided by a communication protocol. Asymmetric cryptography, also known as public key cryptography, uses a keypair per party: one public that can be freely distributed, and one private. Due to how the keys are generated, the sender encrypts data with the receiver’s public key and the receiver decrypts the data with their private key. This ensures that only the intended recipient can read the encrypted data. Common public key encryption algorithms include RSA and ElGamal.

For efficiency, may protocols (including SSL/TLS) use symmetric cryptography once a connection is established, but use asymmetric cryptography to establish or transmit a key. As such, these protocols are classified as Asymmetric Cryptography.

## Relevant findings 

### TTC 
https://www.jscape.com/blog/bid/84422/symmetric-vs-asymmetric-encryption#:~:text=Symmetric%20key%20encryption%20doesn't,to%20speed%2C%20symmetric%20trumps%20asymmetric.&text=For%20as%20long%20as%20you,to%20decrypt%20your%20encrypted%20file.
This source explains how the symmetric encryption algorithms are faster than the asymmetric ones.

https://www.cse.wustl.edu/~jain/cse567-06/ftp/encryption_perf/
One average it would only take about 16 sec (~ 15.977) to encrypt 500Mb of data. Considering we are encrypting traffic, the speed might be more interesting but it's harder to use in the MAL. 

### Prevalence
https://arxiv.org/ftp/arxiv/papers/1312/1312.3183.pdf
In the abstract, it's suggested that in 60 percont of cases, encryption leads to no data can be used to work with.

https://www.cisco.com/c/dam/en/us/solutions/collateral/enterprise-networks/enterprise-network-security/nb-09-encrytd-traf-anlytcs-wp-cte-en.pdf
These 60% are supported by this CISCO report as well, which suggests that by 2020  60% of organizations will fail to decrypt HTTPS efficiently, missing critical encrypted threats. We can assume that decryption efficiency is the same for all protocols (not only HTTPS) and can be used to assess the prevalence of a successful traffic channel encryption.

## Results

We assess the probability distribution for this technique to be [Bernoulli(0.60)*Exponential(5400)]

## Discussion

On the TTC, we are trying to assess a time value for the encryption of traffic which is continuous. Therefore, the more relevant value is the speed of the encryption (in Mb/s) which can't be used in the MAL. 