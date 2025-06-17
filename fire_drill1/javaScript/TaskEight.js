    int totalSum = 0;

        for (let i = 1; i <= 10; i++) {

            if (i >= 4 && i % 4 == 0) {
                let temp = i;
                let count = 0;
                let sum = 0;
                 while(count <= 4){
                 sum = sum + temp;


                 temp = temp * i;

                 count ++;


                 }
                 console.log(sum)
                 totalSum += sum;



            }

        }
        console.log(totalSum)



