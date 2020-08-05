# [Logon Scripts](https://attack.mitre.org/techniques/T1037/)

## Context
Windows allows logon scripts to be run whenever a specific user or group of users log into a system. The scripts can be used to perform administrative functions, which may often execute other programs or send information to an internal logging server.

If adversaries can access these scripts, they may insert additional code into the logon script to execute their tools when a user logs in. This code can allow them to maintain persistence on a single system, if it is a local script, or to move laterally within a network, if the script is stored on a central server and pushed to many systems. Depending on the access configuration of the logon scripts, either local credentials or an administrator account may be necessary.

## Findings
I found one [source](http://www.hexacorn.com/blog/2014/11/14/beyond-good-ol-run-key-part-18/) mentioning the following "The funny fact is that userinit.exe is relying on environment variables and these can be always abused – this makes it easy to quickly set up a simple persistence mechanism by using the Registry Environment keys." (This persistence mechanism is Logon scripts). This would indicate that an attacker, given the proper access rights (Write access to system or domain logon scripts according to MITRE). This means that the distribution is binary. 

## Time to compromise
According to the [same source as above](http://www.hexacorn.com/blog/2014/11/14/beyond-good-ol-run-key-part-18/), by following the steps outlined below, a potentially malicious installation of a logon script can be achieved. 

* Save the following file as c:\test\UserInitMprLogonScriptlog.bat
```
@echo off             
@echo # 'UserInitMprLogonScript' 
@if exist c:\test\UserInitMprLogonScript.log @del c:\test\UserInitMprLogonScript.log
@echo UserInitMprLogonScript executed !> c:\test\UserInitMprLogonScript.log
@pause
```
* Add the following Registry Entry
```
Windows Registry Editor Version 5.00

[HKEY_CURRENT_USER\Environment]
"UserInitMprLogonScript"="c:\\test\\UserInitMprLogonScript.bat"
```
And then log off, log on again, and you can confirm that it is running by checking if the file c:\test\UserInitMprLogonScript.log exists. I tried this myself and timed it, just to get an estimate of how long it would take. It took me just about 5 minutes in total, which I will use as an estimate of TTC. -> ```Exponential(288)```. 

## Result
```Exponential(288)```