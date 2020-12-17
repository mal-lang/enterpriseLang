# Exfiltration Over Other Network Medium

## Context (https://attack.mitre.org/techniques/T1011/)

Adversaries may attempt to exfiltrate data over a different network medium than the command and control channel. If the command and control network is a wired Internet connection, the exfiltration may occur, for example, over a WiFi connection, modem, cellular data connection, Bluetooth, or another radio frequency (RF) channel.

Adversaries may choose to do this if they have sufficient access or proximity, and the connection might not be secured or defended as well as the primary Internet-connected channel because it is not routed through the same enterprise network

### Sub Technique : Exfiltration Over Bluetooth

Adversaries may attempt to exfiltrate data over Bluetooth rather than the command and control channel. If the command and control network is a wired Internet connection, an attacker may opt to exfiltrate data using a Bluetooth communication channel.

Adversaries may choose to do this if they have sufficient access and proximity. Bluetooth connections might not be secured or defended as well as the primary Internet-connected channel because it is not routed through the same enterprise network.

## Relevant findings

https://fr.wikipedia.org/wiki/D%C3%A9bits_et_port%C3%A9es
(This web page is in franch but I couldn't find the equivalent in english, it's easy to understand though) 
This page lists most Network Medium used and gives their speed, which we used to determine the TTC.

### Bluetooth

The source says that it would take 10s on average to transfer a 3Mo file via Bluetooth. In order to transfer a 500Mo file (which we take as a reference because that is the size we used in the Exfiltration Over Alternative Protocol technique), it would then take ~1666s (~28 min). We can thus represent the TTC for the Exfiltration Over Bluetooth with the [Exponential(51.86)] distribution.

### Other other network medium (Wifi, NFC, Radio, modem, cellular data connexion)

Assuming Wifi is widely perferred over other listed medium, we'll only look for the average TTC for Wifi connexion.
https://www.atlasandboots.com/remote-work/countries-with-the-fastest-internet-in-the-world/#:~:text=The%20global%20average%20broadband%20internet,Mbps%20(megabits%20per%20second).
The global average broadband internet speed is 11.03Mbps (megabits per second). Based on that, we use the previous finding to assess that the average time to transfer a 3Mo file would be 2s, meaning it would take ~333 s to transfer a 500Mo file. The TTC could then be represented by the following distribution : [Exponential(259.5)] 