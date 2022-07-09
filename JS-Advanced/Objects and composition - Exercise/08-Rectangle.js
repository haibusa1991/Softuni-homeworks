function rectangle(w, h, color) {
    return {
        width: w,
        height: h,
        color: color.charAt(0).toUpperCase() + color.substring(1),
        calcArea: () => w * h
    }
}

let rect = rectangle(4, 5, 'red');
console.log(rect.width);
console.log(rect.height);
console.log(rect.color);
console.log(rect.calcArea());
