# Hello I am Esteban Marin

## Here are the answers to the questions:
### Problem 6
Write a short paragraph about your proudest achievement. Can you describe it? What was your role in it? Why is it important to you and what have you learnt from it?

My proudest achievement is getting comfortable doing Functional Scala because it has been the hardest thing I've done in my career. It has though me lovely abstract ideas and has presented me with an inviting, inclusive open-source community. Having this in my life has been life-changing. 

I have learned that: everything in life is hard work, resilience and a group effort, but it has to be done with love. 

### Run the code 
```shell
$ paidly> sbt run
```

### Problem 1
Write a function that takes an Integer and returns it as a string with the correct ordinal indicator suffix (in English). Examples: 1 => 1st, 2 => 2nd.

### Problem 2
Write a function that takes two dates (date_from, date_to, in dd-mm-yyyy format) and returns the number of Sundays in that range. Example: (‘01-05-2021’, ‘30-05-2021’) => 5.

### Problem 3
Mask personal information: create a function that takes a String as input and returns it partly obfuscated. The function only recognizes emails and phone numbers, any other String that doesn’t match these types results in an error.

### Problem 4
Emails: emails need to be in a valid email format. To obfuscate it, it should be converted to lowercase and all characters in the local-part between the first and last should be replaced by 5 asterisks (*). Example: local-part@domain-name.com => l*****t@domain-name.com.

### Problem 5
Phone numbers: a phone number consists of at least 9 digits (0-9) and may contain these two characters (‘ ‘, ‘+’) where ‘+’ is only accepted when is the first character. To obfuscate it, spaces (‘ ‘) are converted to dashes (‘-’), any digit is converted to an asterisk (‘*’) except for the last 4, which remain unchanged and the plus sign (‘+’) also remains unchanged (if present). Example: +44 123 456 789 => +**-***-**6-789.

 