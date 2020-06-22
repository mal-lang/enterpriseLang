# [Remote File Copy](https://attack.mitre.org/techniques/T1105/)
From MITRE ATT&CK: "Files may be copied from one system to another to stage adversary tools or other files over the course of an operation. Files may be copied from an external adversary-controlled system through the Command and Control channel to bring tools into the victim network or through alternate protocols with another tool such as FTP. Files can also be copied over on Mac and Linux with native tools like scp, rsync, and sftp"

Apparently, according to [Red Canary's Threat Detection Report](https://redcanary.com/threat-detection-report/techniques/remote-file-copy/), this is mostly used in conjunction with the Windows Admin Shares attack step. 
  
## Prevalence
Red Canary states that 29% of organizations are affected. -> ```Bernoulli(0.29)```. 

## TTC 
This attack step is about copying files over, (and according to Red Canary's report also related to downloading binaries), the time to compromise with this particular attack step is the time needed to type a command like scp, like this:
"[```$ scp your_username@remotehost.edu:foobar.txt /some/local/directory```](http://www.hypexr.org/linux_scp_help.php)" which copies a file from a remote host to a local host. Combine the time it takes to type the command (presumably around 10-20 seconds) and then the time it takes for the file to actually copy over. The time to complete this depends on two things.

1. The size of the file and
2. The speed of the connection. 

For simplicity's sake, I use the global average internet speed provided by [speedtest.net](https://www.speedtest.net/global-index), which at the time of writing (2020-06-16) is 76.94 Mb/s which is 9.6175 MB/s. As for the average size of a file, I found a few studies about this, but one was from 1981 and the other from 1999 - probably too old to be relevant still. Instead I used my own computer to calculate the average file size, by typing the [following commands in powershell](https://superuser.com/questions/497583/average-file-size-statistics):
```
$foo = (Get-ChildItem -path "c:\Program Files" -recurse | measure-object | select -expand Count)
$bar = ((Get-ChildItem -path "c:\Program Files" -recurse | Measure-Object -property length -sum).sum /1MB)
$avrg = $bar / $foo
$avrg
```
This counts the average file size of all the files in my C:\Program Files directory. For reference I have 45 folders in my Program Files directory, and is in total 38GB. In the end this came out to 0.1226 MB, which on an average internet connection would take only about 0.013 seconds. Which is certainly negligible. So instead of using an exponential probability distribution to estimate the time needed to complete this attack step, I will only use the Bernoulli probability distribution and assume the time is instant. 

## Result
The probability distribution for this attack step comes out to ```Bernoulli(0.29)```.

## Discussion
The time needed is still highly variable. If the user wanted to copy over a very large file or folder, say one that is several gigabytes in size - then this probability distribution does not accurately reflect that reality. It does base itself on averages which should be fine in most cases though. That said, I used my own computer to calculate average file size which may not be ideal either. 