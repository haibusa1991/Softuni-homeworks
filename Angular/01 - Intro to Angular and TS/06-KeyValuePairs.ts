class KeyValuePair<T,U>{
    private repo;

    constructor() {
        this.repo = new Map;
    }

    setKeyValue(key:T, val:U) {
        this.repo.set(key,val);
    }

    display() {
        this.repo.forEach((e1,e2)=>console.log(`key = ${e2}, value = ${e1}`))
    }
}

let kvp = new KeyValuePair<number, string>();
kvp.setKeyValue(1, "Steve");
kvp.display();
