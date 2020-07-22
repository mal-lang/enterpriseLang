# Gatekeeper Bypass

## Context (https://attack.mitre.org/techniques/T1553/001/)

Adversaries may modify file attributes that signify programs are from untrusted sources to subvert Gatekeeper controls. In macOS and OS X, when applications or programs are downloaded from the internet, there is a special attribute set on the file called com.apple.quarantine. This attribute is read by Apple's Gatekeeper defense program at execution time and provides a prompt to the user to allow or deny execution.

*Apps loaded onto the system from USB flash drive, optical disk, external hard drive, or even from a drive shared over the local network won’t set this flag*. *Additionally, it is possible to avoid setting this flag using Drive-by Compromise*. This completely bypasses the built-in Gatekeeper check. he presence of the quarantine flag can be checked by the xattr command xattr /path/to/MyApp.app for com.apple.quarantine. Similarly,* given sudo access or elevated permission, this attribute can be removed* with xattr as well, sudo xattr -r -d com.apple.quarantine /path/to/MyApp.app.

In typical operation, a file will be downloaded from the internet and given a quarantine flag before being saved to disk. When the user tries to open the file or application, macOS’s gatekeeper will step in and check for the presence of this flag. If it exists, then macOS will then prompt the user to confirmation that they want to run the program and will even provide the URL where the application came from. However, this is all based on the file being downloaded from a quarantine-savvy application. 

There are 3 different ways of performing this technique, as suggested by the MITRE description : 

- The adversary has Admin Rights and can thus remove the flag, bypassing gatekeeper.
- The adversary has User Rights and physical access to the network (can perform Hardware Addition), they can thus use physical hardware to bypass gatekeeper.
- The adversary has User Rights and performed Drive-By Compromise, bypassing gatekeeper.

## Code change

I added those lines to separate into 3 the technique.

```     
        & gatekeeperBypassViaDriveByCompromise
            -> attemptGatekeeperBypass
        
        & gatekeeperBypassViaHardwareAddition
            -> attemptGatekeeperBypass

        & gatekeeperBypassViaAdminRights
            -> attemptGatekeeperBypass

        | attemptGatekeeperBypass 
            -> gatekeeperBypass

        & gatekeeperBypass
            developer info: "Binary probability distribution."
            user info: "Apps loaded onto the system from USB flash drive, optical disk, external hard drive, or even from a drive shared over the local network won't set this flag. Additionally, other utilities or events like drive-by downloads don't necessarily set it either. This completely bypasses the built-in Gatekeeper check."
            ->  bypassApplicationWhitelisting,
                bypassAntivirus 
```

## Results

Once they have one of the parents, the adversary can instantly perform this technique. We assess the probability distribution for this technique as Binary. The probability are borne by the different parents in each case.