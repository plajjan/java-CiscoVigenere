Java library for Cisco Vigenere encryption and decryption
=========================================================
This is a Java library for encryption and decryption of the Cisco "type 7"
password which use a modified Vigenere algorithm.

Usage is simple as the class already includes the Cisco key - just call those
methods yo!

Why does this exist?
--------------------
If you are trying to provision certain passwords, such as an IS-IS
lsp-password, to an IOS XR box over NETCONF/YANG you will notice that it
requires an already encrypted key. 

If you are using Cisco NSO (formerly Tail-F NCS) to do your provisioning you
are likely writing Java code and if your input key is cleartext it means you
have to encrypt it before you send it to the device. Thus requiring something
like this library.
