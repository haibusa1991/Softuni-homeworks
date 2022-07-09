function solve() {

    function solve() {
        document.getElementById('selectMenuTo').innerHTML = '<option value="binary">Binary</option><option value="hexadecimal">Hexadecimal</option>';
        document.querySelector('button').addEventListener('click', btnClick)

        function btnClick() {
            let convert = {
                binary: (number) => {
                    return Number(number).toString(2)
                },
                hexadecimal: (number) => {
                    return Number(number).toString(16).toUpperCase()
                }
            }

            let inputNumber = document.getElementById('input').value;
            let conversionOptions = document.getElementById('selectMenuTo').children;
            if(conversionOptions[0].selected){
                document.getElementById('result').value = Number(inputNumber).toString(2);
            } else {
                document.getElementById('result').value = Number(inputNumber).toString(16).toUpperCase();
            }
            // for (let option of conversionOptions) {
            //     if (option.selected) {
            //         let o = option.value;
            //         document.getElementById('result').value = convert[o](inputNumber);
            //     }
            // }
        }
    }

}