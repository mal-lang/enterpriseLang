# [Path Interception](https://attack.mitre.org/techniques/T1034/)

## Context
>Path interception occurs when an executable is placed in a specific path so that it is executed by an application instead of the intended target. One example of this was the use of a copy of cmd in the current working directory of a vulnerable application that loads a CMD or BAT file with the CreateProcess function.

## Findings
A report from FireEye, [M-Trends 2020](https://content.fireeye.com/m-trends/rpt-m-trends-2020) finds that Path Interception was used in 3.52% of all "attack lifecycles", when it comes to the category of privilege escalation. I'm not able to find another probability of how often this is used, 

## Time to compromise
On [hexacorn.com](http://www.hexacorn.com/blog/2016/03/26/beyond-good-ol-run-key-part-37/) the author goes over an example of how to abuse this.
>Let’s look at an example – we could add something like this to ```HKCU\…\Run```:
>    ```rundll32.exe c:\Program Files\Internet Explorer\ieproxy.dll```
>and then drop:
>    ```c:\Program.dll```
>or
>    ```c:\Program Files\Internet.dll```
>which rundll32.exe would then hopefully load for us.

From this, it seems like all that's really required is to name your program something that could cause ```rundll32.exe``` to load it when searching for another (legit) program. This seems like it might take a minute at most to write. The author of the article cited above even states that this is a "simple yet powerful way [...] to gain persistence". Thus I will assume that the TTC is instant. 

## Result

```Bernoulli(0.0352)```

## Discussion
I'm not able to find another source on how often this particular vulnerability is abused by malware, so for now I will assume that this source is good enough. 