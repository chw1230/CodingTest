#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    getline(cin,s);
    
    for (char &c : s) {
        if ( 'A' <= c && c <= 'Z') {
            c += 32;
        } else {
            c -= 32;
        }
    }
    
    cout << s;
    return 0;
}