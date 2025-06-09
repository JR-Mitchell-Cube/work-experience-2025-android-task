## Work Experience example app - 20 Questions

This repository holds the code for an example app for the 2025 Android work experience.
The app is written in Kotlin using the MVVM architectural pattern.

### 20 questions

This app tries to recreate the game 20 Questions in the form of an app.
If you don't know this game, you can find out some information about it at https://en.wikipedia.org/wiki/Twenty_questions.

This game has two players - a "questioner" and an "answerer".
The Answerer thinks of something that the Questioner has to guess.
The Questioner must then ask yes/no questions that the Answerer must answer, in order to try and
deduce what object they are thinking of.

### The app structure

The app is divided up into 3 tabs.
The first tab is the Question tab - this is where the Questioner can ask questions to try and figure
out what object the Answerer is thinking about.

The third tab is the Answer tab - this is where the Answerer can see the most recently asked
question, and answer it with "Yes" or "No", or confirm that the Questioner has correctly guessed
what they were thinking of.

In the middle is the History tab, where either player can go to see what questions were previously
asked and how they were answered.

The game starts with both players entering their name, and the Answerer writing down the object that
the Questioner has to guess. The phone can be passed between both players, ensuring that no hidden
information is revealed.

Then, the players will take turns, with the Questioner asking a question on the Question tab,
passing the device to the Answerer, and the Answerer responding on the Answer tab.

The game ends with the Questioner winning if they guess the object being thought of, or losing if
they have not guessed after 20 rounds.