# [Screensaver](https://attack.mitre.org/techniques/T1180/)

## Context
>Screensavers are programs that execute after a configurable time of user inactivity and consist of Portable Executable (PE) files with a .scr file extension. The Windows screensaver application scrnsave.scr is located in C:\Windows\System32\, and C:\Windows\sysWOW64\ on 64-bit Windows systems, along with screensavers included with base Windows installations. 

## Findings
This [wikia.org](https://malware.wikia.org/wiki/MyDoom) entry on a malware called MyDoom, which uses screensaver file extensions (.scr). According to an [article](https://unit42.paloaltonetworks.com/mydoom-still-active-in-2019/) on the malware by Palo Alto Networks Unit 42, MyDoom "held an average of 21.4 percent for all individual malware attachments seen through malicious emails." MyDoom is primarily delivered through phishing emails. [This article](https://www.menlosecurity.com/blog/only-4-percent-of-users-click-on-phishing-emails.-yet-those-4-percent-never-learn) finds that 4% of users click on a malicious link in a phishing email, while [this book](https://books.google.se/books?id=RFByDwAAQBAJ&pg=PA292&lpg=PA292&dq=%22percent%22+that+download+attachments+from+phishing+emails&source=bl&ots=nyNh_Z5C7t&sig=ACfU3U2BQ37f_0X2I17nNwLRfDgI7ORVYw&hl=en&sa=X&ved=2ahUKEwi-hImn2rrqAhVq2aYKHcMCBokQ6AEwC3oECGYQAQ#v=onepage&q=%22percent%22%20that%20download%20attachments%20from%20phishing%20emails&f=false) reports on a verizon study that found that 11% of users will download an attachment from a phishing email. The average of these two is (11 + 4)/2 = 7.5%, so 21.4*0.075 = 1.605%. I will use this number to estimate the prevalence of this kind of malware. -> ```Bernoulli(0.01605)```. 

## Time to compromise
The steps that the malware Gazer performs regarding the Screensaver technique is outlined by [ESET here](https://www.welivesecurity.com/wp-content/uploads/2017/08/eset-gazer.pdf). These steps are:

>Create values under the HKCU\Control Panel\Desktop registry key:
* SCRNSAVE.exe with the malware executable path
* ScreenSaveActive is set to “1”: enable the screensaver
* ScreenSaverIsSecure is set to “0”: specifies that the screensaver is not password-protected
* ScreenSaveTimeout is set to a value given in the resource. It specifies how long the system remains idle before the screensaver (in this case: the malware) starts.

So we can estimate that the TTC for this step is the time until the screensaver actually activates, which can vary. Apparently the default is 15 minutes (900 seconds). This is 1/96th of one day, so if we use this as the TTC estimate, we get ```Exponential(96)```. 

## Results
````Bernoulli(0.01605)*Exponential(96)````
