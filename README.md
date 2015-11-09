SleepyKitty
--------------------------------------------------------------------------------
SleepyKitty is an application that shuts down the Android phone after 3 failed 
unlock attempts. To shut down the phone, it requires root permissions.

Why?
--------------------------------------------------------------------------------
If you encrypt your phone, you need a strong password. You do not want this 
password to be your screen password because unlocking your phone would take 
very long, due to the strength of the chosen password. Hence, you use a short
PIN as your screen password. However, now someone could brute force this PIN
when your phone is stolen. SleepyKitty solves this problem. After the weak
screen password is entered wrong three times in a row, it simply shuts down the
phone. Now, the data is back to its encrypted state and can only be accessed
with the strong disk encryption password.

How?
--------------------------------------------------------------------------------
When you run SleepyKitty, it will attempt to gain root permissions. This is 
because shutting down your phone requires root permissions. If you want the 
application to work, you will have to give it root permissions and check the
checkbox that says "remember my choice" so SleepyKitty can elevate to root
when it wants to initiate the shutdown. 
The second thing SleepyKitty will do is install itself as Device Administrator,
in order to monitor the lock screen. 

Enjoy!
