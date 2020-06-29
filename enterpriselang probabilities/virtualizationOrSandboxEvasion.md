# [Virtualization or Sandbox Evasion](https://attack.mitre.org/techniques/T1497/)

## Adversaries may check for the presence of a virtual machine environment (VME) or sandbox to avoid potential detection of tools and activities. If the adversary detects a VME, they may alter their malware to conceal the core functions of the implant or disengage from the victim. They may also search for VME artifacts before dropping secondary or additional payloads. Adversaries may use the information from learned from Virtualization/Sandbox Evasion during automated discovery to shape follow-on behaviors.

## Findings
According to one report by Symantec called [Internet Security Threat Report, volume 20](http://www.sharetech-me.com/wp-content/uploads/2015/06/21347932_GA-internet-security-threat-report-volume-20-2015-social_v2.pdf), they state that the peak % of malware that was "virtual machine aware" was 28%, but in general it hovered around 18%. -> ```Bernoulli(0.18)```.

## Time to compromise
In general, what malware can do to check if it's running in a virtual environment is outlined in [this document by broadcom](https://docs.broadcom.com/docs/threats-to-virtual-environments-14-en): 
* Check the MAC address of the virtual network adaptor to try and reveal the virtual machine vendor.
* Check the BIOS brand and version to reveal the virtual machine vendor.
* Check certain registry keys that are unique to virtual machines. Often, the virtual machines leave traces in
different registry keys. For example the existence of
“HKEY_LOCAL_MACHINE\HARDWARE\ACPI\DSDT\VBOX__” reveals the presence of VirtualBox.
* Check if helper tools, such as VMware tools, are installed.
* Check for the presence of certain process and service names.
* Check for the presence of specific files, like drivers specific to virtualization.
* Check for communication ports for guest-to-host communication.
* Execute special assembler code and compare the results. Some commands are not implemented or can
behave differently than on physical computers. Other commands take longer to execute and can show a timing
difference.
* Check the location of system structures, such as the interrupt descriptor table (IDT). Virtual systems typically
store the IDT at a higher register than a physical computer does.
* Check for static OS licenses.
* Check dmesg or dmidecode log for entries from virtual devices
To me, it seems like none of these methods will take long at all to carry out, as such I will assume the TTC is instant. 

## Result
```Bernoulli(0.18)```.