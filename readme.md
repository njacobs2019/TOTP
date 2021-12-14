This requires two terminals to run.<br />
One terminal functions as the website you are logging into, the other terminal represents what would be your phone authenticator app.<br />
To use the code you first run the AuthenticatorApp.<br />
This file asks you to enter your username (e.g. troy.schotter) and gives you a one time passcode.<br />
You then run the AuthenticatorServer program which asks you to input your username and the given passcode.<br />
If both are right the program tells you that you have successfully logged in.<br />
If either is wrong the program tells you that you have incorrect credentials and asks if you would like to try again and records the incorrect login attempt in the log.
