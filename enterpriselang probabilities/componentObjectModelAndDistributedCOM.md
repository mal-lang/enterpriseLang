# Component Object Model and Distributed COM

## Context 

Adversaries may use the Windows Component Object Model (COM) and Distributed Component Object Model (DCOM) for local code execution or to execute on remote systems as part of lateral movement.

COM is a component of the native Windows application programming interface (API) that enables interaction between software objects, or executable code that implements one or more interfaces.Through COM, a client object can call methods of server objects, which are typically Dynamic Link Libraries (DLL) or executables (EXE). DCOM is transparent middleware that extends the functionality of Component Object Model (COM) beyond a local computer using remote procedure call (RPC) technology.

Permissions to interact with local and remote server COM objects are specified by access control lists (ACL) in the Registry. By default, only Administrators may remotely activate and launch COM objects through DCOM.

Adversaries may abuse COM for local command and/or payload execution. Various COM interfaces are exposed that can be abused to invoke arbitrary execution via a variety of programming languages such as C, C++, Java, and VBScript.Specific COM objects also exists to directly perform functions beyond code execution, such as creating a Scheduled Task, fileless download/execution, and other adversary behaviors such as Privilege Escalation and Persistence.

Adversaries may use DCOM for lateral movement. Through DCOM, adversaries operating in the context of an appropriately privileged user can remotely obtain arbitrary and even direct shellcode execution through Office applications  as well as other Windows objects that contain insecure methods.DCOM can also execute macros in existing documents and may also invoke Dynamic Data Exchange (DDE) execution directly through a COM created instance of a Microsoft Office application, bypassing the need for a malicious document.

There is a clear separation there between COM and DCOM. COM is used on the local system and DCOM is used for remote execution.


## Relevant findings 

### TTC
https://www.youtube.com/watch?time_continue=505&v=kjg1vfAQINA&feature=emb_title
https://threatresearch.ext.hp.com/how-ursnif-evades-detection/
This wouldnt take more than 15 minutes for an experienced adversary to leverage DCOM for Lateral Movement. We assume it would be the same to leverage COM for code execution.
The TTC can be assessed with the following probability distribution : [Exponential(96)]

### Prevalence
https://securelist.com/muddywater/88059/
https://threatresearch.ext.hp.com/how-ursnif-evades-detection/
According to this Paper, some commands that can be executed involve an automatic use of the COM component. 
The entire chain of attack relies on social engineering to persuade users to enable macros. The attackers rely on a range of compromised hosts to deliver their attacks. However for this specific step, the COM Objects are called automatically via a malicious script.

We can thus assume that there is no Bernoulli distribution for this attack step.

## Results

The probability distribution for this attack step is [Exponential(96)]

## Discussion

This attack step seems to be the combination of 2 (Remote and Local; DCOM and COM). Maybe the code could be adjusted to take that into account and if so, the distribution might be reconsidered.


