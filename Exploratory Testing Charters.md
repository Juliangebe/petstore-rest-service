# Exploratory testing  charters

## Charter: Passcode protection functionality.
Areas:  
* Passcode.
* Fingerprint.
* Passcode required time.

Tester: Julián Galeano Bolívar.

Task Breakdown:
* Check fingerprint functionality.
* Test passcode functionality.
* Check the time the passcode is required

Duration: 60 min.

Test Notes:
Passcode activation was performed.<br>
A numeric passcode has been set, to verify that it is required to use the application.<br>
The configured passcode requirement was verified<br>
The times in which the password was required were verified in ranges of 2 and 15 minutes.<br>
The use of fingerprint was activated.<br>
The operation of the fingerprint was validated.<br>
The times in which the fingerprint was required were verified in ranges of 2 and 15 minutes.<br>
The passcode protection has been deactivated and it is verified that it is not necessary.<br>
Unlocking by sensor is faster than by passcode<br>

Opportunity:
* More authentication methods can be added, such as by pattern, face id.
* Customizable time range.
* When the fingerprint is activated, it no longer requires the pin and the possible risks are that several people have the fingerprint

Risks:
* Identity theft.
* A 4-digit lock pin means that the possible combinations are many, but limited.

Bugs: No bug found.

## Charter: Data backup validation.
Areas:  
* Backup data creation.
* Restore data.
* Clear data.

Tester: Julián Galeano Bolívar.

Task Breakdown:
* Generate data to later be able to validate its restoration.
* Backup data creation for data restore.
* Restore data to test the functionality and data integrity.
* Clear data to verify functionality and information.

Duration: 60 min.

Test Notes:
The data was generated and then a backup was made.<br>
Data cleaned to verify functionality.<br>
The information was restored through the backup and its integrity was verified.<br>
Tested functionalities worked as expected.<br>

Opportunity: 
* Have the option of backing up to another type of file.
* Implement automatic backups regularly.
* Use End-to-End Encryption.
* Implement Automated Backups with Synchronization.

Risks:
* Loss of information.
* Data theft.
* Equipment damage.
* Information leakage.

Bugs: No bug found.

