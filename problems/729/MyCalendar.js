/**
 * Created by lillard on 11/27/17.
 */


var MyCalendar = function() {
    this.bookedList = []
};

/**
 * @param {number} start
 * @param {number} end
 * @return {boolean}
 */
MyCalendar.prototype.book = function(start, end) {
    for (let pair of this.bookedList) {
        if (pair.start < start && start < pair.end) {
            return false;
        }
        if (pair.start >= start && pair.start < end) {
            return false;
        }
    }

    this.bookedList.push({start, end});
    return true
};

const myCalendar = new MyCalendar();
console.log(myCalendar.book(10, 20)); // returns true
console.log(myCalendar.book(15, 25)); // returns false
console.log(myCalendar.book(20, 30)); // returns true
