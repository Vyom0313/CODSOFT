//this program allows for the user to enter two numbers and
//perform basic arthimetic operations like addition, subtraction, multiplication, division.
#include <bits/stdc++.h>
#include <iostream>
using namespace std;

void calculator(int a, int b) {
    cout << "+ --> addition \n - --> subtraction \n * --> multiplication \n / --> division with quotient \n % --> division with remainder.\n";
    char c;
    cin >> c;
    switch(c) {
        case '+':
            cout << a + b;
            break;
        case '-':
            cout << a - b;
            break;
        case '*':
            cout << a * b;
            break;
        case '/':
            cout << a / b;
            break;
        case '%':
            cout << a % b;
            break;
        default:
            cout << "Invalid operation.\n";
    }
}

int main() {
    cout << "Enter two numbers.\n";
    int a, b;
    cin >> a;
    cin >> b;
    calculator(a, b);
    return 0;
}