# Execution Through Module Load 

## Context 

https://attack.mitre.org/techniques/T1129/
The Windows module loader can be instructed to load DLLs from arbitrary local paths and arbitrary Universal Naming Convention (UNC) network paths. This functionality resides in NTDLL.dll and is part of the Windows Native API which is called from functions like CreateProcess(), LoadLibrary(), etc. of the Win32 API. [1]

The module loader can load DLLs:

via specification of the (fully-qualified or relative) DLL pathname in the IMPORT directory;

via EXPORT forwarded to another DLL, specified with (fully-qualified or relative) pathname (but without extension);

via an NTFS junction or symlink program.exe.local with the fully-qualified or relative pathname of a directory containing the DLLs specified in the IMPORT directory or forwarded EXPORTs;

via <file name="filename.extension" loadFrom="fully-qualified or relative pathname"> in an embedded or external "application manifest". The file name refers to an entry in the IMPORT directory or a forwarded EXPORT.

Adversaries can use this functionality as a way to execute arbitrary code on a system.

## Findings
https://community.broadcom.com/symantecenterprise/communities/community-home/librarydocuments/viewdocument?DocumentKey=bc9e2e2e-028c-4ba1-863f-72a4700dbdc2&CommunityKey=1ecf5f55-9545-44d6-b0f4-4e4a7f5f5e68&tab=librarydocuments
https://www.cybereason.com/blog/information-stealing-malware-targeting-brazil-full-research

Once again this is a core functionality that's being leveraged along with other execution techniques after a successful spearphishing campaign

## Result

for now, We'll use the [Bernoulli(0.93)*Exponential(1)] probability distribution.

## Discussion

If we can be certain that this attack step is an indirect child of spearphishing Attachment then this attack step could be considered as binary. For now, we leave the same probability distribution as for Spearphihing attachment, XSL Script processing, Compiled HTML File and Dynamic Data Exchange.