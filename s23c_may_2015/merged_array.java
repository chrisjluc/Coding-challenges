int i = M - 1;
int j = M - 1;
int k = 2*M - 1;
while(k >= 0){
    if(j < 0 || (i >= 0 && a[i] > b[j])){
        b[k] = a[i];
        i--;
    }else{
        b[k] = b[j];
        j--;
    }
    k--;
}
