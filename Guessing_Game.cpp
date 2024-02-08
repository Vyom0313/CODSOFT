#include <bits/stdc++.h>
#include <iostream>
using namespace std;

void guess(int rand) {
    int guess;
    for(int i = 0; i < INT_MAX; i++) {
        cout << "Enter your guess";
        cin >> guess;
        if(guess < rand) {
            cout << "Your number is too small. Try again.";
        }
        else if(guess > rand) {
            cout << "Your number is too large. Try again.";
        }
        else {
            cout << "Congratulations. You got the right answer.";
            break;
        }
    }
}

void generate() {
    srand(time(0));
    int randNum = rand() % 100 + 1;
    guess(randNum);
}

int main() {
    cout << "Welcome to the guessing game show. Here we will generate a random number and you will guess it till you get it right.";
    generate();
    return 0;
}

