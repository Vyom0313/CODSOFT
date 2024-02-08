#include <iostream>
using namespace std;

char space[3][3] = {{'1', '2', '3'},
                    {'4', '5', '6'},
                    {'7', '8', '9'}};

int row;
int column;
string n1, n2;
char token = 'x';
bool tie = false;

void generateBoard() {
    cout << n1 << " is player 1 and will play first. \n";
    cout << n2 << " is player 2 and will play second. \n";

    cout << "   |   |   \n";
    cout << " " << space[0][0] << " | " << space[0][1] << " | " << space[0][2] << "  \n";
    cout << "___|___|___\n";
    cout << "   |   |   \n";
    cout << " " << space[1][0] << " | " << space[1][1] << " | " << space[1][2] << "  \n";
    cout << "___|___|___\n";
    cout << "   |   |   \n";
    cout << " " << space[2][0] << " | " << space[2][1] << " | " << space[2][2] << "  \n";
    cout << "   |   |   \n";
}

void validOrNot() {
    int digit;
    if (token == 'x') {
        cout << n1 << ", please enter a position: ";
        cin >> digit;
    } else {
        cout << n2 << ", please enter a position: ";
        cin >> digit;
    }

    row = (digit - 1) / 3;
    column = (digit - 1) % 3;

    if (space[row][column] != 'x' && space[row][column] != 'o') {
        space[row][column] = token;
        token = (token == 'x') ? 'o' : 'x';
    } else {
        cout << "Invalid choice. Please choose an empty space. \n";
        validOrNot();
    }
}

bool whoWins() {
    for (int i = 0; i < 3; i++) {
        if (space[i][0] == space[i][1] && space[i][0] == space[i][2] && space[i][0] != ' ') {
            return true;
        }
        if (space[0][i] == space[1][i] && space[0][i] == space[2][i] && space[0][i] != ' ') {
            return true;
        }
    }

    if ((space[0][0] == space[1][1] && space[0][0] == space[2][2] && space[0][0] != ' ') ||
        (space[0][2] == space[1][1] && space[0][2] == space[2][0] && space[0][2] != ' ')) {
        return true;
    }

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (space[i][j] != 'x' && space[i][j] != 'o') {
                return false;
            }
        }
    }

    tie = true;
    return true;
}

int main() {
    cout << "Enter name of player 1: \n";
    cin >> n1;
    cout << "Enter name of player 2: \n";
    cin >> n2;

    while (!whoWins()) {
        generateBoard();
        validOrNot();
    }

    if (token == 'x' && !tie) {
        cout << n2 << " wins! \n";
    } else if (token == 'o' && !tie) {
        cout << n1 << " wins! \n";
    } else {
        cout << "Game ends in a tie! \n";
    }

    return 0;
}