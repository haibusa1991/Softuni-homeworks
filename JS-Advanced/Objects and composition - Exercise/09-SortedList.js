function createSortedList() {
    let list = {
        contents: [],
        size: 0,

        sort: function () {
            list.contents.sort((e1, e2) => e1 - e2);
        },

        add: (number) => {
            if (Number.isNaN(number)) {
                return;
            }

            list.contents.push(number);
            list.sort();
            list.size++;
        },

        remove: (index) => {
            if (index < 0 || index >= list.contents.length) {
                return;
            }

            delete list.contents[index];
            list.sort();
            list.size--;
        },

        get: (index) => {
            if (index < 0 || index >= list.contents.length) {
                return;
            }
            return list.contents[index];
        }
    }
    return list;
}

let list = createSortedList();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1));
list.remove(1);
console.log(list.get(1));
