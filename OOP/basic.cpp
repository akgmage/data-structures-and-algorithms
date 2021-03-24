// Program Author :  Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;
class Car{
    public:
        int price;
        int model_no;
        char name[20];
};
int main(){
    Car C;
    cout << sizeof(C) << "\n";
    cout << sizeof(Car);
    return 0;
}