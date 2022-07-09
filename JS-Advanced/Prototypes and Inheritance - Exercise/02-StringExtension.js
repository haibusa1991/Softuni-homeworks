(function solve() {

    function ensureStart(string) {
        let startsWith = this.slice(0, string.length);
        if (startsWith === string) {
            return this.toString();
        }

        return string + this.toString();
    }

    function ensureEnd(string) {
        let endsWith = this.slice(-string.length);
        if (endsWith === string) {
            return this.toString();
        }

        return this.toString() + string;
    }

    function isEmpty() {
        return this.toString().length === 0;
    }

    function truncate(n) {
        let words = this.toString().split(' ');

        if (words.length === 0) {
            return '';
        }

        if (this.length <= n) {
            return this.toString();
        }

        while (words.length > 0) {
            let lastWord = words.pop();
            if (words.length === 0) {
                return truncateWord(lastWord);
            }

            if (words.join(' ').length + 3 <= n) {
                return words.join(' ') + '...';
            }
        }

        function truncateWord(word) {
            if (word.length <= n && this.toString().length <= n) {
                return word;
            }

            if (n < 4) {
                let result = '';
                for (let i = 0; i < n; i++) {
                    result += '.';
                }
                return result;
            }

            return word.slice(0, n - 3) + '...';
        }

    }

    function format(inputStr, ...params) {
        let regex = new RegExp('{\\d}', 'g');
        let placeholders = inputStr.match(regex);

        let result = inputStr;
        for (let word of params) {
            result = result.replace(placeholders.shift(), word);
        }

        return result;
    }

    String.prototype.ensureStart = ensureStart;
    String.prototype.ensureEnd = ensureEnd;
    String.prototype.isEmpty = isEmpty;
    String.prototype.truncate = truncate;
    String.format = format;

})()