# bj-compthinking
# Black Jack

## Markus Lu and Thomas Armstrong

Game Concept:
-Standard game of Java except it is the player vs 3 AIs. One of the AI
will count cards and perform the best moves, one will do moves
randomly, and the other doesn’t count cards but has somewhat decent
moves (ex. If it has two cards that add to 10, it will request to hit).
-The player will have the option to either hit or hold while playing
against all three AI.
-Black Jack rules can be found here:
https://www.venetianlasvegas.com/resort/casino/table-games/how-to-play-
blackjack.html#:~:text=In%20Blackjack%2C%20everyone%20plays%20against,a
nd%20the%20wager%20is%20lost.

## Programming Implementation

- **Object-Oriented Design:** There will be a parent class AI with
    three subclasses for each of the different AI. Each AI will have
    different methods for there intelligence
- Dealer class: shuffle method
- There will also be a player class that has the two-player methods
    of hit or hold. These methods will be triggered by using
    buttons/keys on the keyboard.
- **Key Features:** The key features are the 3 ai, the visual
    environment that shows the cards, as well as input for the player
    to say hold or hit.
- **Data Structures:** The game data will likely be stored using 2D
    string-int arrays and arraylists for specifying which number and
    suit has been played or will be played in the future.
- **Algorithms:** The smart AI will have “awareness” of which cards
    have been revealed and will use choices by probabilities of cards
    that will be played. The normal AI, will hit if the difference
    between it and 21 is greater than or equal to 6 or if it will
    lose. The stupid one will have a random 50% 50% chance to hit or
    hold each of its turns unless it gets to 21 then it will
    obviously stop.


## User Interaction & UI (If Applicable)

- The game will have a basic graphical interface and the player
    will interact using their keyboard(ex. p to pause, e to exit, 1
    for hit, 2 for stand)

## Challenges & Feasibility

- The most challenging part will be to write the AI for the smart
    AI to always pick the most intelligent answer based on whats been
    revealed.

## Testing Plan

- The entire game can be tested by the creators and we can also get
    playtesters to see if they can find bugs (Jack Rubiralta)

## Submission Details

- Zipped GitHub Repository, can include repo link if needed
- Additional Files: License, README.md, gitignore

# Proposal Submission Deadline:

**Wednesday, Feb 26, 2025 12:20 pm**

All proposals must be approved before beginning development. Be concise
but thorough in your responses. Good luck designing your game!


