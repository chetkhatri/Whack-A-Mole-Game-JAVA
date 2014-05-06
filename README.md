Instructions & Guideline to run Whack-a-mole game on local computer
1.	Import  tbgame_master.sql  to mysql localhost and set username=”root” and password=””
2.	Download Whack_a_mole.zip and open it.
3.	Go to Whack_a_mole -> Whack_a_mole->src-> whack_a_mole-> find module.java
a.	Find PasswordAuthentication class and put appropriate your company domain email id and password for sending email to player’s email id using your company domain email id.
b.	Find sentMail method from the module.java and replace “mail.domain.com” to your company’s mail server address and “email@domain.com” to your companies email address. 
4.	To play game goes to Whack_a_mole -> Whack_a_mole-> dist-> Whack_a_mole.jar from Command prompt or directly open it.
5.	When you open the Whack_a_mole.jar or execute the project you will reach to Homescreen of game, to play game go to game menu select Start game
6.	You should have to enter username to play game then click on Start button.
7.	In bottom you will see there is 9 Moles displayed by Button Component, Button will blink randomly you should have to tip it to earn single point, This game will expiry within a 20 seconds from start of game. Timer is displayed at top of moles, Earned points also displayed at top of moles.
8.	Right hand side portions displays Top 3 Players with their Earned Points and Most Common hit Mole
a.	Top 3 Players displays on the basis of the total points accrued over all the games.
9.	Bottom right corner displays Top 3 most common hit moles
a.	This is displayed on the basis of records maintained for all the players
10.	For send email to player after completion of attempt you will see Email textbox and Button, you should have to put correct Email address.
a.	For achieve point:10 facility you should have to configure mail server setting 
i.	Go to Step 3 if you have not completed setting.
11.	To view Player History go to Game menu and Select View History.

If possible then open project in Netbeans IDE, so you should not have to include Environment path of JAVA MAIL API, Netbeans 7.3.1 IDE Version is used to develop this game.
